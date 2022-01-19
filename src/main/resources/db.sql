-- 관리자 테이블 --

create table root_table(
	r_id varchar2(20 char) primary key,
	r_pw varchar2(20 char) not null
);

drop table teacher_table cascade constraint purge;
select * from root_table;
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

-- 원장-관리자 신청 테이블 --
create table Dapply_table(
	Da_no number(5) primary key, -- 유치원 구분
	Da_id varchar2(20 char) not null, 
	Da_name varchar(20 char) not null, --원장 이름
	Da_schoolname varchar2(20 char) not null,
	Da_addr varchar2(50 char) not null, 
	Da_phonenumber varchar2(20 char) not null,
	Da_agree number(3) not null --<- 0 수락시 1
);
create sequence Dapply_table_seq;
select * from Dapply_table;
select * from Dapply_table where Da_agree = 1;
drop table Dapply_table cascade constraint purge;
drop sequence Dapply_table_seq;

-- 선생님-원장 신청 테이블 --
create table Tapply_table(
	Ta_no number(5) primary key,
	Ta_da_no number(5) not null, --(유치원 구분 코드)
	Ta_id varchar2(20 char) not null, --(선생님정보 ↓)
	Ta_name varchar2(20 char) not null,
	Ta_phonenumber varchar2(20 char) not null,
	Ta_gender varchar2(20 char)not null,
	Ta_text varchar2(300 char)not null,
	Ta_agree number(3) not null 
);
create sequence Tapply_table_seq;
select * from Tapply_table;
drop table Tapply_table cascade constraint purge;
drop sequence Tapply_table_seq;

-- 견주-원장 신청 테이블 --
create table Uapply_table(
	Ua_no number(5) primary key,
	Ua_da_no number(5) not null, --(유치원 구분 코드)
	Ua_id varchar2(20 char) not null, --(견주 아이디)
	Ua_name varchar2(50 char) not null, --(강아지이름)
	Ua_gender varchar2(30 char) not null, --(강아지성별)
	Ua_daterange varchar2(30 char) not null, --(기간)
	Ua_age number(3) not null, --(강아지 나이)
	Ua_img varchar2(100 char)not null, --(강아지이미지)
	Ua_tname varchar2(20 char)not null, --(선생님 목록)
	Ua_agree number(3) not null --(수락or거절)
);
create sequence Uapply_table_seq;
drop table Uapply_table cascade constraint purge;
drop sequence Uapply_table_seq;
select * from Uapply_table;