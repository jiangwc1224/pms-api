package com.hyron.pms.experience;

import com.hyron.pms.common.vo.PeriodVO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

/**
 * 履歴
 *
 * @author hyron xlv.xing
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class Experience {

    /** 履歴ID */
    @Id
    private UUID experienceId;

    /** 期間 */
    private PeriodVO period;

    /** 開発プロジェクト名 */
    @Column(length = 256)
    private String projectName;

    /** 機種 */
    @Enumerated(EnumType.ORDINAL)
    private MachineType machineType;

    /** OS種類 */
    private String osType;

    /** 使用言語 */
    private String usedSoftware;

    /** 職責区分 */
    @Enumerated(EnumType.ORDINAL)
    private DutyKubun dutyKubun;

    /** タスク区分 */
    private String taskKubun;

    /** 仕事場所 */
    private String workingAddress;

    /** バージョン */
    private int version;

}
