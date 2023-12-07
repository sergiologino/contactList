create schema if not exists contacts_schema;

create table if not exists contacts_schema.contact
(
    id bigint primary key ,
    firstName varchar(255) not null,
    lastName varchar(255) not null,
    email varchar(255) not null,
    phone varchar(255) not null
)