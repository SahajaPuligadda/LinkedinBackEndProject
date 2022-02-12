create table users
(
    id       int auto_increment
        primary key,
    email    varchar(200) not null,
    password varchar(100) not null,
    constraint users_email_uindex
        unique (email)
);
