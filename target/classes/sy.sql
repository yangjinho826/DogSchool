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

select * from GALLERY_TABLE

delete from MYPET_TABLE_REPLY

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

insert into GALLERY_TABLE values(
61,'귀여3334576576', '8f6a344f-f0dc-4f8d-adbc-311e0fed43dd.jpg!697bf776-6ca7-4886-b256-85a1c03a3d55.jpg!',21,'t1',41,'u1','p1', '2022-02-16');

65 p111         f9a3555d-620b-409d-a098-3bcf2fa79383.jpg!b84f6dd5-1fe9-4d86-893d-6356e11a4670.jpg!      21 t1    u1    p1      2022-02-14 00:00:00.0
   62 귀여2368283    f5bd38f0-7f30-4fb7-8d95-72f8867097e1.jpg!3e9cb4ce-3c30-4d71-ad7a-bfb8da7bddd3.jpg!      21 t1    mz10  나의유일강아지 2022-02-14 00:00:00.0
   61 귀여3334576576 8f6a344f-f0dc-4f8d-adbc-311e0fed43dd.jpg!697bf776-6ca7-4886-b256-85a1c03a3d55.jpg!      21 t1    mz10  나의유일강아지 2022-02-14 00:00:00.0
   
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


select * from (select * from mypet_table order by mp_no desc)
		where mp_tid = 't1'
		and mp_uid = 'u1'
		and mp_uname = 'p1'
		and rownum &lt;= 5
		order by mp_no desc

select *
from (select * from mypet_table order by mp_no desc)
	where rownum <= 5
	and mp_uname = 'p1'
	and mp_tid = 't1'
	and mp_uid = 'u1'

insert into mypet_table values(mypet_table_seq.nextval, 'zz', 'zz',1,2,'aa'
,'tt',1,'t1',41,'u1','p1',sysdate)

select * from(
select * from mypet_table
		where mp_tnum = 41
		and mp_uid = 'u1'
		and mp_uname = 'p1'
		order by mp_no desc)
		where rownum between 1 and 3
		
		select count(*) from mypet_table where mp_da_no = 1
		
		
select * from mypet_table_reply where r_mp_no = 11 order by r_no desc