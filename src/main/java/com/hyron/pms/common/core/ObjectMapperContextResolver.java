package com.hyron.pms.common.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import org.jmolecules.jackson.JMoleculesModule;
import org.zalando.jackson.datatype.money.MoneyModule;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.YearMonthDeserializer;

/**
 * 対象Mapper用共通クラス
 *
 * @author hyron xjiang.weichen
 *
 */
public class ObjectMapperContextResolver {

	/** ObjectMapper対象 */
	private final ObjectMapper mapper;

	/**
	 * コンストラクタ
	 */
	public ObjectMapperContextResolver() {
		this.mapper = new ObjectMapper();
		JavaTimeModule javaTimeModule = new JavaTimeModule();
		javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ISO_DATE));
		javaTimeModule.addDeserializer(LocalDateTime.class,
				new LocalDateTimeDeserializer(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		javaTimeModule.addDeserializer(YearMonth.class,
				new YearMonthDeserializer(DateTimeFormatter.ofPattern("yyyy-MM")));
		this.mapper.registerModule(javaTimeModule);
		this.mapper.registerModule(new JMoleculesModule());
		this.mapper.registerModule(new MoneyModule());
		this.mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	}

	/**
	 * 対象Mapperを取得する
	 * @return 対象Mapper
	 */
	public ObjectMapper getContext() {
		return this.mapper;
	}

}
