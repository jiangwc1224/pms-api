/* login_user */
comment on table login_user is 'ログインユーザ';
comment on column login_user.login_user_id is 'ログインユーザID';
comment on column login_user.user_no is 'ユーザNo';
comment on column login_user.password is 'パスワード';
comment on column login_user.valid_start_day is '有効期間_開始日';
comment on column login_user.valid_end_day is '有効期間_終了日';
comment on column login_user.cancel_date is '中止日';
comment on column login_user.cancel_flag is '中止フラグ';
comment on column login_user.version is 'バージョン';
comment on column login_user.initial_create_user_code is '初期登録担当者';
comment on column login_user.initial_create_date_and_time is '初期登録日時';
comment on column login_user.last_update_user_code is '最終更新担当者';
comment on column login_user.last_update_date_and_time is '最終更新日時';


