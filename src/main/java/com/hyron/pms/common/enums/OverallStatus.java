package com.hyron.pms.common.enums;
import lombok.Getter;


public enum OverallStatus {

    STRICT("厳し"),
    NORMAL("正常"),
    SMOOTH("順調");


    @Getter
    private final String OverallStatus;

    OverallStatus(String name) {
        this.OverallStatus = name;
    }
}
