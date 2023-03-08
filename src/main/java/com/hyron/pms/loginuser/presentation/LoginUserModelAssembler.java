package com.hyron.pms.loginuser.presentation;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.hyron.pms.loginuser.LoginUser;
import com.hyron.pms.userimport.presentation.UserImportController;

/**
 * [ModelAssembler]ユーザ
 *
 * @author hyron xjiang.weichen
 *
 */
@Component
public class LoginUserModelAssembler extends RepresentationModelAssemblerSupport<LoginUser, LoginUserModel> {

	/**
	 * コンストラクタ
	 */
	public LoginUserModelAssembler() {
		super(UserImportController.class, LoginUserModel.class);
	}

	/**
	 * モデルへ転換
	 * @param loginUser ユーザ
	 * @return ユーザモデル
	 */
	@Override
	public LoginUserModel toModel(LoginUser loginUser) {
		return createModelWithId(loginUser.getId(), loginUser);
	}

	/**
	 * モデル初期化
	 * @param loginUser ログインユーザ
	 * @return ログインユーザモデル
	 */
	@Override
	protected LoginUserModel instantiateModel(LoginUser loginUser) {
		return new LoginUserModel(loginUser);
	}

}
