CREATE TABLE book (
    id bigint not null auto_increment,
    title varchar(60) not null,
    author varchar(70) not null,
    launch_date varchar(10) not null,
    price varchar(12) not null,

    primary key(id)
);
