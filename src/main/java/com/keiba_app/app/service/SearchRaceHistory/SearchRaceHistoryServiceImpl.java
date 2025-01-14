package com.keiba_app.app.service.SearchRaceHistory;

import com.keiba_app.app.constant.enums.CourseLength;
import com.keiba_app.app.constant.enums.PlaceCondition;
import com.keiba_app.app.constant.enums.RaceCourse;
import com.keiba_app.app.constant.enums.Sex;
import com.keiba_app.app.controller.SearchRaceHistory.SearchRaceHistoryRequestParameter;
import com.keiba_app.app.controller.SearchRaceHistory.SearchRaceHistoryResponseParameter;
import com.keiba_app.app.dto.RaceHistoryDto;
import com.keiba_app.app.exception.TooManyResultsException;
import com.keiba_app.app.repository.RaceHistoryRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class SearchRaceHistoryServiceImpl implements SearchRaceHistoryService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final RaceHistoryRepository raceHistoryRepository;
    private static final long MAX_RESULTS = 100;

    @Autowired
    public SearchRaceHistoryServiceImpl(RaceHistoryRepository raceHistoryRepository){
        this.raceHistoryRepository = raceHistoryRepository;
    }

    @Override
    public List<SearchRaceHistoryResponseParameter> searchRaceHistoryByCondition(
            RaceHistoryDto requestParameter) {
        logger.info("SearchRaceHistoryServiceImpl requestParam: {}", requestParameter);

        long count = raceHistoryRepository.countByConditions(requestParameter);

        System.out.println("count: " + count);

        if (count > MAX_RESULTS) {
            throw new TooManyResultsException(
                    "検索結果が" + count + "件あります。" + MAX_RESULTS + "件以下に絞り込んでください。"
            );
        }

        logger.info("SearchRaceHistoryServiceImpl response: {}", raceHistoryRepository.findByConditions(requestParameter));

        logger.debug("Search parameters in Service: {}", requestParameter);

        // ここでクエリ実行前のパラメータを確認
        logger.debug("RaceCourse value: {}", requestParameter.getRaceCourse());
        /*
        List<Map<String, Object>> rawResults = raceHistoryRepository.findByConditions(requestParameter);

        return rawResults.stream()
                .map(row -> {
                    SearchRaceHistoryResponseParameter response = new SearchRaceHistoryResponseParameter();
                    response.setRaceCourse((String) row.get("raceCourse"));
                    response.setPlaceCondition((String) row.get("placeCondition"));
                    response.setRaceOrder((String) row.get("raceOrder"));
                    response.setCourseLength(String.valueOf(row.get("courseLength")));
                    response.setRaceTime((String) row.get("raceTime"));
                    response.setYear((String) row.get("year"));
                    response.setHorseName((String) row.get("horseName"));
                    response.setSex((String) row.get("sex"));
                    response.setOld(String.valueOf(row.get("old")));
                    response.setJockeyName((String) row.get("jockeyName"));
                    response.setRaceOrder((String) row.get("raceOrder"));
                    return response;
                })
                .collect(Collectors.toList());
        */
        List<Map<String, Object>> rawResults = raceHistoryRepository.findByConditions(requestParameter);
        logger.debug("Raw results from repository: {}", rawResults);

        return rawResults.stream()
                .map(row -> {
                    SearchRaceHistoryResponseParameter response = new SearchRaceHistoryResponseParameter();

                    // 競馬場の変換処理（searchCodeから表示名へ）
                    String raceCourseCode = (String) row.get("raceCourse");
                    RaceCourse raceCourse = RaceCourse.fromSearchCode(raceCourseCode);
                    response.setRaceCourse(raceCourse != null ? raceCourse.getDisplayName() : raceCourseCode);

                    // 馬場状態の変換
                    String placeConditionValue = (String) row.get("placeCondition");
                    PlaceCondition placeCondition = PlaceCondition.valueOf(placeConditionValue);
                    response.setPlaceCondition(placeCondition != null ? placeCondition.getDisplayName() : placeConditionValue);

                    // コース距離の変換
                    Object courseLengthValue = row.get("courseLength");
                    if (courseLengthValue != null) {
                        CourseLength courseLength = CourseLength.fromMeters(((Number) courseLengthValue).intValue());
                        response.setCourseLength(courseLength != null ? courseLength.getDisplayName() : String.valueOf(courseLengthValue));
                    }

                    // 性別の変換
                    String sexValue = (String) row.get("sex");
                    if (sexValue != null) {
                        Sex sex = Sex.valueOf(sexValue);
                        response.setSex(sex != null ? sex.getDisplayName() : sexValue);
                    }

                    // その他のフィールド
                    response.setRaceName((String) row.get("raceName"));
                    response.setRaceTime((String) row.get("raceTime"));
                    response.setYear((String) row.get("year"));
                    response.setHorseName((String) row.get("horseName"));
                    response.setOld(String.valueOf(row.get("old")));
                    response.setJockeyName((String) row.get("jockeyName"));
                    response.setRaceOrder((String) row.get("raceOrder"));

                    return response;
                })
                .collect(Collectors.toList());

    }
}
