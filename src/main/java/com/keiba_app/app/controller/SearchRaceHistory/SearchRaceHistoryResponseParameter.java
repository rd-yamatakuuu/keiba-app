package com.keiba_app.app.controller.SearchRaceHistory;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchRaceHistoryResponseParameter {

    @JsonProperty("race_course")
    private String raceCourse;

    @JsonProperty("place_condition")
    private String placeCondition;

    @JsonProperty("race_name")
    private String raceName;

    @JsonProperty("course_length")
    private Long courseLength;

    @JsonProperty("race_time")
    private String raceTime;

    @JsonProperty("year")
    private String year;

    @JsonProperty("horse_name")
    private String horseName;

    @JsonProperty("sex")
    private String sex;

    @JsonProperty("old")
    private Long old;

    @JsonProperty("jockey_name")
    private String jockeyName;

    @JsonProperty("race_order")
    private String raceOrder;

}
