package com.hyron.pms.dept;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.hyron.pms.common.jpa.AbstractAggregateRoot;
import com.hyron.pms.common.vo.UserSummaryVO;
import lombok.*;
import org.jmolecules.ddd.annotation.ValueObject;
import org.jmolecules.ddd.types.Identifier;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 部門
 *
 * @author hyron xlv.hang
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class Dept extends AbstractAggregateRoot<Dept, Dept.DeptNoVO>
        implements Serializable {
    /**
     * 部門No
     */
    @EmbeddedId
    private DeptNoVO deptNo;

    /**
     * 部門名
     */
    @Column(length = 256)
    private String deptName;

    /**
     * 部門人数
     */
    private int deptNum;

    /**
     * 部長
     */
    @Column
    private UserSummaryVO deptLeader;

    /**
     * 部門の説明
     */
    @Column(length = 256)
    private String deptDescription;

    /**
     * バージョン
     */
    @Version
    private int version;


    @Override
    public DeptNoVO getId() {
        return this.deptNo;
    }

    @ValueObject
    @Embeddable
    @Value
    @AllArgsConstructor(staticName = "of")
    @NoArgsConstructor(force = true, access = AccessLevel.PROTECTED)
    @JsonSerialize(using = ToStringSerializer.class)
    public static class DeptNoVO implements Serializable,Identifier {

        @Column(nullable = false, length = 6)
        private final String deptNo;

        @Override
        public String toString() {
            return this.deptNo;
        }

    }
}
