package com.hyron.pms.common.vo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.jmolecules.ddd.annotation.ValueObject;
import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

/**
 * 共通VO：有効期間
 *
 * @author xjiang.weichen
 */
@ValueObject
@Embeddable
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class ValidPeriod implements Serializable {

	private static final long serialVersionUID = -6441362058831375378L;

	/** 有効開始日 */
	@Column(name = "valid_start_day", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
	LocalDate validStartDay;

	/** 有効終了日 */
	@Column(name = "valid_end_day", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
	LocalDate validEndDay;

	/**
	 * コンストラクタ
	 * @param validStartDay 有効開始日
	 * @param validEndDay 有効終了日
	 */
	public ValidPeriod(LocalDate validStartDay, LocalDate validEndDay) {
		Assert.notNull(validStartDay, "validStartDay");
		Assert.notNull(validEndDay, "validEndDay");
		// 有効開始日＞有効終了日は不可
		Assert.state(validEndDay.isAfter(validStartDay) || validEndDay.isEqual(validStartDay), "有効開始日＞有効終了日は不可。");

		this.validStartDay = validStartDay;
		this.validEndDay = validEndDay;
	}

	/**
	 * 有効期間作成
	 * @param validStartDay 有効開始日
	 * @param validEndDay 有効終了日
	 * @return 有効期間
	 */
	public static ValidPeriod of(LocalDate validStartDay, LocalDate validEndDay) {
		return new ValidPeriod(validStartDay, validEndDay);
	}

}
