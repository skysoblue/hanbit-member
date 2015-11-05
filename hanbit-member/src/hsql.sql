create table test(
	userid varchar(20),
	pass varchar(20),
	constraint test_pk primary key(userid)
);
insert into test values('hong','1');
select * from test;
shutdown;