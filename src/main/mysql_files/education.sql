create table education
(
    id          int auto_increment
        primary key,
    uid         int                     not null,
    school      varchar(200) default '' not null,
    degree      varchar(200) default '' not null,
    field       varchar(200) default '' not null,
    start_date  date                    not null,
    end_date    date                    not null,
    grade       float        default 0  not null,
    description varchar(500) default '' not null,
    constraint education_users_id_fk
        foreign key (uid) references users (id)
);
