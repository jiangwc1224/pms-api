package com.hyron.pms.userimport.presentation;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import com.hyron.pms.userimport.UserImport.UserNoVO;
import lombok.Getter;

/**
 * [Model]ユーザNo
 *
 * @author hyron xjiang.weichen
 *
 */
@Relation(value = "userImport", collectionRelation = "userImports")
@Getter
public class UserNoModel extends RepresentationModel<UserNoModel> {

	/** ユーザNo */
	private final UserNoVO userNo;

	/**
	 * コンストラクタ
	 * @param userNo ユーザNo
	 */
	UserNoModel(UserNoVO userNo) {
		this.userNo = userNo;
	}

}
