package com.hyron.pms.userimport;

import lombok.Getter;

public enum Sex {
    MALE("男"),
    FEMALE("女");
    @Getter
    private final String sexName;

    Sex(String name) {
        this.sexName = name;
    }
}
