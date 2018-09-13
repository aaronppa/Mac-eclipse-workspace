//---------------------------------------------------
group by
- 데이터들을 소그룹으로 묶어준다. 
- 그룹함수와 같이 사용 한다. 
* 그룹함수: 여러개의 데이터를 받아서 하나의 결과를 반환 
          그룹함사에서 null 값은 모두 제외(배제), 단 count(*)은 널까지 포함
  count(*), count(last_name): 갯수 구하기
  sum(salary): 합구하기
  max(salary), min(salary,: 최대, 최소값 구하기
  avg(salary): 평균값 구하기
  
-- 사원들의 전체 수를 표시하고 최대급여가 얼마인지 출력
select count(*), count(commission_pct),max(salary)
  from employees;

-- 100번 부서의 사원 수와 부서에서 가장 높은 급여와 가장 낮은 급여를 출력
select count(*), max(salary), min(salary)
  from employees
 where department_id = 100;

-- 각 부서의 사원 수와 부서에서 가장 높은 급여와 가장 낮은 급여를 출력
select department_id, count(*), max(salary), min(salary)
  from employees
 group by department_id
 order by department_id;
 
------- 테이블 생성 --------
create table tb_group(
    id varchar2(3),
    sal number,
    job_id varchar(2),
    dept_id number
);

desc tb_group;

select * from tb_group;

----- table에 데이터 입력 -----
insert into tb_group values('a',1000,'SA',10);
insert into tb_group values('b',2000,'CM',30);
insert into tb_group values('c',3000,'CM',20);
insert into tb_group values('d',4000,'LA',10);
insert into tb_group values('e',3000,'SA',30);
insert into tb_group values('f',2000,'SA',10);

select * from tb_group;

select job_id, max(sal), count(*)
  from tb_group
 group by job_id, dept_id;
 
-- 각 부서별 최대급여를 출력합니다. 단, 최대 급여가 높은 부서부터 출력
select department_id, max(salary) as max_sal
  from employees
 group by department_id
 order by max_sal desc;

-- command order
-- from -> where -> group by -> select -> order by
-- order by는 select에서 추가한 컬럼의 alias를 사용할 수 있다. 

-- 각 부서별 최대급여를 출력합니다. 단, 최대 급여가 높은 부서부터 출력
-- 최대급여가 10000 이상인 부서를 대상으로 합니다.
/*
select department_id, max(salary) as max_sal
  from employees
 where max(salary) >= 10000;
 group by department_id
 order by max_sal desc;
*/ -- group by에서 where를 사용하면 오류남
-- having: group by의 처리 결과의 제약을 처리
select department_id, max(salary) as max_sal
  from employees
 group by department_id
 having max(salary) >= 10000
 order by max_sal desc;
 
-- 부서별 평균 급여를 출력합니다. 단, 100번 부서보다 큰 부서는 제외
-- 부서의 평균급여가 5000 이상인 부서만 출력
-- 부서 번호 순으로 출력
select department_id dept_id, avg(salary) avg_sal
  from employees
 where department_id <= 100
 group by department_id
 having avg(salary) >= 5000
 order by dept_id;
 
//--------------------------------------------------------------------
DDL Command 
create: table creation
drop: table deletion
truncate: 테이블의 데이터를 복구 불가능하게 전체 삭제
rename: 테이블의 이름 변경
alter: 테이블의 컬럼 또는 제약조건 변경
desc: 테이블 구조 확인

DML Command
insert
update
delete

-- create command
create table table_name
-- 오라클은 내부적으로 테이블명과 컬럼명은 기본으로 대문자로 저장됨

create table table_name (
 column_name type(size),
 column_name2 type(size),
 .....
 column_name2 type(size)
);

-- 데이터 타입
-- 문자: varchar2(가변길이)- 크기설정해야함, varchar, char(고정길이) - 크기설정 안할시 1자
-- 숫자: number
-- 날짜: date

-- 슈퍼키: 각 행을 유일하게 식별할 수 있는 컬럼 또는 컬럼의 집합 (주민번호, 주민번호+이름, 주민번호+핸드폰번호,...
-- 후보키(identifier): 각 행을 식별할 수 있는 최소의 컬럼의 집합 (주민번호)
-- 기본키 (primary key): 여러 개의 후보키 중에서 하나의 키를 선정해서 대표로 삼는 키 (회원번호)
-- 대리키: 인위적으로 만드는 값(시퀀스), (회원번호, 게시물번호)

-- 테이블명 이름 만들기: t_..., tb_...., tc_...., th_.....
-- 게시물에 대한 정보를 표현하는 테이블 만들기
create table tb_board(
    no number,
    title varchar2(200),
    reg_date date,
    writer varchar2(30),
    view_cnt number(6),
    content varchar2(4000)
);


// ---------------------------------------------------------------
테이블의 제약 조건을 이해하자
제약조건 설정 방식: 테이블레벨, 컬럼레벨
제약 조건 종류
- 1. PK: primary key
    - 테이블에 단 하나만 설정(여러개 설정 불가능)
    - 여러개의 컬럼을 묶어서 만들 수 있다. (복합 컬럼 - 테이블 레벨만 가능함)
    - not null + unique 조합
    - 테이블에 입력되는 행의 데이터를 구분하는 역할을 수행... 
    
- 2. NN: not null
     - null을 허용하지 않는다 
- 3. UK: unique 
    - 입력되는 값이 고유해야 한다.
    - null 값 허용
    
- 4. CK: check
    - 입력되는 값을 체크

- 5. FK: foreign key
    - 다른 테이블의 컬럼의 값을 참조
    - 참조되는 테이블의 컬럼은 primary key or unique

-- default: 값이 입력되지 않은 경우 자동으로 입력할 값을 설정
-- 오라클의 현재 시간을 반환하는 함수: sysdate
-- 컬럼레벨, 테이블레벨로 제약조건 설정가능

-- 컬럼레벨의 제약조건
-- not null은 컬럼레벨만 지원
create table tb_board(
    no number, 
    title varchar2(200) not null,
    reg_date date default sysdate,
    writer varchar2(30) not null,
    view_cnt number(6) default 0,
    content varchar2(4000) not null, 
    primary key (no)
);

insert into tb_board(no, title) values (1,'a');

insert into tb_board(no, title, writer, content) values(1,'t1','w1','c1');

-- 생성된 테이블 삭제
drop table_name;

-- 휴지통 비우기
purge recycle table_name

-- 휴지통에 넣지 않고 완전히 삭제
drop table tb_board purge;

-- 테이블레벨로 제약 조건 설정
-- 복합컬럼으로 제약조건 설정시 무조건 사용해야함.
-- not null은 컬럼레벨만 지원
create table tb_board(
    no number, 
    title varchar2(200) not null,
    reg_date date default sysdate,
    writer varchar2(30) not null,
    view_cnt number(6) default 0,
    content varchar2(4000) not null, 
    primary key (no, title)
);

-- 제약조건 이름을 직접 설정하자
-- 제약조건 이름을 명시하지 않으면 시스템이 SYS_C숫자...
create table tb_board(
    no number constraint board_no_pk primary key, 
    title varchar2(200) not null,
    reg_date date default sysdate,
    writer varchar2(30) not null,
    view_cnt number(6) default 0,
    content varchar2(4000) not null 
);

insert into tb_board(no, title, writer, content) values(1,'t1','w1','c1');

insert into tb_board(no, title, writer, content) values(1,'t2','w2','c2');

--table레벨에서 제약조건 이름설정하기 
create table tb_board(
    no number,
    title varchar2(200) not null,
    reg_date date default sysdate,
    writer varchar2(30) not null,
    view_cnt number(6) default 0,
    content varchar2(4000) not null,
    constraint board_no_pk primary key(no)
);

desc tb_board; 

-- foreign key
create table tb_comment(
    comment_no number(6) constraint comment_no_pk primary key,
    no number(6) constraint comment_no_fk references tb_board(no),
    content varchar2(500) not null
);

desc tb_comment;

insert into tb_board(no, title, writer, content) values(1,'t1','w1','c1');

insert into tb_comment(comment_no, no, content) values(1,1,'co1');

-- foreign key가 refered 된 데이터는 삭제하려고 할때 오류남
delete from tb_board
where no =1;

-- 자식 data 먼저 삭제후 가능
delete from tb_comment
where comment_no =1;

drop table tb_comment purge;

-- on delete cascade : 부모키의 값이 삭제될 경우 자식도 같이 삭제처리한다.
-- foreign key가 물려있는 데이터라도, on delete cascade를 자식 테이블의 해당 column에 추가해주면,
-- 자식 table이 referred 되어있는 부모 테이블의 데이터가 삭제가능하고 자식 데이터도 삭제됨
create table tb_comment(
    comment_no number(6) constraint comment_no_pk primary key,
    no number(6) constraint comment_no_fk references tb_board(no) on delete cascade,
    content varchar2(500) not null
);

insert into tb_comment(comment_no, no, content) values(1,1,'co1');

delete from tb_board
where no =1;

select * from tb_board;

select * from tb_comment;

drop table tb_board purge;
drop table tb_comment purge;

-- 테이블의 이름을 변경하자: rename
rename 원본이름 to 수정이름;

rename tb_board to tb_board2;

rename tb_board2 to tb_board;

-- 테이블의 데이터를 전체 삭제(북구 불가)
truncate table table_name;

insert into tb_board(no, title, writer, content) values(1,'t1','w1','c1');

insert into tb_board(no, title, writer, content) values(2,'t2','w2','c2');

truncate table tb_board;

select *
from tb_board;

-----------------------------------------------------------------------------------
--alter: 테이블의 column 변경하기
--컬럼 추가, 삭제
--컬럼 변경(Type, Size, default, not null)

--컬럼 추가
alter table table_name
add

--컬럼 삭제
alter table table_name
drop

--컬럼 수정
alter table table_name
modify

alter talbe table_name
rename column

create table tb_alter (
    name varchar2(10),
    age varchar2(3)
);

alter table tb_alter
add (email varchar2(30));

alter table tb_alter
drop (email);

select * 
from tb_alter;

-----------------------------------------------------------------------------
--DML 이해하기
데이터 추가: insert
insert into table_name[(column,...)] /* []는 생략이 가능하다는 뜻임 */
values(value1,...);    

--전체 컬럼에 값을 입력한다... X
insert into tb_board value(3, '제목', '내용', sysdate, '글쓴이',0);

--정상적인 방법
insert into tb_board (no, title, reg_date, writer, view_cnt, content) values(1,'제목', sysdate,'글쓴이', 2, '내용');

--데이터를 수정하자: update
update table_name
   set column = 변경할 값,
       column =  변경할 값
 [where column = 값]
 
--1번 게시물의 제목을 "변경제목" 내용을 "변경된 내용"으로 수정하자
update tb_board
    set title = '변경 제목',
        content = '변경 내용'
  where no = 1;

-- 데이터 삭제하기: delete
delete tb_board where no =1;

delete from tb_board where no=1;

select * 
  from tb_board;

drop table tb_board purge;
//-------------------------------------------------
-- sequence: 오라클에서 제공하는 자동 번호 발번하는 객체
    - 고유번호 생성기(ex. 은행이나 영화관의 번호표 발권기)
    
select * 
  from tb_board;

insert into tb_board(no, title, writer, content) values(??, 'a','b','c');

-- 글번호 컬럼의 최대값을 찾아서 +1을 한 값을 출력
-- 값이 없는 경우 null 이기 때문에 그룹함수로 +1해봤자 null를 return
insert into tb_board(no, title, writer, content) values(max(no)+1, 'a','b','c'); 

-- nvl(null_value, replace_value)
select nvl(max(no), 0)+1
  from tb_board;

-- 다중 사용자가 접근시 중복될 가능성이 커서 사용하면 안됌
insert into tb_board(no, title, writer, content) 
values((select nvl(max(no),0)+1 from tb_board), 'a','b','c'); 

select * from tb_board;

-- sequence creation
create sequence sequence_name;

create sequence s_board_no;

--sequence delete
drop sequence sequence_name;

drop sequence s_board_no;

create sequence s_board_no;

--numbering assignment: sequence_name.nextval
-- dual: 더미 테이블...
select s_board_no.nextval from dual;

insert into tb_board(no, title, writer, content) 
values(s_board_no.nextval, 'a','b','c'); 

select *
from tb_board;

delete
  from tb_board
 where no =9;
 