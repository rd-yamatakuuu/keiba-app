package com.keiba_app.app.repository;

import com.keiba_app.app.controller.SearchRaceHistory.SearchRaceHistoryRequestParameter;
import com.keiba_app.app.controller.SearchRaceHistory.SearchRaceHistoryResponseParameter;
import com.keiba_app.app.domain.entity.RaceHistory;
import com.keiba_app.app.dto.RaceHistoryDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RaceHistoryRepository extends JpaRepository<RaceHistory, Integer> {

    String SEARCH_QUERY = """
                SELECT
                    race_course AS raceCourse,
                    place_condition AS placeCondition,
                    race_name AS raceName,
                    course_length AS courseLength,
                    race_time AS raceTime,
                    year AS year,
                    horse_name AS horseName,
                    sex AS sex,
                    old AS old,
                    jockey_name AS jockeyName,
                    race_order AS raceOrder
                FROM t_race_with_race_name trwrn
                 /*%n WHERE %n*/
                WHERE
                     trwrn.race_course = COALESCE(:#{#param.raceCourse}, trwrn.race_course)
                     AND trwrn.place_condition = COALESCE(:#{#param.placeCondition}, trwrn.place_condition)
                     AND trwrn.race_name LIKE CONCAT('%', COALESCE(:#{#param.raceName}, ''), '%')
                     AND trwrn.course_length = COALESCE(:#{#param.courseLength}, trwrn.course_length)
                     AND trwrn.race_time = COALESCE(:#{#param.raceTime}, trwrn.race_time)
                     AND trwrn.year = COALESCE(:#{#param.year}, trwrn.year)
                     AND trwrn.horse_name LIKE CONCAT('%', COALESCE(:#{#param.horseName}, ''), '%')
                     AND trwrn.sex = COALESCE(:#{#param.sex}, trwrn.sex)
                     AND trwrn.old = COALESCE(:#{#param.old}, trwrn.old)
                     AND trwrn.jockey_name LIKE CONCAT('%', COALESCE(:#{#param.jockeyName}, ''), '%')
                     AND trwrn.race_order = COALESCE(:#{#param.raceOrder}, trwrn.race_order)
                ;
            """;

    @Query(value = SEARCH_QUERY, nativeQuery = true)
    List<Map<String, Object>> findByConditions(@Param("param") RaceHistoryDto param);


    String COUNT_SEARCH_QUERY = """
                SELECT
                    count(*)
                FROM t_race_with_race_name trwrn
                WHERE
                     trwrn.race_course = COALESCE(:#{#param.raceCourse}, trwrn.race_course)
                     AND trwrn.place_condition = COALESCE(:#{#param.placeCondition}, trwrn.place_condition)
                     AND trwrn.race_name LIKE CONCAT('%', COALESCE(:#{#param.raceName}, ''), '%')
                     AND trwrn.course_length = COALESCE(:#{#param.courseLength}, trwrn.course_length)
                     AND trwrn.race_time = COALESCE(:#{#param.raceTime}, trwrn.race_time)
                     AND trwrn.year = COALESCE(:#{#param.year}, trwrn.year)
                     AND trwrn.horse_name LIKE CONCAT('%', COALESCE(:#{#param.horseName}, ''), '%')
                     AND trwrn.sex = COALESCE(:#{#param.sex}, trwrn.sex)
                     AND trwrn.old = COALESCE(:#{#param.old}, trwrn.old)
                     AND trwrn.jockey_name LIKE CONCAT('%', COALESCE(:#{#param.jockeyName}, ''), '%')
                     AND trwrn.race_order = COALESCE(:#{#param.raceOrder}, trwrn.race_order)
                ;
            """;

    @Query(value = COUNT_SEARCH_QUERY, nativeQuery = true)
    long countByConditions(
            @Param("param") RaceHistoryDto param
    );
}
