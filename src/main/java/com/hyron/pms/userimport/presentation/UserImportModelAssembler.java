package com.hyron.pms.userimport.presentation;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.hyron.pms.userimport.UserImport;

/**
 * [ModelAssembler]ユーザ
 *
 * @author hyron xjiang.weichen
 *
 */
@Component
public class UserImportModelAssembler extends RepresentationModelAssemblerSupport<UserImport, UserImportModel> {

	/**
	 * コンストラクタ
	 */
	public UserImportModelAssembler() {
		super(UserImportController.class, UserImportModel.class);
	}

	/**
	 * モデルへ転換
	 * @param user ユーザ
	 * @return ユーザモデル
	 */
	@Override
	public UserImportModel toModel(UserImport user) {
		return createModelWithId(user.getId(), user);
	}

	/**
	 * モデル初期化
	 * @param user ユーザ
	 * @return ユーザモデル
	 */
	@Override
	protected UserImportModel instantiateModel(UserImport user) {
		return new UserImportModel(user);
	}

}
