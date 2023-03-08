package com.hyron.pms.loginuser.application;

import org.springframework.stereotype.Component;

import com.hyron.pms.loginuser.LoginUser;
import com.hyron.pms.loginuser.LoginUserService;

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
public class LoginUserUsecase {

	/** ログインユーザサービス */
	private final LoginUserService loginUserService;

	/**
	 * ユーザNoとパスワード指定ログインユーザ取得（ログイン画面用）
	 * @param userNo ユーザNo
	 * @param password パスワード
	 * @return ログインユーザ情報
	 */
	public LoginUser getLoginUserForLogin(String userNo, String password) {
		return this.loginUserService.getLoginUserForLogin(userNo, password);
	}
}
