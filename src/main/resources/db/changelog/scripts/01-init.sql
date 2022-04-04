create table user (
    id bigint auto_increment primary key,
    username varchar(250) not null,
    firstname varchar(250),
    lastname varchar(250),
    password varchar(250),
    created_on datetime(3) not null);

alter table user add constraint unique_username unique (username);

create table room (
    id bigint auto_increment primary key,
    name varchar(250) not null,
    created_on datetime(3) not null);

alter table room add constraint unique_roomname unique (name);



