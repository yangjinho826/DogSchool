-- 회원가입 테이블 --
-- 0: 관리자 /1: 유저 /2: 선생님 /3: 원장
create table signup_table(
    id varchar2(20 char) primary key,		-- 아이디
    pw varchar2(20 char) not null,			-- 비밀번호
    name varchar2(50 char) not null,		-- 이름
    phonenumber varchar2(15 char) not null,	-- 핸드폰번호
    gender varchar2(30 char) not null,		-- 성별
    typee int not null						-- 관리자/유저/선생님/원장 구분
);

select * from signup_table;

insert into SIGNUP_TABLE values('mz', '1004', '엠지', '11111111', '남', 1)
insert into SIGNUP_TABLE values('mzz', '1004', '선생엠지', '11111111', '남', 2)
insert into SIGNUP_TABLE values('sy', '1004', '승연', '22222222', '남', 2)
insert into SIGNUP_TABLE values('syy', '1004', '유저승연', '22222222', '남', 1)
-- 유저 –> 원장 신청 테이블 --
create table uapply_table(
ua_no number(5) primary key,				-- 유저 번호
ua_da_no number(5),							-- 유치원 번호
ua_id varchar2(20 char) not null,			-- 유저 아이디
ua_name varchar2(50 char) not null,			-- 강아지 이름
ua_gender varchar2(30 char) not null,		-- 강아지 성별
ua_start date not null,						-- 강아지 유치원 시작날짜
ua_end date not null,						-- 강아지 유치원 종료날짜 
ua_age number(3) not null,					-- 강아지 나이
ua_img varchar2(100 char)not null,			-- 강아지 사진
ua_tname varchar2(20 char)not null,			-- 담당 선생님 이름
ua_agree number(3) not null					-- 신청 수락/거절
);

insert into UAPPLY_TABLE values(Uapply_table_seq.nextval,
1, 'syy', '요미', '여아', to_date('2022-01-11', 'YYYY-MM-DD'), to_date('2022-01-20', 'YYYY-MM-DD'),
3, 'a.jpg', '선생엠지', 1)
insert into UAPPLY_TABLE values(Uapply_table_seq.nextval,
1, 'syy', '요미', '여아', to_date('2022-01-11', 'YYYY-MM-DD'), to_date('2022-01-20', 'YYYY-MM-DD'),
3, 'a.jpg', '선생엠지', 1)
insert into UAPPLY_TABLE values(Uapply_table_seq.nextval, 1, 'sy', 'sy2', 'w', to_date('2022-01-11', 'YYYY-MM-DD'), to_date('2022-01-20', 'YYYY-MM-DD'), 3, 'a.jpg', 'mz', 1)
delete UAPPLY_TABLE
select * from uapply_table;
-- 원장 -> 관리자 신청 테이블 --
create table dapply_table(
da_no number(5) primary key,				-- 유치원 번호
da_id varchar2(20 char) not null, 			-- 원장 아이디
da_name varchar(20 char) not null,			-- 원장 이름
da_schoolname varchar2(20 char) not null,	-- 유치원 이름
da_addr varchar2(50 char) not null, 		-- 유치원 주소
da_phonenumber varchar2(20 char) not null,	-- 유치원 전화번호
da_agree number(3) not null					-- 신청 수락/거절
);

create sequence Dapply_table_seq;

select * from dapply_table;

-- 선생님 -> 원장 신청 테이블 --
create table tapply_table(
ta_no number(5) primary key,				-- 선생님 번호
ta_da_no number(5) not null,				-- 유치원 번호
ta_id varchar2(20 char) not null,			-- 선생님 아이디
ta_name varchar2(20 char) not null,			-- 선생님 이름
ta_phonenumber varchar2(20 char) not null,	-- 선생님 전화번호
ta_gender varchar2(20 char)not null,		-- 선생님 성별
ta_text varchar2(20 char)not null,			-- 선생님 자기소개
ta_agree number(3) not null 				-- 신청 수락/거절
);
insert into TAPPLY_TABLE values(tapply_table_seq.nextval,
1, 'sy', '승연', 22222222, '남', '헤헤', 1)
insert into TAPPLY_TABLE values(tapply_table_seq.nextval,
1, 'teacher', '선생님', 22222222, '남', '헤헤', 0)
insert into TAPPLY_TABLE values(tapply_table_seq.nextval,
1, 'mzz', '선생엠지', 11111111, '남', '히히', 1)
create sequence tapply_table_seq;

select * from tapply_table;



create sequence uapply_table_seq;



-- 알림장 테이블 --
create table mypet_table(
mp_no number(3) primary key,				-- 알림장 번호
mp_title varchar2(30 char) not null,		-- 알림장 제목
mp_condition varchar2(30 char) not null,	-- 강아지 건강상태
mp_meal number(3) not null,					-- 우유량
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
select * from mypet_table;

insert into MYPET_TABLE values(mypet_table_seq.nextval, '알림장1', '좋음', 100, 1, '이불', '오늘의 알림', 1, 'sy', 'mz', '초코', to_date(sysdate, 'yyyy.mm.dd hh24:mi'))

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
