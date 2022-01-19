-- 관리자 테이블 --

create table root_table(
	r_id varchar2(20 char) primary key,
	r_pw varchar2(20 char) not null
);


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
drop table priceTag_table cascade constraint purge;
drop sequence priceTag_seq
select * from priceTag_table;
create sequence priceTag_seq

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

