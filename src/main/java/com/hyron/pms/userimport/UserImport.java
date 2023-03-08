package com.hyron.pms.userimport;

import java.io.Serializable;

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

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

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

	/** ユーザNo */
	@EmbeddedId
	private UserNoVO userNo;

	/** バージョン */
	@Version
	private int version;

	/**
	 * ユーザIDを取得
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

		/** ユーザNo */
		@Column(nullable = false, length = 6)
		private final String userNo;

		@Override
		public String toString() {
			return this.userNo;
		}

	}

}
