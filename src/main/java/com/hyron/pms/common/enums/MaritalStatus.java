package com.hyron.pms.common.enums;

import lombok.Getter;

public enum MaritalStatus {
    UNMARRIED("未婚"),
    MARRIED("既婚");
    @Getter
    private final String maritalStatusName;

    MaritalStatus(String name) {
        this.maritalStatusName = name;
    }
}
