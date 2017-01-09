drop database if exists quaris;
create database quaris;
use quaris;

drop table if exists application;
create table application(
	id int not null,
	name varchar(20),
    admin int not null,
    primary key(id)
);

drop table if exists user;
create table user(
	id int not null,
    username varchar(30),
    application int not null,
    primary key (id)
);

drop table if exists admin;
create table admin(
	id int not null,
    application int not null
);

drop table if exists badge;
create table badge(
	id int not null,
    name varchar(20),
    description varchar(100),
    application int not null,
    primary key(id)
);

drop table if exists scale;
create table scale(
	id int not null,
	name varchar(20),
    description varchar(100),
    application int not null,
    primary key(id)
);

drop table if exists rule;
create table rule(
	id int not null,
	name varchar(20),
    rule_condition varchar(100),
    action varchar(500),
    enabled bool,
    application int not null,
    primary key(id)
);

drop table if exists event;
create table event(
	id int not null,
	name varchar(20),
    user_id int not null,
    payload varchar(400),
    timestamp datetime,
    application int not null,
    primary key(id),
    foreign key(user_id) references user(id)
);

create table user_badges (
	id int not null,
	user_id int not null,
	badge_id int not null,
	primary key (id),
    foreign key(user_id) references user(id),
    foreign key (badge_id) references badge(id)
);

create table user_scales (
	id int not null,
	user_id int not null,
	scale_id int not null,
	primary key (id),
    foreign key (user_id) references user(id),
    foreign key (scale_id) references scale(id)
);

alter table user add foreign key (application) references application(id);
alter table badge add foreign key (application) references application(id);
alter table scale add foreign key (application) references application(id);
alter table rule add foreign key (application) references application(id);
alter table event add foreign key (application) references application(id);
alter table admin add foreign key (application) references application(id);