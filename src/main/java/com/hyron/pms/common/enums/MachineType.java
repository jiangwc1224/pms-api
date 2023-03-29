package com.hyron.pms.common.enums;

import lombok.Getter;

public enum MachineType {
    LINUX("linux"),
    MAC("Mac"),
    WINDOWS("Windows");

    @Getter
    private final String machineTypeName;

    MachineType(String name) {
        this.machineTypeName = name;
    }
}
