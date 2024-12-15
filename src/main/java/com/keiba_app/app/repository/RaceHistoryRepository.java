package com.keiba_app.app.repository;

import com.keiba_app.app.controller.SearchRaceHistory.SearchRaceHistoryResponseParameter;
import com.keiba_app.app.domain.entity.RaceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
        FROM t_race_with_race_name limit 20;
    """;

    @Query(value=SEARCH_QUERY, nativeQuery = true)
    List<Map<String, Object>> selectAll();
}
