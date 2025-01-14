package com.keiba_app.app.constant.enums;

import lombok.Getter;

@Getter
public enum CourseLength {
    L_1000("1000", 1000),
    L_1150("1150", 1150),
    L_1200("1200", 1200),
    L_1300("1300", 1300),
    L_1400("1400", 1400),
    L_1500("1500", 1500),
    L_1600("1600", 1600),
    L_1700("1700", 1700),
    L_1800("1800", 1800),
    L_1900("1900", 1900),
    L_2000("2000", 2000),
    L_2100("2100", 2100),
    L_2200("2200", 2200),
    L_2300("2300", 2300),
    L_2400("2400", 2400),
    L_2500("2500", 2500),
    L_2600("2600", 2600),
    L_2750("2750", 2750),
    L_2770("2770", 2770),
    L_2850("2850", 2850),
    L_2860("2860", 2860),
    L_2880("2880", 2880),
    L_2890("2890", 2890),
    L_2910("2910", 2910),
    L_2970("2970", 2970),
    L_3000("3000", 3000),
    L_3100("3100", 3100),
    L_3110("3110", 3110),
    L_3140("3140", 3140),
    L_3170("3170", 3170),
    L_3200("3200", 3200),
    L_3210("3210", 3210),
    L_3250("3250", 3250),
    L_3290("3290", 3290),
    L_3300("3300", 3300),
    L_3330("3330", 3330),
    L_3350("3350", 3350),
    L_3380("3380", 3380),
    L_3390("3390", 3390),
    L_3400("3400", 3400),
    L_3570("3570", 3570),
    L_3600("3600", 3600),
    L_3900("3900", 3900),
    L_3930("3930", 3930),
    L_4100("4100", 4100),
    L_4250("4250", 4250);

    private final String displayName;
    private final long meters;


    CourseLength(String displayName, long meters) {
        this.displayName = displayName;
        this.meters = meters;
    }

    public String getDisplayName() {
        return displayName + "m";
    }

    public static CourseLength fromMeters(Integer meters) {  // intからIntegerに変更
        if (meters == null) {
            return null;
        }
        for (CourseLength length : values()) {
            if (length.getMeters() == meters) {
                return length;
            }
        }
        return null;
    }

    public static CourseLength safeValueOf(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }
        try {
            return CourseLength.valueOf(name);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

}
