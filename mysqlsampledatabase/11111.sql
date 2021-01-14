use javadb;
show tables;
describe tbluser;
select * from tbluser;

alter table tbluser
modify username varchar(20) after userid;

update tbluser 
set username = 'admin' 
where userid = 1;