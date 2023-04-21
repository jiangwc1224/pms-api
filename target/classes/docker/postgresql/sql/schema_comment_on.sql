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

/* user_import */
comment on table user_import is 'ユーザ';
comment on column user_import.user_no is 'ユーザNo';
comment on column user_import.user_name is 'ユーザ名';
comment on column user_import.sex is '性别';
comment on column user_import.birth_day is '誕生日';
comment on column user_import.marital_status is '婚姻情況';
comment on column user_import.tel_no is '電話番号';
comment on column user_import.mail is 'メール';
comment on column user_import.address is '住所';
comment on column user_import.entry_date is '入社日';
comment on column user_import.term_date is '退社日';
comment on column user_import.work_years is '勤続年数';
comment on column user_import.job_level is '仕事レベル';
comment on column user_import.japanese_level is '日本語能力資格';
comment on column user_import.business_trip is '出張意向';
comment on column user_import.japan_stay_months is '日本滞在月数';
comment on column user_import.dept_no is '部門No';
comment on column user_import.dept_name is '部門名';
comment on column user_import.project_no is 'プロジェクトNo';
comment on column user_import.project_name is 'プロジェクト名';
comment on column user_import.leader_no is 'ユーザNo';
comment on column user_import.leader_name is 'ユーザ名';
comment on column user_import.term_flag is '退社フラグ';
comment on column user_import.skill_id is '技術';
comment on column user_import.graduate_date is '卒業年月';
comment on column user_import.school_name is '学校名';
comment on column user_import.subject_name is '専攻学科';
comment on column user_import.qualification is '資格称号';
comment on column user_import.career_id is '個人職歴';
comment on column user_import.experience_id is '項目履歴';
comment on column user_import.note is '備考';
comment on column user_import.version is 'バージョン';

/* dept */
comment on table dept is '部門';
comment on column dept.dept_no is '部門No';
comment on column dept.dept_name is '部門名';
comment on column dept.dept_num is '部門人数';
comment on column dept.leader_no is 'ユーザNo';
comment on column dept.leader_name is 'ユーザ名';
comment on column dept.dept_description is '部門の説明';
comment on column dept.version is 'バージョン';
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





/* skill */
comment on table skill is '技術';
comment on column skill.skill_id is '技術ID';
comment on column skill.technology_name is '技術名';
comment on column skill.technology_type is '技術種別';
comment on column skill.mastery_level is '把握程度';
comment on column skill.use_flag is '正式使用フラグ';
comment on column skill.version is 'バージョン';

/* career */
comment on table career is '職歴';
comment on column career.career_id is '職歴ID';
comment on column career.start_day is '開始日';
comment on column career.end_day is '終了日';
comment on column career.job_level is '仕事レベル';
comment on column career.note is '備考';
comment on column career.version is 'バージョン';

/* experience */
comment on table experience is '履歴';
comment on column experience.experience_id is '履歴ID';
comment on column experience.start_day is '開始日';
comment on column experience.end_day is '終了日';
comment on column experience.project_name is '開発プロジェクト名';
comment on column experience.machine_type is '機種';
comment on column experience.os_type is 'OS種類';
comment on column experience.used_software is '使用言語';
comment on column experience.duty_kubun is '職責区分';
comment on column experience.task_kubun is 'タスク区分';
comment on column experience.working_address is '仕事場所';
comment on column experience.version is 'バージョン';