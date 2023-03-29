package com.hyron.pms.common.vo;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.jmolecules.ddd.annotation.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * 共通VO：ユーザ概要
 *
 * @author xlv.xing
 */
@ValueObject
@Embeddable
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class UserSummaryVO implements Serializable {

    private static final long serialVersionUID = -8089220684871224371L;
    /** ユーザNo */
    @Column(length = 6)
    private String leaderNo;

    /** ユーザ名 */
    @Column(length = 256)
    private String leaderName;


}
