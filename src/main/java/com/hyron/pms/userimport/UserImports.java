package com.hyron.pms.userimport;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * [Repository]ユーザレポジトリ
 *
 * @author hyron xjiang.weichen
 */
public interface UserImports extends JpaRepository<UserImport, UserImport.UserNoVO> {

}
