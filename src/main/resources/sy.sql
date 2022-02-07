--create table mypet_table_reply(
--	r_no number(5) primary key,
--	r_mp_no number(5) not null,
--	r_owner varchar2(10 char) not null,
--	r_txt varchar2(100 char) not null,
--	r_when date not null,
--	constraint mp_r
--		foreign key(r_mp_no)
--		references mypet_table(mp_no)
--		on delete cascade
--);

create table mypet_table_reply(
	r_no number(5) primary key,
	r_mp_no number(5) not null,
	r_owner varchar2(10 char) not null,
	r_txt varchar2(100 char) not null,
	r_when date not null
);
create sequence mypet_table_reply_seq;

select * from MYPET_TABLE_REPLY
