package com.hyron.pms.common.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;


/**
 * [Enum]評価レベル
 *
 * <p>
 * 最低
 * <p>
 * 低
 * <p>
 * 中
 * <p>
 * 良
 * <p>
 * 優秀
 *
 * @author hyron caixueping
 */
@JsonFormat(shape = JsonFormat.Shape.NUMBER)
public enum EvaluationLevel {

    /** 最低 */
    LOWEST("最低"),

    /** 低 */
    LOW("低"),

    /** 中 */
    CENTRE("中"),

    /** 良 */
    FINE("良"),

    /** 優秀 */
    OUTSTANDING("優秀");

    /** 表示名 */
    @Getter
    private final String evaluationLevelName;

    /**
     * コンストラクタ
     * @param name 名前
     */
    EvaluationLevel(String name) {
        this.evaluationLevelName = name;
    }

    public static EvaluationLevel valueOf(int ordinal){
        if (ordinal < 0 || ordinal >= values().length) {
            throw new IndexOutOfBoundsException("Invalid ordinal");
        }
        return values()[ordinal];
    }

}
