package com.hyron.pms.common.enums;

import lombok.Getter;

public enum MasteryLevel {
    UNDERSTAND("了解"),
    KNOW_VERY_WELL("熟知"),
    GRASP("把握"),
    PROFICIENCY("精通");

    @Getter
    private final String masteryLevelName;

    MasteryLevel(String name) {
        this.masteryLevelName = name;
    }
}
