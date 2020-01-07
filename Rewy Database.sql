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
poster varchar(256),
imdb double default 0,
rotten_tomatoes decimal(5,2),
rewy double default 0
);

create table actor(
id int unsigned not null auto_increment primary key,
name varchar(45),
moviedetails_id int unsigned not null,
foreign key(moviedetails_id) references moviedetails(id)
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
insert into moviedetails(name,description) values("Memento","A man with short-term memory loss attempts to track down his wife's murderer.");
insert into moviedetails(name,description) values("The Dark Knight","When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
insert into moviedetails(name,description) values("The Grudge","An American nurse living and working in Tokyo is exposed to a mysterious supernatural curse, one that locks a person in a powerful rage before claiming their life and spreading to another victim.");



insert into review(review_text,user_id,moviedetails_id) values("random movie, so bad why even make this shit",2,1);
insert into review(review_text,user_id,moviedetails_id) values("Bästa filmen bror",2,2);


insert into vote(vote_type,user_id) values(1,4);
insert into vote (vote_type,user_id) values(-1,3);
insert into vote(vote_type,user_id) values(1,1);


insert into review_vote(review_id, vote_id) values (1,1);
insert into review_vote(review_id, vote_id) values (1,2);

insert into genre(name, moviedetails_id) values ("Sci-Fi",1);
insert into genre(name, moviedetails_id) values ("Adventure",1);
insert into genre(name, moviedetails_id) values ("Action",2);
insert into genre(name, moviedetails_id) values ("Fantasy",3);
insert into genre(name, moviedetails_id) values ("Thriller",4);
insert into genre(name, moviedetails_id) values ("Action",5);
insert into genre(name, moviedetails_id) values ("Crime",5);
insert into genre(name, moviedetails_id) values ("Horror",6);


insert into actor(name, moviedetails_id) values ("Sam Worthington", 3);
insert into actor(name, moviedetails_id) values ("Christian Bale", 5);
insert into actor(name, moviedetails_id) values ("Christian Bale", 2);

update moviedetails set poster = "https://m.media-amazon.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_SX300.jpg", imdb = 7.8, rotten_tomatoes = 82 where id = 1;
update moviedetails set poster = "https://m.media-amazon.com/images/M/MV5BNzM3NDFhYTAtYmU5Mi00NGRmLTljYjgtMDkyODQ4MjNkMGY2XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg", imdb = 8.1, rotten_tomatoes = 85 where id = 2;
update moviedetails set poster = "https://m.media-amazon.com/images/M/MV5BNjQ3NWNlNmQtMTE5ZS00MDdmLTlkZjUtZTBlM2UxMGFiMTU3XkEyXkFqcGdeQXVyNjUwNzk3NDc@._V1_SX300.jpg", imdb = 7.6, rotten_tomatoes = 81 where id = 3;
update moviedetails set poster = "https://m.media-amazon.com/images/M/MV5BZTcyNjk1MjgtOWI3Mi00YzQwLWI5MTktMzY4ZmI2NDAyNzYzXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg", imdb = 8.4, rotten_tomatoes = 92 where id = 4;
update moviedetails set poster = "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_SX300.jpg", imdb = 9.0, rotten_tomatoes = 94  where id = 5;
update moviedetails set poster = "https://m.media-amazon.com/images/M/MV5BMjIxODg1Nzc3NF5BMl5BanBnXkFtZTcwMjM0MjEzMw@@._V1_SX300.jpg", imdb = 5.9, rotten_tomatoes =39  where id = 6;