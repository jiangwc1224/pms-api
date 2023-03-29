package com.hyron.pms.userimport;

import lombok.Getter;

public enum Qualification {
    SCHOLAR("学士"),
    BROTHER("修士"),
    DOCTOR("博士");

    @Getter
    private final String qualificationName;

    Qualification(String name) {
        this.qualificationName = name;
    }
}
