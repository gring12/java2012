use javadb;
show tables;
describe tbluser;
select * from tbluser;

alter table tbluser
modify username varchar(20) after userid;

update tbluser 
set username = 'admin' 
where userid = 1;

CREATE TABLE tblboard (
	b_num int not null auto_increment,
    b_subject varchar(200) not null,
    b_contents varchar(2000) not null,
    b_name varchar(100) not null,
    b_passwd varchar(100) not null,
    b_wdate datetime not null default now(),
    b_udate datetime not null default now(),
    primary key (b_num)
);

drop table tblboard;

insert into tblboard (b_subject, b_contents, b_name, b_passwd)
	values ('안녕하세요', '안녕하세요내용', '홍길동', '1234');
    
select * from tblboard;

select * from tbluser;

CREATE TABLE tblpublisher (
 publisherid int not null auto_increment,
 name varchar(100) not null,
 address varchar(200) not null,
 phone varchar(50) not null,
 primary key(publisherid)
);

insert into tblpublisher (name, address, phone) values ('대한출판사', '청주시 상당구', '043-123-4567');

select * from tblpublisher;

insert into tblpublisher (name, address, phone) values ('한빛미디어', '서울시 종로구', '02-4567-7890');
insert into tblpublisher (name, address, phone) values ('한국출판', '청주시 흥덕구', '043-1234-5678');

select * from tblpublisher;

select * from tbluser;
insert into tbluser (username, userpwd, gender, addr) values ('test2', 'test2', 'F', 'test2');

CREATE TABLE tblemployee (
 employeeid int not null auto_increment,
 name varchar(100) not null,
 department varchar(100) not null,
 phone varchar(50) not null,
 authorid int not null,
 primary key(employeeid)
);

CREATE TABLE tblauthor (
 authorid int not null auto_increment,
 name varchar(100) not null,
 address varchar(200) not null,
 phone varchar(50) not null,
 primary key(authorid)
);

insert into tblemployee (name, department, phone, authorid) values ('홍길동', '문학', '010-1234-5678', 1), ('김철수', '문학', '010-4567-8970', 2), ('김영희', '에세이', '010-1597-4862', 3);
insert into tblauthor (name, address, phone) values ('정세령', '서울시 영등포구', '010-0000-0000');

select * from tblauthor;
update tblauthor set employeeid=1 where authorid=1;
update tblauthor SET name='김영하', address='경기도 분당시', phone='010-1234-5677' where authorid=2;
update tblauthor SET name='안은영', address='서울시 마포구', phone='010-1235-5687' where authorid=3;

select * from tblemployee;
update tblauthor set employeeid=1 where authorid=2;
update tblauthor set employeeid=3 where authorid=3;

CREATE TABLE tblmanagement (
username varchar(50) not null primary key,
userpwd varchar(50) not null);

insert into tblmanagement (username, userpwd) values ('admin', 'admin');
select * from tblmanagement;

create table tbltest(
name varchar(50) primary key,
addr varchar(100),
depart varchar(50),
salary int default(1000)
);

insert into tbltest (name, addr, depart, salary) values ('홍길동', '청주시', '영업', 3000), ('김철수', '대전광역시', '영업', 4000), ('이영희', '청주시', '총무', 2500), ('박민수', '충주시', '인사', 3500);
select * from tbltest;

select depart, sum(salary) from tbltest group by depart;

create table customer(
id bigint primary key auto_increment,
firstName varchar(50),
lastName varchar(50)
);

create table book(
pno int primary key auto_increment,
name varchar(100) not null,
publisher varchar(100) not null,
contents varchar(1000) not null,
pday int not null,
price int not null
);

insert into books (name, publisher, contents, pday, price) values ('ANYBODY/형체의 논리', '현대건축사', '새로운 문화는 어떻게 만들어 지는가?', 20060515, 27000);

create table review (
rname varchar(100) not null,
rbook varchar(100) not null,
contents varchar(200) not null
);

insert into review (rname, rbook, contents) values ('punch', '공간이 만든 공간', '건축이 만든 공간, 공간이 남긴 여백, 여백이 주는 생각');

select * from book;
select * from review;
