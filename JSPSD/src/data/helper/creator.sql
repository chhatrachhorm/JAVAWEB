create database jspsd;
grant all on jspsd.* to jspsd;
use jspsd;
drop table if exists users;
create table users (
  id integer unique auto_increment primary key,
  username varchar(100) unique not null,
  email varchar(100) unique not null,
  password varchar(100) not null,
  phone_number varchar(100) unique not null,
  dob date not null);
select * from users;