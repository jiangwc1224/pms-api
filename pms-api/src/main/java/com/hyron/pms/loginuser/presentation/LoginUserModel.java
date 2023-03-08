package com.hyron.pms.loginuser.presentation;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.hyron.pms.loginuser.LoginUser;

import lombok.Getter;

/**
 * [Model]ログインユーザ
 *
 * @author hyron xjiang.weichen
 *
 */
@Relation(value = "loginUser", collectionRelation = "loginUsers")
@Getter
public class LoginUserModel extends RepresentationModel<LoginUserModel> {

	/** ログインユーザ */
	@JsonUnwrapped
	private LoginUser loginUser;

	/**
	 * コンストラクタ
	 * @param loginUser ログインユーザ
	 */
	LoginUserModel(LoginUser loginUser) {
		this.loginUser = loginUser;
	}

}
