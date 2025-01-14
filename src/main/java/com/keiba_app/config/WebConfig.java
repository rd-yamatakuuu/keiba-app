package com.keiba_app.config;

import com.keiba_app.app.constant.enums.CourseLength;
import com.keiba_app.app.constant.enums.PlaceCondition;
import com.keiba_app.app.constant.enums.RaceCourse;
import com.keiba_app.app.constant.enums.Sex;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        // RaceCourse用のコンバーター
        registry.addConverter(String.class, RaceCourse.class, source -> {
            System.out.println("Converter input value: " + source);
            if (source == null || source.isEmpty()) {
                System.out.println("Source is null or empty");
                return null;
            }

            RaceCourse result = RaceCourse.valueOf(source);
            System.out.println("Conversion result: " + result);

            if (result == null) {
                // 変換に失敗した場合、enum名での変換を試みる
                try {
                    result = RaceCourse.valueOf(source);
                    System.out.println("Fallback to enum name conversion: " + result);
                } catch (IllegalArgumentException e) {
                    System.out.println("Both conversions failed");
                }
            }

            return result;
        });

        // CourseLength用のコンバーター
        registry.addConverter(String.class, CourseLength.class, source -> {
            if (source == null || source.isEmpty()) {
                return null;
            }
            try {
                return CourseLength.valueOf(source);
            } catch (IllegalArgumentException e) {
                return null;
            }
        });

        // PlaceCondition用のコンバーター
        registry.addConverter(String.class, PlaceCondition.class, source -> {
            if (source == null || source.isEmpty()) {
                return null;
            }
            try {
                return PlaceCondition.valueOf(source);
            } catch (IllegalArgumentException e) {
                return null;
            }
        });

        // Sex用のコンバーター
        registry.addConverter(String.class, Sex.class, source -> {
            if (source == null || source.isEmpty()) {
                return null;
            }
            try {
                return Sex.valueOf(source);
            } catch (IllegalArgumentException e) {
                return null;
            }
        });
    }
}
