create table students
(
    id                  bigserial primary key,
    name                varchar(256) not null,
    registration_date   timestamp    not null
);
