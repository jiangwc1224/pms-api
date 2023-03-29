package com.hyron.pms.common.vo;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.jmolecules.ddd.annotation.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * 共通VO：プロジェクト概要
 *
 * @author xlv.xing
 */
@ValueObject
@Embeddable
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class ProjectSummaryVO implements Serializable {
    private static final long serialVersionUID = -6805276193942696277L;
    /** プロジェクトNo */
    @Column(length = 12)
    private String projectNo;

    /** プロジェクト名 */
    @Column(length = 256)
    private String projectName;

}
