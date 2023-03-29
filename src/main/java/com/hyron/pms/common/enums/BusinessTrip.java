package com.hyron.pms.common.enums;

import lombok.Getter;

public enum BusinessTrip {
    NO("意向なし"),
    ON_MONTH("一か月"),
    THREE_MONTHS("三か月"),
    SIX_MONTHS("半年"),
    ON_YEAR("一年"),
    THREE_YEARS("三年"),
    INDEFINITE("無限期");

    @Getter
    private final String businessTripName;

    BusinessTrip(String name) {
        this.businessTripName = name;
    }
}
