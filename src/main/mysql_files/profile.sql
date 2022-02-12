create table profile
(
    id        int auto_increment
        primary key,
    name      varchar(200) default '' not null,
    uid       int                     not null,
    tagline   varchar(500) default '' not null,
    location  varchar(200) default '' not null,
    about     varchar(500) default '' not null,
    photo     varchar(500) default '' not null,
    workplace varchar(100) default '' not null,
    constraint uid
        foreign key (uid) references users (id)
);
