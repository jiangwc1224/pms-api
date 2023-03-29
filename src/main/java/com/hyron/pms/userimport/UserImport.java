package com.hyron.pms.userimport;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.hyron.pms.career.Career;
import com.hyron.pms.career.JobLevel;
import com.hyron.pms.common.vo.AcademicCareerVO;
import com.hyron.pms.common.vo.DeptSummaryVO;
import com.hyron.pms.common.vo.ProjectSummaryVO;
import com.hyron.pms.common.vo.UserSummaryVO;
import com.hyron.pms.experience.Experience;
import com.hyron.pms.skill.Skill;
import lombok.*;
import org.jmolecules.ddd.annotation.ValueObject;
import org.jmolecules.ddd.types.Identifier;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.hyron.pms.common.jpa.AbstractAggregateRoot;

/**
 * [集約]ユーザ
 *
 * @author hyron xjiang.weichen
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class UserImport extends AbstractAggregateRoot<UserImport, UserImport.UserNoVO>
        implements Serializable {

    /**
     * ユーザNo
     */
    @EmbeddedId
    private UserNoVO userNo;

    /**
     * ユーザ名
     */
    @Column(length = 256)
    private String userName;

    /**
     * 性别
     */
    @Enumerated(EnumType.ORDINAL)
    private Sex sex;

    /**
     * 誕生日
     */
    @Column
    private Date birthDay;

    /**
     * 婚姻情況
     */
    private MaritalStatus maritalStatus;

    /**
     * 電話番号
     */
    @Column(length = 11)
    private String telNo;

    /**
     * メール
     */
    @Column
    private String mail;

    /**
     * 住所
     */
    @Column
    private String address;

    /**
     * 入社日
     */
    @Column
    private Date entryDate;

    /**
     * 退社日
     */
    @Column
    private Date termDate;

    /**
     * 勤続年数
     */
    @Column
    private int workYears;

    /**
     * 仕事レベル
     */
    @Enumerated(EnumType.ORDINAL)
    private JobLevel jobLevel;

    /**
     * 日本語能力資格
     */
    @Enumerated(EnumType.ORDINAL)
    private JapaneseLevel japaneseLevel;

    /**
     * 出張意向
     */
    @Enumerated(EnumType.ORDINAL)
    private BusinessTrip businessTrip;

    /**
     * 日本滞在月数
     */
    private int japanStayMonths;

    /**
     * 所属部門
     */
    private DeptSummaryVO department;

    /**
     * 所属プロジェクト
     */
    private ProjectSummaryVO project;

    /**
     * 所属リーダー
     */
    private UserSummaryVO leader;

    /**
     * 退社フラグ
     */
    private boolean termFlag;

    /**
     * 技術
     */
    //private List<Skill> skills;
    private String skill_id;
    /**
     * 最終学歴
     */
    private AcademicCareerVO lastAcademicCareer;

    /**
     * 個人職歴
     */
    //private List<Career> careers;
    private String career_id;
    /**
     * 項目履歴
     */
    //private List<Experience> projectExperience;
    private String experience_id;
    /**
     * 備考
     */
    private String note;

    /**
     * バージョン
     */
    @Version
    private int version;

    /**
     * ユーザIDを取得
     *
     * @return ユーザID
     */
    @JsonIgnore
    @Override
    public UserNoVO getId() {
        return this.userNo;
    }

    /**
     * [VO]ユーザNo
     *
     * @author hyron xjiang.weichen
     */
    @ValueObject
    @Embeddable
    @Value
    @AllArgsConstructor(staticName = "of")
    @NoArgsConstructor(force = true, access = AccessLevel.PROTECTED)
    @JsonSerialize(using = ToStringSerializer.class)
    public static class UserNoVO implements Serializable, Identifier {

        /**
         * ユーザNo
         */
        @Column(nullable = false, length = 6)
        private final String userNo;

        @Override
        public String toString() {
            return this.userNo;
        }

    }

}
