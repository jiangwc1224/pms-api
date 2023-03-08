package com.hyron.pms.userimport.presentation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.hyron.pms.userimport.UserImport;
import com.hyron.pms.userimport.UserImport.UserNoVO;

/**
 * [ModelAssembler]ユーザNo
 *
 * @author hyron xjiang.weichen
 *
 */
@Component
public class UserNoModelAssembler
		extends RepresentationModelAssemblerSupport<UserNoVO, UserNoModel> {

	/**
	 * コンストラクタ
	 */
	public UserNoModelAssembler() {
		super(UserImportController.class, UserNoModel.class);
	}

	/**
	 * モデルへ転換
	 * @param userNo ユーザNO
	 * @return ユーザNOモデル
	 */
	@Override
	public UserNoModel toModel(UserNoVO userNo) {
		return createModelWithId(userNo, userNo);
	}

	/**
	 * モデル初期化
	 * @param userNo ユーザNO
	 * @return ユーザNOモデル
	 */
	@Override
	protected UserNoModel instantiateModel(UserNoVO userNo) {
		return new UserNoModel(userNo);
	}

	/**
	 * モデル初期化
	 * @param users ユーザNoリスト
	 * @return ユーザNoモデルリスト
	 */
	public CollectionModel<UserNoModel> toCollectionModel(List<UserImport> users) {
		List<UserNoModel> userNoModels = new ArrayList<>();
		if (!CollectionUtils.isEmpty(users)) {
			users.stream().forEach(user -> {
				userNoModels
						.add(createModelWithId(user.getUserNo(), user.getUserNo()));
			});
		}
		return CollectionModel.of(userNoModels);
	}
}
