create table if not exists "login_user"
(
    "login_user_id"                 varchar(255) not null,
    "user_no"                       varchar(6),
    "password"                      varchar(255),
    "valid_start_day"               date not null,
    "valid_end_day"                 date not null,
    "cancel_date"                   date,
    "cancel_flag"                   boolean not null,
    "version"                       bigint not null,
    "initial_create_user_code"      varchar(255),
    "initial_create_date_and_time"  timestamp,
    "last_update_user_code"         varchar(255),
    "last_update_date_and_time"     timestamp,
    primary key ("login_user_id")
);


create table if not exists "dept"
(
    "dept_no"                       varchar(6) not null,
    "dept_name"                      varchar(255),
    "dept_num"                       int,
    "leader_no"                      varchar(6),
    "leader_name"                   varchar(255),
    "dept_description"              varchar(255),
    "version"                      bigint not null,
    primary key ("dept_no")
    );

create table if not exists "skill"
(
    "skill_id"                       varchar(255) not null,
    "technology_name"                 varchar(255),
    "technology_type"                  int,
    "mastery_level"                     int,
    "use_flag"                          boolean,
    "version"                      bigint not null,
    primary key ("skill_id")
    );

create table if not exists "career"
(
    "career_id"                       varchar(255) not null,
    "start_day"                       date,
    "end_day"                          date,
    "job_level"                       int,
    "note"                           varchar(255),
    "version"                      bigint not null,
    primary key ("career_id")
    );

create table if not exists "experience"
(
    "experience_id"                       varchar(255) not null,
    "start_day"                           date,
    "end_day"                              date,
    "project_name"                        varchar(255),
    "machine_type"                        int,
    "os_type"                             varchar(255),
    "used_software"                        varchar(255),
    "duty_kubun"                           int,
    "task_kubun"                            varchar(255),
    "working_address"                           varchar(255),
    "version"                      bigint not null,
    primary key ("experience_id")
    );

create table if not exists "user_import"
(
    "user_no"                       varchar(6) not null,
    "user_name"                     varchar(255) not null,
    "sex"                           int not null,
    "birth_day"                     date,
    "marital_status"                int not null,
    "tel_no"                        varchar(11),
    "mail"                          varchar(255),
    "address"                       varchar(255),
    "entry_date"                    date,
    "term_date"                     date,
    "work_years"                    int,
    "job_level"                     int,
    "japanese_level"                int,
    "business_trip"                  int,
    "japan_stay_months"              int,
    "dept_no"                       varchar(4),
    "dept_name"                     varchar(255),
    "project_no"                    varchar(12),
    "project_name"                  varchar(255),
    "leader_no"                     varchar(6),
    "leader_name"                   varchar(255),
    "term_flag"                     boolean,
    "skill_id"                      varchar(255),
    "graduate_date"                  date,
    "school_name"                    varchar(255),
    "subject_name"                    varchar(255),
    "qualification"                   int,
    "career_id"                      varchar(255),
    "experience_id"                  varchar(255),
    "note"                          varchar(255),
    "version"                       bigint not null,
    primary key ("user_no"),
    constraint fk_skill_id foreign key("skill_id") references skill("skill_id"),
    constraint fk_career_id foreign key("career_id") references career("career_id"),
    constraint fk_experience_id foreign key("experience_id") references experience("experience_id")
);

create table if not exists "month_evaluation"
(
    "month_evaluation_id"           varchar(19) not null,
    "evaluation_month"              timestamp,
    "project_summary"               date not null,
    "evaluated_user"                date not null,
    "assessor"                      date not null,
    "general_evaluation"            date not null,
    "working_attitude"              varchar(255),
    "working_attitude_evaluation"   date not null,
    "working_quality"               varchar(255),
    "working_quality_evaluation"    date not null,
    "working_progress"              varchar(255),
    "working_progress_evaluation"   date not null,
    "communication"                 varchar(255),
    "communication_evaluation"      date not null,
    "others"                        varchar(255),
    "public_flag"                   boolean not null,
    "version"                       bigint not null,
    primary key ("month_evaluation_id")

)
