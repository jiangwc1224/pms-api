package com.hyron.pms.common.enums;

import lombok.Getter;

public enum TechnologyType {
    OS("OS"),
    IDE("IDE"),
    FRAMEWORK("Framework"),
    PROFICIENCY("開発言語"),
    OPEN_LANGUAGE("DB");

    @Getter
    private final String technologyTypeName;

    TechnologyType(String name) {
        this.technologyTypeName = name;
    }
}
