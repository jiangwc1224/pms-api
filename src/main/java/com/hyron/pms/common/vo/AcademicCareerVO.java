package com.hyron.pms.common.vo;

import com.hyron.pms.common.enums.Qualification;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.jmolecules.ddd.annotation.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.time.YearMonth;

/**
 * 共通VO：最終学歴
 *
 * @author xlv.xing
 */
@ValueObject
@Embeddable
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class AcademicCareerVO implements Serializable {

    private static final long serialVersionUID = -3933706631593598225L;
    /** 卒業年月 */
    private YearMonth graduateDate;

    /** 学校名 */
    @Column(length = 256)
    private String schoolName;

    /** 専攻学科 */
    @Column(length = 256)
    private String subjectName;

    /** 資格称号 */
    @Enumerated(EnumType.ORDINAL)
    private Qualification qualification;

}
