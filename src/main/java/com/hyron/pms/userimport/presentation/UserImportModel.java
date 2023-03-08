package com.hyron.pms.userimport.presentation;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.hyron.pms.userimport.UserImport;

import lombok.Getter;

/**
 * [Model]ユーザ
 *
 * @author hyron xjiang.weichen
 *
 */
@Relation(value = "userImport", collectionRelation = "userImports")
@Getter
public class UserImportModel extends RepresentationModel<UserImportModel> {

	/** ユーザ */
	@JsonUnwrapped
	private UserImport userImpot;

	/**
	 * コンストラクタ
	 * @param userImpot ユーザ
	 */
	UserImportModel(UserImport userImpot) {
		this.userImpot = userImpot;
	}

}
