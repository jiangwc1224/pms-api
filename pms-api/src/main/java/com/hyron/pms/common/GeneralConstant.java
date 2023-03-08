package com.hyron.pms.common;

/**
 * PMS通用定数
 *
 * @author hyron xjiang.weichen
 *
 */
public class GeneralConstant {
    /**
     * コンストラクタ
     */
    private GeneralConstant() {
    }

    /********************** ログインユーザ Start ***********************************/
    /*** API一覧 Start ***/
    /** ログインユーザコントローラ */
    public static final String LOGIN_USER_HEADERS = "/login-users";

    /** ログインユーザコントローラ-ユーザNo指定ユーザ取得 */
    public static final String LOGIN_USER_GET_FOR_LOGIN = "/{loginUserNo}";
    /*** API一覧 End ***/
    /********************** ログインユーザ End ***********************************/


    /********************** ユーザ Start ***********************************/
    /*** API一覧 Start ***/
    /** ユーザコントローラ */
    public static final String USER_HEADERS = "/users";

    /** ユーザコントローラ-ユーザNo指定ユーザ取得 */
    public static final String USER_GET = "/{userNo}";
    /*** API一覧 End ***/
    /********************** ユーザ End ***********************************/
}
