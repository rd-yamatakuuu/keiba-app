package com.keiba_app.app.controller.SearchRaceHistory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchRaceHistoryRequestParameter {
    private String raceCourse;

    private String placeCondition;

    private String RaceName;

    private Long courseLength;

    private String raceTime;

    private String year;

    private String horseName;

    private String sex;

    private Long old;

    private String jockeyName;

    private String raceOrder;
}
