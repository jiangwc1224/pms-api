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
 * 共通VO：プロジェクト概要
 *
 * @author caixueping
*/
@ValueObject
@Embeddable
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "of")
public class ProjectSummaryVO implements Serializable {

    /** シリアルバージョンID */
    private static final long serialVersionUID = -3342841369008560726L;

    /** プロジェクトNo */
    @Column(length = 12)
    private final String projectNo;

    /** プロジェクト名 */
    @Column(length = 256)
    private final String projectName;

}
