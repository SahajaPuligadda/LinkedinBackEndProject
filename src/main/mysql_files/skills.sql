create table skills
(
    id         int auto_increment
        primary key,
    uid        int                     not null,
    skill_name varchar(100) default '' not null,
    constraint skills_users_id_fk
        foreign key (uid) references users (id)
);
