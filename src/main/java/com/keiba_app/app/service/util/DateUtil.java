package com.keiba_app.app.service.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtil {
    /**
     * Get JST current local date
     *
     * @return LocalDate
     */
    public static LocalDate getJstLocalDate() {
        var zdt = ZonedDateTime.now();
        return zdt.withZoneSameInstant(ZoneId.of("Asia/Tokyo")).toLocalDate();
    }
}
