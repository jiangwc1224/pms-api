package com.hyron.pms.userimport.application;

import org.springframework.stereotype.Component;

import com.hyron.pms.userimport.UserImport;
import com.hyron.pms.userimport.UserImport.UserNoVO;
import com.hyron.pms.userimport.UserImportService;
import com.hyron.pms.userimport.UserImportService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ユーザアプリケーションサービス
 *
 * @author hyron xjiang.weichen
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class UserImportUsecase {

	/** ユーザサービス */
	private final UserImportService userImportService;

	/**
	 * ユーザ詳細を取得する
	 * @param userNo ユーザNo
	 * @return ユーザ情報
	 */
	public UserImport getDetail(UserNoVO userNo) {
		return this.userImportService.getDetail(userNo);
	}
}
