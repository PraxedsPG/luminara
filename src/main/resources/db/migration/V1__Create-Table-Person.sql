CREATE TABLE person (
    id bigint not null auto_increment,
    first_name varchar(30) not null,
    last_name varchar(30) not null,
    birthday_date varchar(10) not null,
    country varchar(30) not null,
    city varchar(50) not null,
    street varchar(50) not null,
    house_number varchar(10) not null,

    primary key(id)
);