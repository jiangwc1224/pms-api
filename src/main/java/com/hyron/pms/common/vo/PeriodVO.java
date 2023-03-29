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
 * 共通VO：期間
 *
 * @author xjiang.weichen
 */
@ValueObject
@Embeddable
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class PeriodVO implements Serializable {

	private static final long serialVersionUID = -6441362058831375378L;

	/** 開始日 */
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
	LocalDate startDay;

	/** 終了日 */
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
	LocalDate endDay;

	/**
	 * コンストラクタ
	 * @param startDay 開始日
	 * @param endDay 終了日
	 */
	public PeriodVO(LocalDate startDay, LocalDate endDay) {
		Assert.notNull(startDay, "startDay");
		Assert.notNull(endDay, "endDay");
		// 開始日＞終了日は不可
		Assert.state(endDay.isAfter(startDay) || endDay.isEqual(startDay), "開始日＞終了日は不可。");

		this.startDay = startDay;
		this.endDay = endDay;
	}

	/**
	 * 期間作成
	 * @param startDay 開始日
	 * @param endDay 終了日
	 * @return 期間
	 */
	public static PeriodVO of(LocalDate startDay, LocalDate endDay) {
		return new PeriodVO(startDay, endDay);
	}

}
