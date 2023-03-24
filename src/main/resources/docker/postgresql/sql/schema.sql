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

create table if not exists "user"
(
    "user_no"                       varchar(6) not null,
    "version"                       bigint not null,
    "initial_create_user_code"      varchar(255),
    "initial_create_date_and_time"  timestamp,
    "last_update_user_code"         varchar(255),
    "last_update_date_and_time"     timestamp,
    primary key ("user_no")
);

create table if not exists "month_evaluation"
(
    "month_evaluation_id"           varchar(19) not null,
    "evaluation_month"              timestamp,
    "project_summary"               date not null,
    "evaluated_user"                date not null,
    "assessor"                      date not null,
    "general_evaluation"            date not null,
    "working_attitude"              varchar(256),
    "working_attitude_evaluation"   date not null,
    "working_quality"               varchar(256),
    "working_quality_evaluation"    date not null,
    "working_progress"              varchar(256),
    "working_progress_evaluation"   date not null,
    "communication"                 varchar(256),
    "communication_evaluation"      date not null,
    "others"                        varchar(256),
    "public_flag"                   boolean not null,
    "version"                       bigint not null,
    primary key ("month_evaluation_id")

)
