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

    private String courseLength;

    private String raceTime;

    private String year;

    private String horseName;

    private String sex;

    private String old;

    private String jockeyName;

    private String raceOrder;


    public static RaceHistoryDto from(SearchRaceHistoryRequestParameter param) {
        RaceHistoryDto dto = new RaceHistoryDto();

        dto.setRaceCourse(param.getRaceCourse());
        dto.setCourseLength(param.getCourseLength());
        dto.setRaceTime(param.getRaceTime());
        dto.setPlaceCondition(param.getPlaceCondition());
        dto.setRaceName(param.getRaceName());
        dto.setYear(param.getYear());
        dto.setHorseName(param.getHorseName());
        dto.setSex(param.getSex());
        dto.setOld(param.getOld());
        dto.setJockeyName(param.getJockeyName());
        dto.setRaceOrder(param.getRaceOrder());

        return dto;
    }
}
