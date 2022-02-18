create table mypet_table_reply(
	r_no number(5) primary key,
	r_mp_no number(5) not null,
	r_owner varchar2(10 char) not null,
	r_txt varchar2(100 char) not null,
	r_when date not null
);
create sequence mypet_table_reply_seq;

select * from MYPET_TABLE_REPLY

select * from SIGNUP_TABLE

select * from TAPPLY_TABLE

select * from UAPPLY_TABLE

select * from MYPET_TABLE

-- 선생님이 가지고 있는 강아지만 출력
-- 유저가입할때 입력한 선생님이름과 선생님 테이블의 ta_name은 같고
-- 그 네임인데 agree = 1인 사람에 접근하여 그사람의 pk ta_no을 결국 알아야함
-- 근데 신청서상에 기입된 선생님 이름이 결과적으로 uapply를 조회하는데 필요한 상황.
				select *
				from uapply_table 
				where ua_tname in (
					select ta_name
					from tapply_table
					where ta_agree = 1
					and ta_no in (
						select  ta_no
						from TAPPLY_TABLE, SIGNUP_TABLE
						where ta_id = id and
						id = 't1'
						) 
					)

insert into UAPPLY_TABLE values(
Uapply_table_seq.nextval, 21, 'mz10', '나의유일강아지', '암컷', '20220201', 2, 'ㅁ.jpg','t1', 1);
    
insert into UAPPLY_TABLE values(
Uapply_table_seq.nextval, 1, 'asd', '요미', '여', '20220201', 2, 'ㅇ.jpg','선생엠지', 1);

-- 유저가 가지고 있는 강아지만 출력
select ua_name
from UAPPLY_TABLE
where ua_id = 'qwe' and ua_agree = 1

select * from SIGNUP_TABLE, UAPPLY_TABLE 
where id = ua_id and id = 'asd' and ua_agree = 1

-- a유치원 a선생님 a주인의 a강아지의 알림장 목록만 출력
select *
from mypet_table
where mp_tid = 't1'
and mp_uid = 'u1' and mp_uname = 'p1'

			select *
				from uapply_table, mypet_table 
				where ua_tname in (
					select ta_name
					from tapply_table
					where ta_agree = 1
					and ta_no in (
						select  ta_no
						from TAPPLY_TABLE, SIGNUP_TABLE
						where ta_id = id and
						id = 't1'
						) 
					)  and ua_id = mp_uid

					
select * from gallery_table order by g_no desc
					
select * from gallery_table
	where g_no = 21
	and g_tid = 't1'
	and g_uid = 'mz10'
	and g_uname = '나의유일강아지'


select *
from
(select *  from mypet_table order by mp_no desc)
where rownum <= 5;


select *
	from (select * from gallery_table order by g_no desc)
	where rownum <= 5

select rn, r_no, r_da_no, r_id,r_title,r_txt, r_date
			from (select Rownum as rn,r_no, r_da_no, r_id,r_title,r_txt, r_date
				from (select r_no, r_da_no, r_id,r_title,r_txt, r_date
					  from review_table
				      order by r_date desc))
		where RN between #{r_da_no} and #{r_no}








