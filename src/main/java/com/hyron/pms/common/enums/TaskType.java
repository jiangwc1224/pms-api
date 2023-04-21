package com.hyron.pms.common.enums;


import lombok.Getter;

public enum TaskType {
    CONSTRUCTION("環境構築"),
    DEVELOPMENT("開発"),
    TEST("テスト"),
    SUPPORT("サポート");

    @Getter
    private final String TaskType;

    TaskType(String name) {
        this.TaskType = name;
    }

}
