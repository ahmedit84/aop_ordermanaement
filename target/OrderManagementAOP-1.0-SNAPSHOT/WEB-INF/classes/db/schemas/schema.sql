drop table customers if exists;
drop table orders if exists;

create table customers (customerId integer identity primary key, name varchar(255));
create table orders (orderId integer identity primary key, description varchar(255),customerId integer);
