drop database if exists rewy;
create database rewy;
use rewy;
	
create table user(
id int unsigned not null auto_increment primary key,
username varchar(45),
password varchar(45),
created timestamp DEFAULT current_timestamp
);

create table admin(
	id int unsigned not null auto_increment primary key,
user_id int unsigned not null,
foreign key(user_id) references user(id)
);

create table movie(
id int unsigned not null auto_increment primary key,
name varchar(45),
description varchar (300),
rating double default 0
);

insert into user(username,password) values("Flakan","Flakan123");
insert into user(username,password) values("Doooku","Doooku123");
insert into user(username,password) values("FeedTown","FeedTown123");
insert into user(username,password) values("1","Flakan123");
insert into user(username,password) values("2","Doooku123");
insert into user(username,password) values("3","FeedTown123");

insert into admin(user_id) values(1);

insert into movie(name,description) values("Avatar","Blue people fighting");
insert into movie(name,description) values("Kill Bill","Bill needs to die");
insert into movie(name,description) values("Harry Potter","A boy who likes magic");
