create table car(
id bigserial primary key,
vin varchar(40) not null unique,
car_number varchar(10) unique,
mark varchar(50),
model varchar(50),
mileage integer default 0,
prod_year integer default 1980,
color varchar(50),
body varchar(50),
price real default 0.0,
client_id varchar(100),
created timestamp default now());
