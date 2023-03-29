package com.hyron.pms.common.enums;

import lombok.Getter;

public enum DutyKubun {
    PL("ﾌﾟﾛｼﾞｪｸﾄﾘｰﾀﾞｰ"),
    SE("ｿﾌﾄｳｪｱｴﾝｼﾞﾆｱ"),
    E("ﾌﾟﾛｼﾞｪｸﾄﾒﾝﾊﾞｰ");

    @Getter
    private final String dutyKubunName;

    DutyKubun(String name) {
        this.dutyKubunName = name;
    }
}
