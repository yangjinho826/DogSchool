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


drop table teacher_table cascade constraint purge;
select * from root_table;
insert into root_table values('root','1234');


-- 원장 테이블 --
create table director_table(
	id varchar2(20 char) primary key,
	pw varchar2(20 char) not null,
	name varchar2(50 char) not null,
	phonenumber varchar2(15 char) not null,
	gender varchar2(30 char) not null


create table director_table(
	d_id varchar2(20 char) primary key,
	d_pw varchar2(20 char) not null,
	d_name varchar2(50 char) not null,
	d_phonenumber varchar2(15 char) not null,
	d_gender varchar2(30 char) not null  

);

-- 선생님 테이블 --
create table teacher_table(

	id varchar2(20 char) primary key,
	pw varchar2(20 char) not null,
	name varchar2(50 char) not null,
	phonenumber varchar2(15 char) not null,
	gender varchar2(30 char) not null

	t_id varchar2(20 char) primary key,
	t_pw varchar2(20 char) not null,
	t_name varchar2(50 char) not null,
	t_phonenumber varchar2(15 char) not null,
	t_gender varchar2(30 char) not null

);

-- 유저 테이블 --
create table User_table(

	id varchar2(20 char) primary key,
	pw varchar2(20 char) not null,
	name varchar2(50 char) not null,
	phonenumber varchar2(15 char) not null,
	gender varchar2(30 char) not null
);

	u_id varchar2(20 char) primary key,
	u_pw varchar2(20 char) not null,
	u_name varchar2(50 char) not null,
	u_phonenumber varchar2(15 char) not null,
	u_gender varchar2(30 char) not null
);


-- 공지 테이블 --
create table notice_table(
	n_no number(3) primary key,
	n_da_no number(5) not null,
	n_id varchar2(20 char) not null,
	n_title varchar2(30 char) not null,	
	n_txt varchar2(4000 char) not null,
	n_date date not null
);

alter sequence notice_seq nocaches
drop table schedule_table cascade constraint purge;
drop sequence priceTag_seq
select * from schedule_table;
create sequence schedule_seq;

-- 선생님 후기 테이블 --
create table postscript_table(
	p_no number(3) primary key,
	p_da_no number(5),
	p_id varchar2(20 char) not null,
	p_title varchar2(30 char) not null,	
	p_txt varchar2(4000 char) not null,
	p_date date not null
	
);


-- 가격표 테이블
create table priceTag_table(
	p_no number(3) primary key,
	p_da_no number(5) not null,
	p_Dogkind varchar2(20 char) not null,
	p_price number(10) not null,
	p_date number(10) not null
	
);


-- 스케줄 테이블
create table schedule_table(
	s_no number(3) primary key,
	s_da_no number(5) not null,
	s_month number(5) not null,
	s_text varchar2(30 char) not null,	
	s_day date not null
);

insert into schedule_table values(schedule_seq.nextval,1,1,'휴식1', sysdate)

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

