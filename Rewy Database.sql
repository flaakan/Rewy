drop database if exists rewy;
create database rewy;
use rewy;
create table user(
id int unsigned not null auto_increment primary key,
username varchar(45),
password varchar(45),
email varchar (50),
created timestamp DEFAULT current_timestamp
);

create table admin(
	id int unsigned not null auto_increment primary key,
user_id int unsigned not null,
foreign key(user_id) references user(id)
);

create table moviedetails(
id int unsigned not null auto_increment primary key,
name varchar(45),
description varchar (300),
rating double default 0
);
create table genre(
id int unsigned not null auto_increment primary key,
name varchar(45),
moviedetails_id int unsigned not null,
foreign key(moviedetails_id) references moviedetails(id)
);

create table review(
id int unsigned not null auto_increment primary key,
review_text varchar(300),
user_id int unsigned not null,
moviedetails_id int unsigned not null,
foreign key(user_id) references user(id),
foreign key(moviedetails_id) references moviedetails(id)
);

create table vote(
id int unsigned not null auto_increment primary key,
vote_type int default 0,
user_id int unsigned not null,
foreign key(user_id)references user(id));

create table review_vote(
id int unsigned not null auto_increment primary key,
review_id int unsigned not null,
vote_id int unsigned not null,
foreign key(review_id)references review(id),
foreign key(vote_id)references vote(id));

insert into user(username,password) values("Flakan","Flakan123");
insert into user(username,password) values("Doooku","Doooku123");
insert into user(username,password) values("FeedTown","FeedTown123");
insert into user(username,password) values("1","Flakan123");
insert into user(username,password) values("2","Doooku123");
insert into user(username,password) values("3","FeedTown123");

insert into admin(user_id) values(1);

insert into moviedetails(name,description) values("Avatar","Blue people fighting");
insert into moviedetails(name,description) values("Kill Bill","Bill needs to die");
insert into moviedetails(name,description) values("Harry Potter","A boy who likes magic");

insert into review(review_text,user_id,moviedetails_id) values("random movie, so bad why even make this shit",2,1);
insert into review(review_text,user_id,moviedetails_id) values("Bästa filmen bror",2,2);


insert into vote(vote_type,user_id) values(1,4);
insert into vote (vote_type,user_id) values(-1,3);
insert into vote(vote_type,user_id) values(1,1);


insert into review_vote(review_id, vote_id) values (1,1);
insert into review_vote(review_id, vote_id) values (1,2);

insert into genre(name, moviedetails_id) values ("Aniamtion",1);
insert into genre(name, moviedetails_id) values ("Comedy",1)
