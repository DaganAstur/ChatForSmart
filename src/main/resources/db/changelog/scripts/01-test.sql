create table user (
    id bigint auto_increment primary key,
    username varchar(250) not null,
    firstname varchar(250),
    lastname varchar(250),
    password varchar(250));

alter table user add constraint unique_username unique (username);