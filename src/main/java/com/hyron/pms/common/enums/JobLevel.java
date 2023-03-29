package com.hyron.pms.common.enums;

import lombok.Getter;

public enum JobLevel {
    PG("プログラマ"),
    SE("システムエンジニア"),
    PL("プロジェクトリーダー"),
    TM("技術部マネージャー"),
    PM("プロジェクトマネージャ"),
    SPM("キャリアマネージャー"),
    DM("担当部長"),
    MM("部長"),
    BM("事業部長"),
    DGM("副総経理"),
    GM("総経理");

    @Getter
    private final String jobLevelName;

    JobLevel(String name) {
        this.jobLevelName = name;
    }
}
