create table cities
(
    id      serial,
    title   varchar(255)          not null,
    deleted boolean default false not null,
    primary key (id)
);

create index cities_deleted_index
    on cities (deleted);

create table users
(
    id         bigserial,
    login      varchar(128)           not null,
    email      varchar(255)           not null,
    phone      varchar(32)            not null,
    first_name varchar(64)            not null,
    last_name  varchar(64)            not null,
    sur_name   varchar(64),
    gender     varchar(8)             not null,
    birthday   date                   not null,
    city_id    bigint                 not null,
    avatar     varchar(255)           not null,
    about      varchar(512),
    deleted boolean default false not null,
    primary key (id),
    constraint users_city_id_fk
        foreign key (city_id) references cities
);

create unique index users_login_uindex
    on users (login);

create index users_gender_index
    on users using hash (gender);

create index users_city_id_gender_index
    on users (city_id, gender);

create index users_city_id_index
    on users using hash (city_id);

create index users_deleted_index
    on users (deleted);

create table skills
(
    id      serial,
    title   varchar(255)           not null,
    deleted boolean default false not null,
    constraint skills_pk
        primary key (id)
);

create index skills_deleted_index
    on skills (deleted);

create table user_skills
(
    id       serial,
    user_id  bigint not null,
    skill_id bigint not null,
    constraint user_skills_pk
        primary key (id),
    constraint user_skills_users_id_fk
        foreign key (user_id) references users,
    constraint user_skills_skills_id_fk
        foreign key (skill_id) references skills
);

create table followers
(
    id          serial,
    follower_id bigint not null,
    user_id     bigint not null,
    constraint followers_pk
        primary key (id),
    constraint followers_follower_id_users_id_fk
        foreign key (follower_id) references users,
    constraint followers_users_user_id_fk
        foreign key (user_id) references users
);

create unique index followers_follower_id_user_id_uindex
    on followers (follower_id, user_id);

alter table followers
    add constraint followers_not_equal_id
        check (user_id <> follower_id);

