package com.hyron.pms.common.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hyron.pms.common.core.ObjectMapperContextResolver;

/**
 * 対象クローン共通クラス
 *
 * @author hyron xjiang.weichen
 *
 */
public final class DataCloneUtils {

	/** 対象Mapper共通 */
	private static final ObjectMapperContextResolver mapper = new ObjectMapperContextResolver();

	/**
	 * コンストラクタ
	 */
	private DataCloneUtils() {
	}

	/**
	 * クローン
	 * @param <T> クラス
	 * @param sourceObj 元対象
	 * @param valueType クラスタイプ
	 * @return クローンされた先対象
	 */
	public static <T> T clone(T sourceObj, Class<T> valueType) {
		try {
			String objStr = mapper.getContext().writeValueAsString(sourceObj);

			return mapper.getContext().readValue(objStr, valueType);
		}
		catch (JsonProcessingException ex) {
			return null;
		}
	}

}
