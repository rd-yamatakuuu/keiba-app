package com.keiba_app.app.controller.SearchRaceHistory;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchRaceHistoryRequestParameter {

    private String raceCourse;

    private String placeCondition;

    @Size(max = 50, message = "レース名は50文字以内で入力してください")
    private String raceName;

    private String courseLength;

    private String raceTime;

    private String year;

    @Size(max = 20, message = "馬名は20文字以内で入力してください")
    private String horseName;

    private String sex;

    private String old;

    @Size(max = 20, message = "騎手名は20文字以内で入力してください")
    private String jockeyName;

    private String raceOrder;
}
