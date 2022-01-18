-- 관리자 테이블 --

create table root_table(
	r_id varchar2(20 char) primary key,
	r_pw varchar2(20 char) not null
);

drop table signup_table cascade constraint purge;
select * from signup_table;
insert into signup_table values('id','123','김김','0101234','남',1);

select * from User_table where u_id = 'jy';

create table signup_table(
	id varchar2(20 char) primary key,
	pw varchar2(20 char) not null,
	name varchar2(50 char) not null,
	phonenumber varchar2(15 char) not null,
	gender varchar2(30 char) not null,
	typee int not null
);


-- 원장 테이블 --
create table director_table(
	id varchar2(20 char) primary key,
	pw varchar2(20 char) not null,
	name varchar2(50 char) not null,
	phonenumber varchar2(15 char) not null,
	gender varchar2(30 char) not null
);

-- 선생님 테이블 --
create table teacher_table(
	id varchar2(20 char) primary key,
	pw varchar2(20 char) not null,
	name varchar2(50 char) not null,
	phonenumber varchar2(15 char) not null,
	gender varchar2(30 char) not null
);

-- 유저 테이블 --
create table User_table(
	id varchar2(20 char) primary key,
	pw varchar2(20 char) not null,
	name varchar2(50 char) not null,
	phonenumber varchar2(15 char) not null,
	gender varchar2(30 char) not null
);