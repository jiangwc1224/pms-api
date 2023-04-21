package com.hyron.pms.common.vo;

import com.hyron.pms.common.enums.TaskType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.jmolecules.ddd.annotation.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

/**
 * 共通VO：タスク概要
 *
 * @author zhi.hengshun
 */
@ValueObject
@Embeddable
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class TaskSummaryVO implements Serializable {


    private static final long serialVersionUID = -687171602224959933L;
    /** タスクNo */
    @Column(length = 6)
    private  String userNo;

    /** タスク名 */
    @Column(length = 256)
    private  String taskName;

    /** タスク種別 */
    @Enumerated(EnumType.ORDINAL)
    private TaskType TaskType;
}
