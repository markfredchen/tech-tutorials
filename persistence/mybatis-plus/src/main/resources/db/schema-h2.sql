create table mp_user
(
    id bigint null,
    username varchar(50) not null,
    phone varchar(20) not null,
    is_enabled boolean default true null,
    is_deleted boolean default false null,
    created_date datetime default now() not null,
    constraint mp_user_pk
        primary key (id)
);

create unique index mp_user_username_uindex
    on mp_user (username);

create table mp_company
(
    id bigint null,
    company_name varchar(50) not null,
    config JSON not null,
    version int not null,
    constraint mp_company_pk
        primary key (id)
);