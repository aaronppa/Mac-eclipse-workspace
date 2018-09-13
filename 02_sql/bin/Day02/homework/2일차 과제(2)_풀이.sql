문제 1.
create table tb_user (
    user_id   varchar2(16) primary key,
    password varchar2(16) not null,
    email    varchar2(60)
);

create table tb_text (
    text_no number(5) primary key,
    title varchar2(500) not null,
    content varchar2(4000) not null,
    user_id varchar2(16) references tb_user(user_id),
    reg_time date,
    read_count number(5) not null,
    recom_count number(5) not null
);

create table tb_read_recom (
    text_no number(5) not null,
    user_id varchar2(16) not null,
    reg_time date not null,
    primary key (text_no, user_id),
    foreign key(text_no) references tb_text(text_no),
    foreign key(user_id) references tb_user(user_id)
);

문제 2.
insert into tb_user(user_id, password, email) values('root', 'abcd1234', 'root@noname.com');
insert into tb_user(user_id, password, email) values('user1', 'abcd1234', 'user1@noname.com');
insert into tb_user(user_id, password) values('user2', 'abcd1234');
insert into tb_user(user_id, password) values('user3', 'abcd1234');

문제 3.
update tb_user
     set password = '12341234'
 where user_id = 'user1';

문제 4.
update tb_user
   set email = 'user3@noname.com'
 where user_id = 'user3';


문제 5.
insert into tb_text(
    text_no, title, content, user_id, reg_time, read_count, recom_count
) values (
    1, '오늘하루', '할 일 없었다', 'user1', sysdate, 0, 0
);

문제 6.
insert into tb_text(
    text_no, title, content, user_id, reg_time, read_count, recom_count
) values (
    2, '오늘하루', '할 일 많았다', 'user2', sysdate, 0, 0
);

문제 7.
insert into tb_text(
    text_no, title, content, user_id, reg_time, read_count, recom_count
) values (
    3, '오늘하루', '할 일이란 과연 무엇일까?', 'user3', sysdate, 0, 0
);

문제 8.
-- user3이 쓰지 않았다면 카운트는 0이다.
select count(*)
  from tb_text
 where text_no = 1
   and user_id = 'user3';

-- 자신이 쓴 글이 아닐 경우(카운트가 0이면) 업데이트 구문 시작
update tb_text
   set read_count = read_count + 1
 where text_no = 1;

문제 9.
-- user1이 쓰지 않았다면 카운트는 0이다.
select count(*)
  from tb_text
 where text_no = 1
   and user_id = 'user1';

-- 자신이 쓴 글이 아닐 경우(카운트가 0이면) 업데이트 구문 시작
update tb_text
   set read_count = read_count + 1
 where text_no = 1;

/*
문제 10. user2이 1번 글을 추천합니다.
- 자신이 쓴 글인지 아닌지를 조사합니다. 자신이 쓴 글은 추천할 수 없습니다.
- 기존에 추천한 기록이 있는지 조사합니다.
- 없을 경우 추천 횟수를 증가시키고 추천 기록을 테이블에 입력합니다.
*/
-- 자신이 쓴 글인지 아닌지를 조사합니다. 자신이 쓴 글은 추천할 수 없습니다.
select count(*)
  from tb_text
 where text_no = 1
   and user_id = 'user2';

-- 기존에 추천한 기록이 있는지 조사합니다.
-- 자신이 쓴글이 아닐 경우에만 처리부분(count가 0이면 진행)
select count(*)
  from tb_read_recom
 where text_no = 1
   and user_id = 'user2';

--  없을 경우 추천 횟수를 증가시키고 추천 기록을 테이블에 입력합니다.
--  위의 커리 결과가 0일 경우 진행
update tb_text
   set recom_count = recom_count + 1
 where text_no = 1;

insert into tb_read_recom(
    text_no, user_id, reg_time
) values ( 
    1, 'user2', sysdate
);

/*
문제 11. user3이 1번글을 추천합니다.
- 자신이 쓴 글인지 아닌지를 조사합니다. 자신이 쓴 글은 추천할 수 없습니다.
- 기존에 추천한 기록이 있는지 조사합니다.
- 없을 경우 추천 횟수를 증가시키고 추천 기록을 테이블에 입력합니다.
*/
-- 자신이 쓴 글인지 아닌지를 조사합니다. 자신이 쓴 글은 추천할 수 없습니다.
select count(*)
  from tb_text
 where text_no = 1
   and user_id = 'user3';

-- 기존에 추천한 기록이 있는지 조사합니다.
-- 자신이 쓴글이 아닐 경우에만 처리부분(count가 0이면 진행)
select count(*)
  from tb_read_recom
 where text_no = 1
   and user_id = 'user3';

--  없을 경우 추천 횟수를 증가시키고 추천 기록을 테이블에 입력합니다.
--  위의 커리 결과가 0일 경우 진행
update tb_text
   set recom_count = recom_count + 1
 where text_no = 1;

insert into tb_read_recom(
    text_no, user_id, reg_time
) values (
    1, 'user3', sysdate
);