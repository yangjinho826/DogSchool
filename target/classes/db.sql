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

select * from signup_table 
insert into signup_table values('root','1234','관리자','00000000000','남',0)

drop table gallery_table cascade constraint purge;
drop sequence gallery_table_seq;

-- 공지 테이블 --
create table notice_table(
	n_no number(3) primary key,
	n_da_no number(5) not null,
	n_id varchar2(20 char) not null,
	n_title varchar2(30 char) not null,	
	n_txt varchar2(4000 char) not null,
	n_date date not null
);

create sequence notice_seq;
-- 선생님 후기 테이블 --
create table postscript_table(
	p_no number(3) primary key,
	p_da_no number(5),
	p_id varchar2(20 char) not null,
	p_title varchar2(30 char) not null,	
	p_txt varchar2(4000 char) not null,
	p_date date not null
	
);
create sequence postscript_table_seq;


-- 가격표 테이블
create table priceTag_table(
	p_no number(3) primary key,
	p_da_no number(5) not null,
	p_Dogkind varchar2(20 char) not null,
	p_price number(10) not null,
	p_date number(10) not null
	
);
create sequence priceTag_table_seq;

-- 스케줄 테이블
create table schedule_table(
	s_no number(3) primary key,
	s_da_no number(5) not null,
	s_month varchar2(30 char) not null,
	s_text varchar2(30 char) not null,	
	s_day date not null
);

create sequence schedule_seq;

select * from schedule_table
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

select * from Uapply_table

-- 알림장 테이블 --
create table mypet_table(
	mp_no number(3) primary key,				-- 알림장 번호
	mp_title varchar2(30 char) not null,		-- 알림장 제목
	mp_condition varchar2(30 char) not null,	-- 강아지 건강상태
	mp_meal number(8) not null,					-- 우유량
	mp_defecate number(3) not null,				-- 배변량
	mp_supplies  varchar2(30 char) not null,	-- 준비물
	mp_txt varchar2 (200 char) not null,		-- 내용
	mp_da_no number(5) not null,				-- 유치원 번호
	mp_tid varchar2(30 char) not null,			-- 선생님 아이디
	mp_uid varchar2(30 char) not null,			-- 유저 아이디
	mp_uname varchar2(30 char) not null, 		-- 강아지 이름
	mp_date date not null						-- 알림장 작성 날짜
);
create sequence mypet_table_seq;

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
create sequence gallery_table_seq;
