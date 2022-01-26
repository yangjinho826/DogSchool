-- 관리자 테이블 --

create table root_table(
	r_id varchar2(20 char) primary key,
	r_pw varchar2(20 char) not null
);

drop table teacher_table cascade constraint purge;
select * from User_table;
insert into root_table values('root','1234');

-- 원장 테이블 --
create table director_table(
	d_id varchar2(20 char) primary key,
	d_pw varchar2(20 char) not null,
	d_name varchar2(50 char) not null,
	d_phonenumber varchar2(15 char) not null,
	d_gender varchar2(30 char) not null
);

-- 선생님 테이블 --
create table teacher_table(
	t_id varchar2(20 char) primary key,
	t_pw varchar2(20 char) not null,
	t_name varchar2(50 char) not null,
	t_phonenumber varchar2(15 char) not null,
	t_gender varchar2(30 char) not null
	
);

-- 유저 테이블 --
create table User_table(
	u_id varchar2(20 char) primary key,
	u_pw varchar2(20 char) not null,
	u_name varchar2(50 char) not null,
	u_phonenumber varchar2(15 char) not null,
	u_gender varchar2(30 char) not null
);

create table (

);
