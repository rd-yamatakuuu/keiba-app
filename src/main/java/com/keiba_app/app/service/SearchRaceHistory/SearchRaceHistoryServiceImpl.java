package com.keiba_app.app.service.SearchRaceHistory;

import com.keiba_app.app.controller.SearchRaceHistory.SearchRaceHistoryRequestParameter;
import com.keiba_app.app.controller.SearchRaceHistory.SearchRaceHistoryResponseParameter;
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

    @Autowired
    public SearchRaceHistoryServiceImpl(RaceHistoryRepository raceHistoryRepository){
        this.raceHistoryRepository = raceHistoryRepository;
    }

    @Override
    public List<SearchRaceHistoryResponseParameter> searchRaceHistoryByCondition(
            SearchRaceHistoryRequestParameter requestParameter) throws Exception {
        logger.info("SearchRaceHistoryServiceImpl requestParam: {}", requestParameter);
        logger.info("SearchRaceHistoryServiceImpl response: {}", raceHistoryRepository.selectAll());

        List<Map<String, Object>> rawResults = raceHistoryRepository.selectAll();

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

    }
}
