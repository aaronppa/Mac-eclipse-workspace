//------------------------------------------
group by 
- 데이터들을 소그룹으로 묶어준다.
- 그룹함수와 같이 사용을 한다.
* 그룹함수 : 여러개의 데이터를 받아서 하나의 결과를 반환
              : null은 자동으로 배제한다, 단, count(*)은 널까지 포함....
   count(*)
   count(last_name)
   sum(salary), max(salary), min(salary), avg(salary)
   
-- 사원들의 전체 수를 표시하고 최대급여가 얼마인지 출력
select count(*), count(commission_pct), max(salary)
  from employees;   
  
-- 100번 부서의 사원들의 수와 부서에서 가장 높은 급여와 가장 낮은 급여를 출력
select count(*), max(salary), min(salary)
  from employees
 where department_id = 100;
 
-- 각 부서별 사원들의 수와 부서에서 가장 높은 급여와 가장 낮은 급여를 출력
select department_id, last_name, count(*), max(salary), min(salary)
  from employees
group by department_id
order by department_id;

create table tb_group (
    id varchar2(3), 
    sal number,
    job_id varchar2(2),
    dept_id number
);

select * from tb_group;

insert into tb_group values('a', 1000, 'SA', 10);

insert into tb_group values('b', 2000, 'CM', 30);

insert into tb_group values('c', 3000, 'CM', 20);

insert into tb_group values('d', 4000, 'LA', 10);

insert into tb_group values('e', 3000, 'SA', 30);

insert into tb_group values('f', 2000, 'SA', 10);

select * 
  from tb_group;
 
select job_id, max(sal), count(*)
  from tb_group
 group by job_id, dept_id;
  
-- 각 부서별 최대급여를 출력합니다. 단, 최대 급여가 높은 부서부터 출력
-- order by는 select에서 추가한 컬럼의 alias를 사용할 수 있다.
select department_id, max(salary) as max_sal
  from employees
 group by department_id
 order by max_sal desc;

select
from 
where
group by
order by

from -> where -> group by -> select -> order by 

-- 각 부서별 최대급여를 출력합니다. 단, 최대 급여가 높은 부서부터 출력
-- 최대급여가 10000 이상인 부서를 대상으로 합니다.
-- 아래의 쿼리는 에러 발생 : 그룹함수는 where 에 허용되지 않는다.
select department_id, max(salary) as max_sal
  from employees
 where  max(salary) >= 10000
 group by department_id
 order by max_sal desc;
 
//-----------------------------------------
having : 그룹에 대한 제약을 처리한다.

select department_id, max(salary) as max_sal
  from employees
 group by department_id
 having  max(salary) >= 10000
 order by max_sal desc;

-- 부서별 평균 급여를 출력합니다.
-- 단, 100번보다 큰 부서는 제외하고
-- 부서의 평균급여가 5000 이상인 부서만 출력
-- 부서번호 순으로 출력
select department_id dept_id, avg(salary) avg_sal
  from employees
 where department_id <= 100
 group by department_id
having avg(salary) >= 5000
 order by department_id;  


//--------------------------------------------------------------
DDL 명령어 이해하기
create - 테이블 생성
drop - 테이블 삭제
truncate - 테이블의 데이터를 복구 불가능하게 전체 삭제
rename - 테이블의 이름 변경
alter - 테이블의 컬럼 또는 제약조건 변경
desc - 테이블의 구조를 확인

DML 명령어
insert
update
delete


create 명령어
create table 테이블명

내부적으로 테이블명과 컬럼명은 기본으로 대문자로 저장된다.

create table test 
create table TEST

create table 테이블명 (
    컬럼명  타입(크기),
    컬럼명  타입(크기),
    ....
    컬럼명  타입(크기)
);

-- 테이블 이름 만들기   :  t_... ,  tb_...., tc_..., th_....

//---
데이터 타입
문자 : varchar2(가변길이) - 크기를 설정해야 한다., varchar, char(고정길이) - 크기를 별도 지정 하지 않아도 됨..
숫자 : number
날짜 : date

-- 용어
슈퍼키 - 각 행을 유일하게 식별할 수 있는 컬럼 또는 컬럼의 집합
주민번호, 주소, 이름, 핸드폰번호
주민번호, 주민번호 + 이름, 주민번호 + 핸드폰번호, .....

후보키 - 각 행을 식별할 수 있는 최소의 컬럼의 집합
주민번호, 회원번호

기본키(primary key) - 여러개의 후보키 중에서 하나의 키를 선정해서 대표로 삼는 키
회원번호 

대리키 - 인위적으로 만드는 값(시퀀스) 
회원번호, 게시물번호

-- 게시물에 대한 정보를 표현하는 테이블 만들자...
-- tb_board : 테이블명
create table tb_board(
    no number,
    title varchar2(200),
    reg_date date,
    writer varchar2(30),
    view_cnt number(6),
    content varchar2(4000)
);

select *
  from tab;

