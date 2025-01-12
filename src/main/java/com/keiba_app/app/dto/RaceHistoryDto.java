package com.keiba_app.app.dto;


import com.keiba_app.app.domain.entity.RaceHistory;
import lombok.Data;

@Data
public class RaceHistoryDto {

    private Integer id;

    private String raceCourse;

    private String placeCondition;

    private String raceName;

    private Long courseLength;

    private String round;

    private String year;

    private String horseName;

    private String sex;

    private Long old;

    private String jockeyName;


    public static RaceHistoryDto convertToDto(RaceHistory raceHistory) {
        RaceHistoryDto dto = new RaceHistoryDto();
        dto.setId(raceHistory.getId());
        dto.setRaceCourse(raceHistory.getRaceCourse());
        dto.setPlaceCondition(raceHistory.getPlaceCondition());
        dto.setRaceName(raceHistory.getRaceName());
        dto.setCourseLength(raceHistory.getCourseLength());
        dto.setRound(raceHistory.getRound());
        dto.setYear(raceHistory.getYear());
        dto.setHorseName(raceHistory.getHorseName());
        dto.setSex(raceHistory.getSex());
        dto.setOld(raceHistory.getOld());
        dto.setJockeyName(raceHistory.getJockeyName());
        return dto;
    }
}
