create table Candle(
    candle_id int primary key,
    name varchar(50) not null,
    price double not null,
    quantity int not null,
    description varchar(200) not null
);