-- 생성된 테이블을 삭제하자
drop table 테이블명;

drop table tb_board;

select *
  from tab;

-- 휴지통 비우기
purge recyclebin;

select *
  from tab;

-- 휴지통에 넣지않고 완전히 삭제...
drop table 테이블명 purge;

drop table tb_board purge;

select * from tab;

//-------------------------------------------------
테이블의 제약조건을 이해하자...
제약조건 설정 방식 : 테이블레벨, 컬럼레벨
제약조건 종류
- 1. PK : primary key
      - 테이블에 단 하나만 설정(여러개 설정 불가능)
      - 여러개의 컬럼을 묶어서 만들수 있다.(복합컬럼 - 테이블 레벨만 가능함)
      - not null + unique 조합
      - 테이블에 입력되는 행의 데이터를 구분하는 역활을 수행...
      
- 2. NN : not null
      - null 을 허용하지 않는다.
      - 값이 반드시 입력되어야 한다.

- 3. UK : unique key
      - 입력되는 값이 고유해야 한다.
      - null 값은 허용됨..
      
- 4. CK : check
      - 입력되는 값을 체크한다.

- 5. FK : foreign key
      - 다른 테이블의 컬럼의 값을 참조
      - 참조되는 테이블의 컬럼은 primary key or unique 로 설정되어야 한다.
      - 자기 자신 테이블의 다른 컬럼을 참조할 수 있다.

create table tb_board(
    no number primary key,
    title varchar2(200),
    reg_date date,
    writer varchar2(30),
    view_cnt number(6),
    content varchar2(4000)
);

insert into tb_board(no, title) values(1, 'a');

select * from tb_board; 

-- ORA-00001: unique constraint (HR.SYS_C007800) violated
insert into tb_board(no, title) values(1, 'b');

drop table tb_board purge;

default : 값이 입력되지 않은 경우 자동으로 입력할 값을 설정
오라클의 현재 시간을 반환하는 함수 : sysdate

create table tb_board(
    no number primary key,
    title varchar2(200) not null,
    reg_date date default sysdate,
    writer varchar2(30) not null,
    view_cnt number(6) default 0,
    content varchar2(4000) not null
);

insert into tb_board(no, title, writer, content) values(1, 't1', 'w1', 'c1');

select * from tb_board;

insert into tb_board(no, title, writer) values(2, 't2', 'w2');

drop table tb_board purge;

-- 컬럼레벨 : not null은 컬럼레벨만 지원
-- 테이블레벨 : 복합컬럼으로 제약조건 설정시 무조건 사용해야 함
create table tb_board(
    no number,
    title varchar2(200) not null,
    reg_date date default sysdate,
    writer varchar2(30) not null,
    view_cnt number(6) default 0,
    content varchar2(4000) not null,
    primary key(no, title)
);

drop table tb_board purge;

-- 제약조건 이름을 직접 설정하자...
-- 제약조건 이름을 명시하지 않으면 시스템이 SYS_C숫자....
create table tb_board(
    no number constraint board_no_pk primary key,
    title varchar2(200) not null,
    reg_date date default sysdate,
    writer varchar2(30) not null,
    view_cnt number(6) default 0,
    content varchar2(4000) not null
);

insert into tb_board(no, title, writer, content) values(1, 't1', 'w1', 'c1');

insert into tb_board(no, title, writer, content) values(1, 't2', 'w2', 'c2');

drop table tb_board purge;

create table tb_board(
    no number ,
    title varchar2(200) not null,
    reg_date date default sysdate,
    writer varchar2(30) not null,
    view_cnt number(6) default 0,
    content varchar2(4000) not null,
    constraint board_no_pk primary key(no)
);

-- foreign key
create table tb_comment (
    comment_no number(6) constraint comment_no_pk primary key,
    no number(6) constraint comment_no_fk  references tb_board(no),
    content varchar2(500) not null
);

select * from tb_board;

insert into tb_board(no, writer, title, content) values(1, 'w1', 't1', 'c1');

insert into tb_comment(comment_no, no, content) values(1, 1, 'co1');

select * from tb_comment;
-- 자식이 참조하고 있는 경우는 삭제 안됨...
delete from tb_board
where no = 1;

-- 자식부터 삭제하고 처리함..
delete from tb_comment
where comment_no = 1;

select * from tb_comment;

delete from tb_board
where no = 1;

drop table tb_comment purge;

-- on delete cascade : 부모키의 값이 삭제될 경우 자식도 같이 삭제처리한다.
create table tb_comment (
    comment_no number(6) constraint comment_no_pk primary key,
    no number(6) constraint comment_no_fk  references tb_board(no) on delete cascade,
    content varchar2(500) not null
);

insert into tb_board(no, writer, title, content) values(1, 'w1', 't1', 'c1');

insert into tb_comment(comment_no, no, content) values(1, 1, 'co1');

delete from tb_board where no = 1;

select * from tb_board;

select * from tb_comment;