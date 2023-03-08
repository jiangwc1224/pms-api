package com.hyron.pms.loginuser.presentation;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import com.hyron.pms.loginuser.LoginUser.LoginUserIdVO;
import lombok.Getter;

/**
 * [Model]ログインユーザId
 *
 * @author hyron xjiang.weichen
 *
 */
@Relation(value = "loginUser", collectionRelation = "loginUsers")
@Getter
public class LoginUserIdModel extends RepresentationModel<LoginUserIdModel> {

	/** ログインユーザId */
	private final LoginUserIdVO loginUserId;

	/**
	 * コンストラクタ
	 * @param loginUserId ログインユーザId
	 */
	LoginUserIdModel(LoginUserIdVO loginUserId) {
		this.loginUserId = loginUserId;
	}

}
