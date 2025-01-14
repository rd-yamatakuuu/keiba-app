package com.keiba_app.app.controller.SearchRaceHistory;

import com.keiba_app.app.constant.enums.CourseLength;
import com.keiba_app.app.constant.enums.PlaceCondition;
import com.keiba_app.app.constant.enums.RaceCourse;
import com.keiba_app.app.constant.enums.Sex;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchRaceHistoryRequestParameter {

    private RaceCourse raceCourse;

    private PlaceCondition placeCondition;

    @Size(max = 50, message = "レース名は50文字以内で入力してください")
    private String raceName;

    private CourseLength courseLength;

    private String raceTime;

    private String year;

    @Size(max = 20, message = "馬名は20文字以内で入力してください")
    private String horseName;

    private Sex sex;

    private Integer old;

    @Size(max = 20, message = "騎手名は20文字以内で入力してください")
    private String jockeyName;

    private String raceOrder;
}
