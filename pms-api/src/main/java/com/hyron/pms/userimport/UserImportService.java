package com.hyron.pms.userimport;

import static com.hyron.pms.common.core.QuerySupport.forEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyron.pms.userimport.UserImport.UserNoVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
/**
 * [Domain Service]ユーザサービス
 *
 * @author hyron xjiang.weichen
 */
@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class UserImportService {

	/** ユーザレポジトリ */
	private final UserImports userImports;

	/**
	 * ユーザ詳細を取得する
	 * @param userNo ユーザNo
	 * @return ユーザ情報
	 */
	public UserImport getDetail(UserNoVO userNo) {
		return forEntity(UserImport.class) // QuerySupportインスタンスを設立して、インスタンスのパラメータはentity.classです。
				.find(() -> this.userImports.findById(userNo)); // データ取得の時、取得がないの場合はnew
																		// ResponseStatusException(HttpStatus.NOT_FOUND)をスローする。
	}

}
