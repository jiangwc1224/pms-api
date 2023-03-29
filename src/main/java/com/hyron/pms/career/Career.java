package com.hyron.pms.career;

import com.hyron.pms.common.vo.PeriodVO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

/**
 * 職歴
 *
 * @author hyron xlv.xing
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class Career {

    /** 職歴ID */
    @Id
    private UUID careerId;

    /** 期間 */
    private PeriodVO period;

    /** 仕事レベル */
    @Enumerated(EnumType.ORDINAL)
    private JobLevel jobLevel;

    /** 備考 */
    @Column(length = 256)
    private String note;

    /** バージョン */
    private int version;

}
