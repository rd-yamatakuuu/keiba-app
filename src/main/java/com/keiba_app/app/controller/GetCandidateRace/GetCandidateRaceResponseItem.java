package com.keiba_app.app.controller.GetCandidateRace;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class GetCandidateRaceResponseItem {
    @JsonProperty("date_id")
    private String dateId;

    @JsonProperty("year")
    private String year;

    @JsonProperty("race_course")
    private String raceCourse;

    @JsonProperty("held")
    private String held;

    @JsonProperty("race_date")
    private String raceDate;

    @JsonProperty("race_time")
    private String raceTime;

    @JsonProperty("start_time")
    private String startTime;

    @JsonProperty("place_env")
    private String placeEnv;

    @JsonProperty("course_length")
    private Integer courseLength;

    @JsonProperty("course_curve")
    private String courseCurve;

    @JsonProperty("weather")
    private String weather;

    @JsonProperty("place_condition")
    private String placeCondition;

    @JsonProperty("start_position")
    private String startPosition;

    @JsonProperty("horse_num")
    private String horseNum;

    @JsonProperty("horse_id")
    private String horseId;

    @JsonProperty("horse_name")
    private String horseName;

    @JsonProperty("sex")
    private String sex;

    @JsonProperty("old")
    private Integer old;

    @JsonProperty("burden_weight")
    private Double burdenWeight;

    @JsonProperty("jockey_id")
    private String jockeyId;

    @JsonProperty("jockey_name")
    private String jockeyName;

    @JsonProperty("trainer_id")
    private String trainerId;

    @JsonProperty("stable")
    private String stable;

    @JsonProperty("weight")
    private Integer weight;

    @JsonProperty("weight_change")
    private Integer weightChange;

    @JsonProperty("kaisai_date")
    private String kaisaiDate;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

}