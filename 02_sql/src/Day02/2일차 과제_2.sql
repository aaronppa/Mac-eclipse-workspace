--1.
create table tb_text(
  text_no number(5) not null,
  title varchar2(500) not null,
  content varchar2(4000) not null,
  user_id varchar2(16),
  reg_time date default sysdate not null,
  read_count number(5) default not null,
  recom_count number(5) default not null
);

create table tb_user(
  user_id varchar2(16) not null,
  password varchar2(16) not null,
  email varchar2(60)
);

create table tb_read_recom(
  text_no number(5) not null,
  user_id varchar2(16) not null,
  the_time date default sysdate not null
);

--2.
insert into tb_user (user_id, password, email) values('root', 'abcd1234','root@noname.com');
insert into tb_user (user_id, password, email) values('user1', 'abcd1234','user1@noname.com');
insert into tb_user (user_id, password) values('user2', 'abcd1234');  
insert into tb_user (user_id, password) values('user3', 'abcd1234');  

select * 
  from tb_user;

--3.
update tb_user
  set password = '12341234'
 where user_id = 'user1';

select * 
  from tb_user;
  
--4. 
update tb_user
  set email = 'user3@noname.com'
 where user_id = 'user3';

select * 
  from tb_user;
  
--5.
alter table tb_text
  modify (read_count number(5) default 0,
  recom_count number(5) default 0);

create sequence s_text_no;
drop sequence s_text_no;
delete tb_text;

insert into tb_text(text_no, user_id, title, content) values(s_text_no.nextval, 'user1','오늘하루','할 일 없었다.');

desc tb_text;

--6.
insert into tb_text(text_no, user_id, title, content) values(s_text_no.nextval, 'user2','오늘하루','할 일 많았다.');

select * 
  from tb_text;

--7. 
insert into tb_text(text_no, user_id, title, content) values(s_text_no.nextval, 'user3','오늘하루','할 일이란 무엇일까?');

--8. 
drop table tb_read_recom purge;

alter table tb_text
  modify text_no primary key;

alter table tb_read_recom
  modify text_no constraint comment_no_fk references tb_text(text_no) on delete cascade;

select count(*)
  from tb_text
 where text_no = 1
   and user_id = 'user3';

update tb_text
  set read_count = read_count+1
 where  text_no = 1
  and (select count(*)
              from tb_text
             where text_no = 1
               and user_id = 'user3')
        =0;

update tb_text
  set read_count = 0;

select * 
  from tb_text;

--9. 
update tb_text
  set read_count = read_count+1
 where  text_no = 1
  and (select count(*)
              from tb_text
             where text_no = 1
               and user_id = 'user1')
        =0;   

--10.
select count(*)
  from tb_text
 where text_no = 1
   and user_id = 'user2';

select count(*)
  from tb_read_recom
 where text_no = 1
   and user_id = 'user2'; 

insert into tb_read_recom(text_no,user_id) values (1, 'user2');

--11.
select count(*)
  from tb_text
 where text_no = 1
   and user_id = 'user3';

select count(*)
  from tb_read_recom
 where text_no = 1
   and user_id = 'user3'; 

insert into tb_read_recom(text_no,user_id) values (1, 'user3');
