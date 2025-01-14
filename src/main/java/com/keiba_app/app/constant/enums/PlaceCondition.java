package com.keiba_app.app.constant.enums;

import lombok.Getter;

@Getter
public enum PlaceCondition {
    良("良"),
    稍("稍"),
    重("重"),
    不("不");

    private final String displayName;

    PlaceCondition(String displayName) {
        this.displayName = displayName;
    }

}
