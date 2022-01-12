-- 유저 –> 원장 신청 테이블 --
create table Uapply_table(
Ua_no number(5) primary key,
Ua_da_no number(5),
Ua_id varchar2(20 char) not null,
Ua_name varchar2(50 char) not null,
Ua_gender varchar2(30 char) not null,
Ua_start date not null,
Ua_end date not null,
Ua_age number(3) not null,
Ua_img varchar2(100 char)not null,
Ua_tname varchar2(20 char)not null,
Ua_agree number(3) not null
);

create sequence Uapply_table_seq;

insert into UAPPLY_TABLE values(Uapply_table_seq.nextval, 1, 'sy', 'sy', 'w', to_date('2022-01-11', 'YYYY-MM-DD'), to_date('2022-01-20', 'YYYY-MM-DD'), 3, 'a.jpg', 'mz', 1)
insert into UAPPLY_TABLE values(Uapply_table_seq.nextval, 1, 'sy', 'sy2', 'w', to_date('2022-01-11', 'YYYY-MM-DD'), to_date('2022-01-20', 'YYYY-MM-DD'), 3, 'a.jpg', 'mz', 1)

select * from Uapply_table;