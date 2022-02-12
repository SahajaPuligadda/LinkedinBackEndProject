create table experience
(
    id           int auto_increment
        primary key,
    uid          int                     not null,
    title        varchar(200) default '' not null,
    emp_type     varchar(200) default '' not null,
    company_name varchar(200) default '' not null,
    location     varchar(200) default '' not null,
    start_date   date                    not null,
    end_date     date                    not null,
    description  varchar(500) default '' not null,
    constraint experience_users_id_fk
        foreign key (uid) references users (id)
);

