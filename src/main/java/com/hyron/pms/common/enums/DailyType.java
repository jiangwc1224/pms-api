package com.hyron.pms.common.enums;
import lombok.Getter;

public enum DailyType {
    WORK("作業"),
    LABOR("勤怠");



    @Getter
    private final String DailyType;

    DailyType(String name) {
        this.DailyType = name;
    }
}

