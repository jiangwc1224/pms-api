package com.hyron.pms.loginuser;

import static com.hyron.pms.common.core.QuerySupport.forEntity;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * [Domain Service]ログインユーザサービス
 *
 * @author hyron xjiang.weichen
 */
@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class LoginUserService {

	/** ログインユーザレポジトリ */
	private final LoginUsers loginUsers;

	/**
	 * ユーザNoとパスワード指定ログインユーザ取得（ログイン画面用）
	 * @param userNo ユーザNo
	 * @param password パスワード
	 * @return ユーザ情報
	 */
	public LoginUser getLoginUserForLogin(String userNo,String password) {
		LocalDate currentDate = LocalDate.now();
		return forEntity(LoginUser.class) // QuerySupportインスタンスを設立して、インスタンスのパラメータはentity.classです。
				.find(() -> this.loginUsers.findByUserNoAndPasswordAndValidPeriod_ValidStartDayLessThanEqualAndValidPeriod_ValidEndDayGreaterThanEqualAndCancelFlagIsFalse(userNo, password,currentDate,currentDate)); // データ取得の時、取得がないの場合はnew
																		// ResponseStatusException(HttpStatus.NOT_FOUND)をスローする。
	}

}
