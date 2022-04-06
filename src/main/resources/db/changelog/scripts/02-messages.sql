create table message (
    id bigint auto_increment primary key,
    created_on datetime(3) not null,
    text varchar(500) not null,
    sender_user_id varchar(250) not null,
    message_type varchar(50) not null,
    receiver_user_id varchar(250),
    room_id varchar(250));
