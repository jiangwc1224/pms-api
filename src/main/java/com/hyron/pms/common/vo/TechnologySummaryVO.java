package com.hyron.pms.common.vo;

import com.hyron.pms.common.enums.TechnologyType;
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
 * 共通VO：技術概要
 *
 * @author xlv.xing
 */
@ValueObject
@Embeddable
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class TechnologySummaryVO implements Serializable {

    private static final long serialVersionUID = -1409261328199600007L;

    /** 技術名 */
    @Column(length = 256)
    private String technologyName;

    /** 技術種別 */
    @Enumerated(EnumType.ORDINAL)
    private TechnologyType technologyType;

}
