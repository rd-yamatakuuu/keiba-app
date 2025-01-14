package com.keiba_app.app.dto;


import com.keiba_app.app.controller.SearchRaceHistory.SearchRaceHistoryRequestParameter;
import com.keiba_app.app.domain.entity.RaceHistory;
import lombok.Data;

@Data
public class RaceHistoryDto {

    private Integer id;

    private String raceCourse;

    private String placeCondition;

    private String raceName;

    private Long courseLength;

    private String raceTime;

    private String year;

    private String horseName;

    private String sex;

    private Integer old;

    private String jockeyName;

    private String raceOrder;


    public static RaceHistoryDto from(SearchRaceHistoryRequestParameter param) {
        RaceHistoryDto dto = new RaceHistoryDto();

        // RaceCourseの変換（enumからsearchCodeへ）
        if (param.getRaceCourse() != null) {
            dto.setRaceCourse(param.getRaceCourse().getSearchCode());
        }

        // CourseLengthの変換（enumからmeters値へ）
        if (param.getCourseLength() != null) {
            dto.setCourseLength(param.getCourseLength().getMeters());
        }

        dto.setRaceTime(param.getRaceTime());

        // その他のフィールドの設定
        if (param.getPlaceCondition() != null) {
            dto.setPlaceCondition(param.getPlaceCondition().getDisplayName());
        }
        dto.setRaceName(param.getRaceName());
        dto.setYear(param.getYear());
        dto.setHorseName(param.getHorseName());
        if (param.getSex() != null) {
            dto.setSex(param.getSex().name());
        }
        dto.setOld(param.getOld() != null ? param.getOld().intValue() : null);
        dto.setJockeyName(param.getJockeyName());
        dto.setRaceOrder(param.getRaceOrder());

        return dto;
    }
}
