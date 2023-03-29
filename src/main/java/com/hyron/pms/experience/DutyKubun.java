package com.hyron.pms.experience;

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
