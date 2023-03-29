package com.hyron.pms.userimport;

import lombok.Getter;

public enum JapaneseLevel {
    N1("1"),
    N2("2"),
    N3("3"),
    N4("4"),
    NO("なし");

    @Getter
    private final String japaneseLevelName;

    JapaneseLevel(String name) {
        this.japaneseLevelName = name;
    }
}
