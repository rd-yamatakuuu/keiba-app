package com.keiba_app.app.constant.enums;

import lombok.Getter;

@Getter
public enum RaceCourse {
    SAPPORO("札幌", "01"),
    HAKODATE("函館","02"),
    FUKUSHIMA("福島", "03"),
    NIIGATA("新潟", "04"),
    TOKYO("東京", "05"),
    NAKAYAMA("中山", "06"),
    CHUKYO("中京", "07"),
    KYOTO("京都", "08"),
    HANSHIN("阪神", "09"),
    KOKURA("小倉", "10");

    private final String displayName;
    private final String searchCode;

    RaceCourse(String displayName, String searchCode) {
        this.displayName = displayName;
        this.searchCode = searchCode;
    }

    public static RaceCourse fromSearchCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }

        for (RaceCourse course : values()) {
            if (course.getSearchCode().equals(code)) {
                return course;
            }
        }
        return null;
    }
}
