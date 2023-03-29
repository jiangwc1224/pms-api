package com.hyron.pms.common.vo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.jmolecules.ddd.annotation.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * 共通VO：ユーザ概要
 *
 * @author caixueping
 */
@ValueObject
@Embeddable
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "of")
public class UserSummaryVO implements Serializable {

    /** シリアルバージョンID */
    private static final long serialVersionUID = -3269429656107591153L;

    /** ユーザNo */
    @Column(length = 6)
    private final String userNo;

    /** ユーザ名 */
    @Column(length = 256)
    private final String userName;

}
