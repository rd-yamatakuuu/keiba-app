package com.keiba_app.app.repository;

import com.keiba_app.app.controller.SearchRaceHistory.SearchRaceHistoryRequestParameter;
import com.keiba_app.app.controller.SearchRaceHistory.SearchRaceHistoryResponseParameter;
import com.keiba_app.app.domain.entity.RaceHistory;
import lombok.RequiredArgsConstructor;
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
        WHERE (:#{#param.raceCourse} IS NULL OR trwrn.race_course = :#{#param.raceCourse})
            AND (:#{#param.placeCondition} IS NULL OR trwrn.place_condition = :#{#param.placeCondition})
            AND (:#{#param.raceName} IS NULL OR trwrn.race_name = :#{#param.raceName})
            AND (:#{#param.courseLength} IS NULL OR trwrn.course_length = :#{#param.courseLength})
            AND (:#{#param.raceTime} IS NULL OR trwrn.race_time = :#{#param.raceTime})
            AND (:#{#param.year} IS NULL OR trwrn.year = :#{#param.year})
            AND (:#{#param.horseName} IS NULL OR trwrn.horse_name = :#{#param.horseName})
            AND (:#{#param.sex} IS NULL OR trwrn.sex = :#{#param.sex})
            AND (:#{#param.old} IS NULL OR trwrn.old = :#{#param.old})
            AND (:#{#param.jockeyName} IS NULL OR trwrn.jockey_name = :#{#param.jockeyName})
            AND (:#{#param.raceOrder} IS NULL OR trwrn.race_order = :#{#param.raceOrder})
        limit 20
        ;
    """;
    @Query(value=SEARCH_QUERY, nativeQuery = true)
    List<Map<String, Object>> findByConditions(
            @Param("param") SearchRaceHistoryRequestParameter param
    );
}

/**
@Repository
public interface RaceHistoryRepository {
    @Query

}
**/