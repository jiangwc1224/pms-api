package com.hyron.pms.loginuser;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Version;

import org.jmolecules.ddd.annotation.ValueObject;
import org.jmolecules.ddd.types.Identifier;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.hyron.pms.common.jpa.AbstractAggregateRoot;
import com.hyron.pms.common.vo.ValidPeriod;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

/**
 * [集約]ログインユーザ
 *
 * @author hyron xjiang.weichen
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class LoginUser extends AbstractAggregateRoot<LoginUser, LoginUser.LoginUserIdVO>
		implements Serializable {

	/** ログインユーザID */
	@EmbeddedId
	private LoginUserIdVO loginUserId;

	/** ユーザNo */
	@Column(length = 6)
	private String userNo;

	/** パスワード */
	@Column(length = 256)
	private String password;

	/** 有効期間 */
	private ValidPeriod validPeriod;

	/** 中止日 */
	@Column
	private LocalDate cancelDate;

	/** 中止フラグ */
	@Column(nullable = false)
	private boolean cancelFlag;

	/** バージョン */
	@Version
	private int version;

	/**
	 * ログインユーザIDを取得
	 * @return ログインユーザID
	 */
	@JsonIgnore
	@Override
	public LoginUserIdVO getId() {
		return this.loginUserId;
	}

	/**
	 * [VO]ログインユーザNo
	 *
	 * @author hyron xjiang.weichen
	 */
	@ValueObject
	@Embeddable
	@Value
	@AllArgsConstructor(staticName = "of")
	@NoArgsConstructor(force = true, access = AccessLevel.PROTECTED)
	@JsonSerialize(using = ToStringSerializer.class)
	public static class LoginUserIdVO implements Serializable, Identifier {

		/** ログインユーザId */
		@Column(nullable = false)
		private final UUID loginUserId;

		@Override
		public String toString() {
			return this.loginUserId.toString();
		}

	}

}
