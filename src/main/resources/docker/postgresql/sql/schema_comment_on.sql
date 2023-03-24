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

/** month_evaluation*/
comment on table month_evaluation is '月末評価';
comment on column month_evaluation.month_evaluation_id is '月末評価ID';
comment on column month_evaluation.evaluation_month is '評価月';
comment on column month_evaluation.project_summary is '所属プロジェクト';
comment on column month_evaluation.evaluated_user is '被評価者';
comment on column month_evaluation.assessor is '評価者';
comment on column month_evaluation.general_evaluation is '総評';
comment on column month_evaluation.working_attitude is '作業態度';
comment on column month_evaluation.working_attitude_evaluation is '作業態度評';
comment on column month_evaluation.working_quality is '作業品質';
comment on column month_evaluation.working_quality_evaluation is '作業品質評';
comment on column month_evaluation.working_progress is '作業進捗';
comment on column month_evaluation.working_progress_evaluation is '作業進捗評';
comment on column month_evaluation.communication is '交流';
comment on column month_evaluation.communication_evaluation is '交流評';
comment on column month_evaluation.others is 'その他';
comment on column month_evaluation.public_flag is '公開フラグ';
comment on column month_evaluation.version is 'バージョン';





