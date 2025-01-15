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
                 WHERE
                     (:#{#param.raceCourse} = '' OR trwrn.race_course = :#{#param.raceCourse})
                     AND (:#{#param.placeCondition} = '' OR trwrn.place_condition = :#{#param.placeCondition})
                     AND (:#{#param.raceName} = '' OR trwrn.race_name LIKE CONCAT('%', :#{#param.raceName}, '%'))
                     AND (:#{#param.courseLength} = '' OR trwrn.course_length = :#{#param.courseLength})
                     AND (:#{#param.raceTime} = '' OR trwrn.race_time = :#{#param.raceTime})
                     AND (:#{#param.year} = '' OR trwrn.year = :#{#param.year})
                     AND (:#{#param.horseName} = '' OR trwrn.horse_name LIKE CONCAT('%', :#{#param.horseName}, '%'))
                     AND (:#{#param.sex} = '' OR trwrn.sex = :#{#param.sex})
                     AND (:#{#param.old} = '' OR trwrn.old = :#{#param.old})
                     AND (:#{#param.jockeyName} = '' OR trwrn.jockey_name LIKE CONCAT('%', :#{#param.jockeyName}, '%'))
                     AND (:#{#param.raceOrder} = '' OR trwrn.race_order = :#{#param.raceOrder})
                ;
            """;

    @Query(value = SEARCH_QUERY, nativeQuery = true)
    List<Map<String, Object>> findByConditions(@Param("param") RaceHistoryDto param);


    String COUNT_SEARCH_QUERY = """
                SELECT
                    count(*)
                FROM t_race_with_race_name trwrn
                WHERE
                     (:#{#param.raceCourse} = '' OR trwrn.race_course = :#{#param.raceCourse})
                     AND (:#{#param.placeCondition} = '' OR trwrn.place_condition = :#{#param.placeCondition})
                     AND (:#{#param.raceName} = '' OR trwrn.race_name LIKE CONCAT('%', :#{#param.raceName}, '%'))
                     AND (:#{#param.courseLength} = '' OR trwrn.course_length = :#{#param.courseLength})
                     AND (:#{#param.raceTime} = '' OR trwrn.race_time = :#{#param.raceTime})
                     AND (:#{#param.year} = '' OR trwrn.year = :#{#param.year})
                     AND (:#{#param.horseName} = '' OR trwrn.horse_name LIKE CONCAT('%', :#{#param.horseName}, '%'))
                     AND (:#{#param.sex} = '' OR trwrn.sex = :#{#param.sex})
                     AND (:#{#param.old} = '' OR trwrn.old = :#{#param.old})
                     AND (:#{#param.jockeyName} = '' OR trwrn.jockey_name LIKE CONCAT('%', :#{#param.jockeyName}, '%'))
                     AND (:#{#param.raceOrder} = '' OR trwrn.race_order = :#{#param.raceOrder})
            """;

    @Query(value = COUNT_SEARCH_QUERY, nativeQuery = true)
    long countByConditions(
            @Param("param") RaceHistoryDto param
    );
}
