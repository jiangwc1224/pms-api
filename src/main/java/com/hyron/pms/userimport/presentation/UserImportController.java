package com.hyron.pms.userimport.presentation;


import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyron.pms.common.GeneralConstant;
import com.hyron.pms.userimport.UserImport;
import com.hyron.pms.userimport.UserImport.UserNoVO;
import com.hyron.pms.userimport.application.UserImportUsecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
/**
 * ユーザコントローラ
 *
 * @author hyron xjiang.weichen
 */
@RestController
@ExposesResourceFor(UserImport.class)
@RequestMapping(GeneralConstant.USER_HEADERS)
@RequiredArgsConstructor
@Slf4j
public class UserImportController {

	/** ユーザモデル */
	private final UserImportModelAssembler userImportModelAssembler;

	/** ユーザNoモデル */
	private final UserNoModelAssembler userNoModelAssembler;

	/** ユーザユーズケース */
	private final UserImportUsecase userImportUsecase;

	/**
	 * ユーザNo指定ユーザ取得
	 * @param userNo ユーザNo
	 * @return ユーザ
	 */
	@GetMapping(GeneralConstant.USER_GET)
	public ResponseEntity<?> getUser(@PathVariable(value = "userNo", required = true) String userNo){
		UserImport user = this.userImportUsecase.getDetail(UserNoVO.of(userNo));

		return ResponseEntity.ok().body(this.userImportModelAssembler.toModel(user));
	}

}
