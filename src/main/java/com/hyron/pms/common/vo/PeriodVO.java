package com.hyron.pms.common.vo;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.jmolecules.ddd.annotation.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

/**
 * 共通VO：期間
 *
 * @author xlv.xing
 */
@ValueObject
@Embeddable
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class PeriodVO implements Serializable {

    private static final long serialVersionUID = -553062679057201788L;
    /** 開始日 */
    private Date startDay;

    /** 終了日 */
    private Date endDay;
}
