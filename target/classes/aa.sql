select * from SIGNUP_TABLE, UAPPLY_TABLE 
where id = ua_id and id = 'mz' and ua_agree = 1


select DISTINCT * from SIGNUP_TABLE, UAPPLY_TABLE, TAPPLY_TABLE
where id = ta_id and id in (
	select id from SIGNUP_TABLE
	where typee = 2;
); 

-- 선생님이 가지고 있는 강아지만 출력

select ua_name
from uapply_table
where ua_tname = (
	select ta_name
	from tapply_table
	where ta_no = 3 and ta_agree = 1
	)

