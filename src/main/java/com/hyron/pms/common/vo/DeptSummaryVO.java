package com.hyron.pms.common.vo;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.jmolecules.ddd.annotation.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * 共通VO：部門概要
 *
 * @author xlv.xing
 */
@ValueObject
@Embeddable
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class DeptSummaryVO implements Serializable {

    private static final long serialVersionUID = -30262068327596503L;
    /** 部門No */
    @Column(length = 4)
    private String deptNo;

    /** 部門名 */
    @Column(length = 256)
    private String deptName;

}
