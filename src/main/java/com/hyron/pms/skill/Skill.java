package com.hyron.pms.skill;

import com.hyron.pms.common.vo.TechnologySummaryVO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.UUID;

/**
 * 技術
 *
 * @author hyron xlv.xing
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class Skill {

    /** 技術ID */
    @Id
    private UUID skillId;

    /** 技術概要 */
    private TechnologySummaryVO technologySummary;

    /** 把握程度 */
    @Enumerated(EnumType.ORDINAL)
    private MasteryLevel masteryLevel;

    /** 正式使用フラグ */
    private boolean useFlag;

    /** バージョン */
    private int version;


}
