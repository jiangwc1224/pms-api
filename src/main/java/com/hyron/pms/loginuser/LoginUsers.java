package com.hyron.pms.loginuser;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

/**
 * [Repository]ログインユーザレポジトリ
 *
 * @author hyron xjiang.weichen
 */
public interface LoginUsers extends JpaRepository<LoginUser, LoginUser.LoginUserIdVO> {

    /**
     * ユーザNoとパスワードより、有効なログインユーザを取得する
     * @param userNo ユーザNo
     * @param password パスワード
     * @param currentDate1 現在日付
     * @param currentDate2 現在日付
     * @return ログインユーザ
     */
    Optional<LoginUser> findByUserNoAndPasswordAndValidPeriod_ValidStartDayLessThanEqualAndValidPeriod_ValidEndDayGreaterThanEqualAndCancelFlagIsFalse(@NonNull String userNo,
                                                                                                                                                 @NonNull String password, LocalDate currentDate1, LocalDate currentDate2);
}
