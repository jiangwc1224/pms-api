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
    "dept_name"                      varchar(256),
    "dept_num"                       int,
    "leader_no"                      varchar(6),
    "leader_ame"                   varchar(256),
    "dept_description"              varchar(256),
    "version"                      bigint not null,
    primary key ("dept_no")
    );

create table if not exists "skill"
(
    "skill_id"                       varchar(256) not null,
    "technology_name"                 varchar(256),
    "technology_type"                  int,
    "mastery_level"                     int,
    "use_flag"                          boolean,
    "version"                      bigint not null,
    primary key ("skill_id")
    );

create table if not exists "career"
(
    "career_id"                       varchar(256) not null,
    "start_day"                       date,
    "end_day"                          date,
    "job_level"                       int,
    "note"                           varchar(256),
    "version"                      bigint not null,
    primary key ("career_id")
    );

create table if not exists "experience"
(
    "experience_id"                       varchar(256) not null,
    "start_day"                           date,
    "end_day"                              date,
    "project_name"                        varchar(256),
    "machine_type"                        int,
    "os_type"                             varchar(256),
    "used_software"                        varchar(256),
    "duty_kubun"                           int,
    "task_kubun"                            varchar(256),
    "working_address"                           varchar(256),
    "version"                      bigint not null,
    primary key ("experience_id")
    );

create table if not exists "user_import"
(
    "user_no"                       varchar(6) not null,
    "user_name"                     varchar(256) not null,
    "sex"                           int not null,
    "birth_day"                     date,
    "marital_status"                int not null,
    "tel_no"                        varchar(11),
    "mail"                          varchar(256),
    "address"                       varchar(256),
    "entry_date"                    date,
    "term_date"                     date,
    "work_years"                    int,
    "job_level"                     int,
    "japanese_level"                int,
    "business_trip"                  int,
    "japan_stay_months"              int,
    "dept_no"                       varchar(4),
    "dept_name"                     varchar(256),
    "project_no"                    varchar(12),
    "project_name"                  varchar(256),
    "leader_no"                     varchar(6),
    "leader_name"                   varchar(256),
    "term_flag"                     boolean,
    "skill_id"                      varchar(256),
    "graduate_date"                  date,
    "school_name"                    varchar(256),
    "subject_name"                    varchar(256),
    "qualification"                   int,
    "career_id"                      varchar(256),
    "experience_id"                  varchar(256),
    "note"                          varchar(256),
    "version"                       bigint not null,
    primary key ("user_no"),
    constraint fk_skill_id foreign key("skill_id") references skill("skill_id"),
    constraint fk_career_id foreign key("career_id") references career("career_id"),
    constraint fk_experience_id foreign key("experience_id") references experience("experience_id")
);

