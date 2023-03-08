package com.hyron.pms.loginuser.presentation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.hyron.pms.loginuser.LoginUser;
import com.hyron.pms.loginuser.LoginUser.LoginUserIdVO;
import com.hyron.pms.userimport.presentation.UserImportController;

/**
 * [ModelAssembler]ログインユーザId
 *
 * @author hyron xjiang.weichen
 *
 */
@Component
public class LoginUserIdModelAssembler
		extends RepresentationModelAssemblerSupport<LoginUserIdVO, LoginUserIdModel> {

	/**
	 * コンストラクタ
	 */
	public LoginUserIdModelAssembler() {
		super(UserImportController.class, LoginUserIdModel.class);
	}

	/**
	 * モデルへ転換
	 * @param loginUserId ログインユーザId
	 * @return ログインユーザIdモデル
	 */
	@Override
	public LoginUserIdModel toModel(LoginUserIdVO loginUserId) {
		return createModelWithId(loginUserId, loginUserId);
	}

	/**
	 * モデル初期化
	 * @param loginUserId ログインユーザId
	 * @return ログインユーザIdモデル
	 */
	@Override
	protected LoginUserIdModel instantiateModel(LoginUserIdVO loginUserId) {
		return new LoginUserIdModel(loginUserId);
	}

	/**
	 * モデル初期化
	 * @param loginUsers ログインユーザリスト
	 * @return ログインユーザIdモデルリスト
	 */
	public CollectionModel<LoginUserIdModel> toCollectionModel(List<LoginUser> loginUsers) {
		List<LoginUserIdModel> LoginUserIdModels = new ArrayList<>();
		if (!CollectionUtils.isEmpty(loginUsers)) {
			loginUsers.stream().forEach(loginUser -> {
				LoginUserIdModels
						.add(createModelWithId(loginUser.getLoginUserId(), loginUser.getLoginUserId()));
			});
		}
		return CollectionModel.of(LoginUserIdModels);
	}
}
