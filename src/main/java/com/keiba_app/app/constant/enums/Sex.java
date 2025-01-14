package com.keiba_app.app.constant.enums;

import lombok.Getter;

@Getter
public enum Sex {
    牝("牝"),
    牡("牡"),
    セ("セ");

    private final String displayName;

    Sex(String displayName) {
        this.displayName = displayName;
    }

}
