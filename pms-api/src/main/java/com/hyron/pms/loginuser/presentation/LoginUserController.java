package com.hyron.pms.loginuser.presentation;


import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hyron.pms.common.GeneralConstant;
import com.hyron.pms.loginuser.LoginUser;
import com.hyron.pms.loginuser.application.LoginUserUsecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ログインユーザコントローラ
 *
 * @author hyron xjiang.weichen
 */
@RestController
@ExposesResourceFor(LoginUser.class)
@RequestMapping(GeneralConstant.LOGIN_USER_HEADERS)
@RequiredArgsConstructor
@Slf4j
public class LoginUserController {

	/** ログインユーザモデル */
	private final LoginUserModelAssembler loginUserModelAssembler;

	/** ログインユーザIdモデル */
	private final LoginUserIdModelAssembler loginUserIdModelAssembler;

	/** ログインユーザユーズケース */
	private final LoginUserUsecase loginUserUsecase;

	/**
	 * ユーザNoとパスワード指定ログインユーザ取得（ログイン画面用）
	 * @param loginUserNo ログインユーザNo
	 * @param password パスワード
	 * @return ログインユーザ
	 */
	@GetMapping(GeneralConstant.LOGIN_USER_GET_FOR_LOGIN)
	public ResponseEntity<?> getLoginUserForLogin(@PathVariable(value = "loginUserNo", required = true) String loginUserNo,
											@RequestParam(value = "password", required = true) String password) {
		LoginUser loginUser = this.loginUserUsecase.getLoginUserForLogin(loginUserNo, password);

		return ResponseEntity.ok().body(this.loginUserModelAssembler.toModel(loginUser));
	}

}
