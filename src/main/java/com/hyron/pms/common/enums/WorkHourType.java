package com.hyron.pms.common.enums;
import lombok.Getter;
public enum WorkHourType {

    USUAL("作業"),
    OVERTIME("勤怠");



    @Getter
    private final String WorkHourType;

    WorkHourType(String name) {
        this.WorkHourType = name;
    }
}

