package com.hyron.pms.monthEvaluation;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import com.hyron.pms.common.enums.EvaluationLevel;
import com.hyron.pms.common.jpa.AbstractAggregateRoot;
import com.hyron.pms.common.vo.ProjectSummaryVO;
import com.hyron.pms.common.vo.UserSummaryVO;

import lombok.*;
import org.jmolecules.ddd.annotation.ValueObject;
import org.jmolecules.ddd.types.Identifier;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * [集約]月末评价
 *
 * @author hyron caixueping
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
@AllArgsConstructor
public class MonthEvaluation extends AbstractAggregateRoot<MonthEvaluation,MonthEvaluation.MonthEvaluationIdVO> implements Serializable{

    /** 月末評価ID */
    @EmbeddedId
    private MonthEvaluationIdVO monthEvaluationId;

    /** 評価月 */
    @Column
    private LocalDate evaluationMonth;

    /** 所属プロジェクト */
    @AttributeOverride(name = "projectNo", column = @Column(name = "projectSummaryProjectNo", nullable = false, length = 12))
    @AttributeOverride(name = "projectName", column = @Column(name = "projectSummaryProjectName", nullable = false, length = 256))
    private ProjectSummaryVO projectSummary;

    /** 被評価者 */
    @AttributeOverride(name = "userNo",column = @Column(name = "evaluatedUserUserNo", nullable = false, length = 6))
    @AttributeOverride(name = "userName", column = @Column(name = "evaluatedUserUserName", nullable = false, length = 256))
    private UserSummaryVO evaluatedUser;

    /** 評価者 */
    @AttributeOverride(name = "userNo",column = @Column(name = "assessorUserNo", nullable = false, length = 6))
    @AttributeOverride(name = "userName",column = @Column(name = "assessorUserName", nullable = false, length = 256))
    private UserSummaryVO assessor;

    /** 総評 */
    private EvaluationLevel generalEvaluation;

    /** 作業態度 */
    @Column(length = 256)
    private String workingAttitude;

    /** 作業態度評 */
    private EvaluationLevel workingAttitudeEvaluation;

    /** 作業品質 */
    @Column(length = 256)
    private String workingQuality;

    /** 作業品質評 */
    private EvaluationLevel workingQualityEvaluation;

    /** 作業進捗 */
    @Column(length = 256)
    private String workingProgress;

    /** 作業進捗評 */
    private EvaluationLevel workingProgressEvaluation;

    /** 交流 */
    @Column(length = 256)
    private String communication;

    /** 交流評 */
    private EvaluationLevel communicationEvaluation;

    /** その他 */
    @Column(length = 256)
    private String others;

    /** 公開フラグ */
    @Column(nullable = false)
    private boolean publicFlag;

    /** バージョン */
    @Column
    private int version;

    /**
     * 月末評価IDを取得
     * @return 月末評価ID
     */
    @JsonIgnore
    @Override
    public MonthEvaluationIdVO getId() {return this.monthEvaluationId;}

    /**
     * [VO]月末評価ID
     *
     * @author hyron caixueping
     */
    @ValueObject
    @Embeddable
    @Value
    @AllArgsConstructor(staticName = "of")
    @NoArgsConstructor(force = true, access = AccessLevel.PROTECTED)
    @JsonSerialize(using = ToStringSerializer.class)
    public static class MonthEvaluationIdVO implements Serializable, Identifier{

        /** 月末評価ID */
        @Column(length = 19)
        private String monthEvaluationId;

    }
}
