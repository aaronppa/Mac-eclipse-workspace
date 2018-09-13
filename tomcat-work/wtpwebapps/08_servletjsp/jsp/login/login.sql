create table tb_member(
id varchar2(10) primary key,
name varchar2(30) not null,
pass varchar2(10) not null
);

insert into tb_member values('admin', '관리자', '1111');
insert into tb_member values('user1', '사용자1', '1111');
commit;