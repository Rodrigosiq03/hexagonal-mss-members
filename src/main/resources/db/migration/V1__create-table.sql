create table if not exists members (
    ra char(10) primary key,
    name varchar(255) not null,
    email varchar(255) not null unique,
    password varchar(255) not null
);