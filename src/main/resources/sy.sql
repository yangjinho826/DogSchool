-- 회원가입 테이블 --
-- 0: 관리자 /1: 유저 /2: 선생님 /3: 원장
create table signup_table(
    id varchar2(20 char) primary key,
    pw varchar2(20 char) not null,
    name varchar2(50 char) not null,
    phonenumber varchar2(15 char) not null,
    gender varchar2(30 char) not null,
    typee int not null
);

select * from signup_table;

-- 원장 -> 관리자 신청 테이블 --
create table dapply_table(
da_no number(5) primary key,
da_id varchar2(20 char) not null, 
da_name varchar(20 char) not null,
da_schoolname varchar2(20 char) not null,
da_addr varchar2(50 char) not null, 
da_phonenumber varchar2(20 char) not null,
da_agree number(3) not null
);

create sequence Dapply_table_seq;

select * from dapply_table;

-- 선생님 -> 원장 신청 테이블 --
create table tapply_table(
ta_no number(5) primary key,
ta_da_no number(5) not null,
ta_id varchar2(20 char) not null,
ta_name varchar2(20 char) not null,
ta_phonenumber varchar2(20 char) not null,
ta_gender varchar2(20 char)not null,
ta_text varchar2(20 char)not null,
ta_agree number(3) not null 
);

create sequence tapply_table_seq;

select * from tapply_table;

-- 유저 –> 원장 신청 테이블 --
create table uapply_table(
ua_no number(5) primary key,
ua_da_no number(5),
ua_id varchar2(20 char) not null,
ua_name varchar2(50 char) not null,
ua_gender varchar2(30 char) not null,
ua_start date not null,
ua_end date not null,
ua_age number(3) not null,
ua_img varchar2(100 char)not null,
ua_tname varchar2(20 char)not null,
ua_agree number(3) not null
);

create sequence uapply_table_seq;

insert into UAPPLY_TABLE values(Uapply_table_seq.nextval, 1, 'sy', 'sy', 'w', to_date('2022-01-11', 'YYYY-MM-DD'), to_date('2022-01-20', 'YYYY-MM-DD'), 3, 'a.jpg', 'mz', 1)
insert into UAPPLY_TABLE values(Uapply_table_seq.nextval, 1, 'sy', 'sy2', 'w', to_date('2022-01-11', 'YYYY-MM-DD'), to_date('2022-01-20', 'YYYY-MM-DD'), 3, 'a.jpg', 'mz', 1)

select * from uapply_table;

-- 알림장 테이블 --
create table mypet_table(
mp_no number(3) primary key,
mp_title varchar2(30 char) not null,
mp_condition varchar2(30 char) not null,
mp_meal number(3) not null,
mp_defecate number(3) not null,
mp_supplies  varchar2(30 char) not null,
mp_txt varchar2 (200 char) not null,
mp_da_no number(5) not null,
mp_tid varchar2(30 char) not null,
mp_uid varchar2(30 char) not null,
mp_uname varchar2(30 char) not null, 
mp_date date not null
);

create sequence mypet_table_seq;

select * from mypet_table;

-- 갤러리 테이블 --
create table gallery_table(
g_no number(3) primary key,
g_title varchar2(30 char) not null,
g_img varchar2(100 char)not null,
g_da_no number(5),
g_tid varchar2(30 char) not null,
g_uid varchar2(30 char) not null,
g_uname varchar2(30 char) not null,
g_date date not null
);
