/*
HR 계정 잠금 해제하기

1. 콜솔창 열기
	cmd로 창 열고 sql 아이디/패스워드 입력(관리자 계정)

2. SQL Command Line 열기
	 메뉴에서 오라클 관련 선택 > Run SQL Command Line 선택
	 관리지 유저로 접속
	 conn 아이디/패스워드
	 conn system/manager
	 
	 conn /as sysdb; (관리자 계정을 모를때 사용 )

3. 계정의 잠금을 해제하고 접속하기
	alter user hr identified by hr account unlock;
	alter user (user ID) identified by (password) account unlock; (패스워드 잠금 해제시만)
	alter user (user ID) identified by (password); (패스워드 변경)
	
	create user (계정 생성) ;
	drop user (계정 삭제) ;
	
	conn hr/hr
	
4. hr 사용자의 기본 제공되는 테이블 확인하기
	select * from tab; -- Oracle  에서 제공되는 명령어... 타DB 안됨.. 

	select * from employees;
	
	select *
		from employees
	where last_name= 'King';
	
	Select * from employees;
    
	select *
		from employees
	where last_name= 'King';

	select *
     from jobs;

DBMS - 데이터를 편리하게 사용할 수 있도록 관리하는 시스템
종류 - Oracle, MsSQL, MySQL, MariaDB, DB2,....

Database Server - Oracle11g
Database Client - Sqlplus, Eclipse, SqlDeveloper, SQLGate, *Toad*

Database 접속을 위한 사용자
관리자(DBA): system, sys
인사관리 유저(Practice): scott, hr - account locked

Database는 데이터를 관리하기 위해서 사용
Database language → SQL(Structured Query Language)

SQL Commands( 공용 언어)
기존 파일시스템에서 편리한 데이터 관리를 위해 데이터베이스 사용(파일을 이용해서 저장됨, 데이터파일)
DDL(Data Definition Language): DB에서 사용하는 객체(Table, View, Function, Procedure, Trigger, User…)를 생성하거나 변경, 삭제하는 명령어 
생성 - create, 삭제 - drop, 변경 - alter, rename, truncate(테이블 데이터 복구 불가 전체 삭제) 
Table - 데이터를 저장하기 위한 객체
DML(Data Manipulation Language):  테이블에 있는 데이터 조작 언어
입력 - insert, 삭제 - delete, 변경/수정 - update
DQL(Data Query Language): 데이터를 조회하기 위한 명령어
select
* CRUD: create, read, update, delete

TCL(Transaction Control Language): 
Commit(데이터베이스에 완전하게 적용), rollback(데이터를 되돌린다), savepoint(중간에 저장점을 생성)


===== hr 계정의 데이터를 이용해서 select 연습하기 =====

- 현재 접속한 사용자의 테이블 목록을 확인하기
select * from tab; (tab=table) crtl+enter(return)

- 특정 테이블 데이터를 확인하기 
select * from tableName;

Select * from employees;

*/

/* 
기본 SQL 특징
SQL 문장은 한줄로 입력하거나 여러줄로 보기 좋게 나누어 입력한다. 
(절 단위로 여러줄로 나누어서 입력 추천…)
절: select, from, group by, where, having, order by
	
SELECT *
From	EMPLOYEES;

SELECT *
  From	EMPLOYEES;

SQL 문장은 대소문자를 구분하지 않는다. (Case Insensitive)
data 값은 대소문자를 구분한다. 
Select 문장은 최소한 from, select 절이 있어야 실행이 가능하다. 
조회된 결과의 컬럼 헤딩은 대문자로 구분한다. 
*/

== from: 데이터를 가지고 올 집합체의 정보를 표시
== select: 테이블의 컬럼중에서 조회할 컬럼의 이름을 명시

From 테이블명



-- jobs 테이블에서 job_title 컬럼의 데이터만 화면에 표시하시오..
-- 특정 컬럼만 조회하기
select column_name1, Column_name2....
 from table_name;
 
select job_title
 from jobs;

/* 
 Java       SQL
 class      table
 field      column
 
 class Jobs {
    private String jobId;
    private String jobTitle;
    private int minSalary;
    private int maxSalary;
*/

-- To find column name, types, and other info in tables	
desc jobs;

desc departments;

/*
class Departments {
    private int departmentId;
    private String departmentName;
    private int managerId;
    private int locationId;
*/

-- 컬럼의 타입이 숫자 형태이면 산술연산이 가능하다. (+,-,*,/)
-- 사원 테이블의 정보를 출력(사원의 이름(last_name), 급여)

desc employees;

select last_name, salary
 from employees;
 
-- 사원 테이블의 정보를 출력(사원의 이름(last_name), 급여)
-- 사원의 연봉을 출력하라..(연본의 계산: 급여*15), 연산이 column이름이 되는데 이러면 프로그램 코딩할때 이 column에 접근하기 어려워서
-- column에 별칭(alias) 생성
 
select last_name, salary, salary*15
 from employees;
 
-- column alias
-- select 컬럼명 as 별칭
-- select column_name  alias

-- 컬럼의 이름 출력시 계산된 연봉 컬럼의 이름을 "연봉"으로 표시하라...
select last_name, salary, salary*15 as 연봉
 from employees;
 
-- 출력되는 컬럼의 이름을 "사원명", "급여", "연봉" 으로 출력
select last_name as 사원명, salary as 급여, salary*15 as 연봉
 from employees;
 
-- 합성연산자: 컬럼의 데이터를 연결한다(컬럼+컬럼, 컬럼+문자, 컬럼+숫자)
-- ||, 자바에서의 "+"를 생각
select last_name || salary
 from employees;
 
-- 출력되는 컬럼의 이름을 "사원 정보"로 변경하자
-- SQL에서는 문자열을 single quotation을 쓰고 한묶음의 띄어쓰기 단어는 double quotation으로 묶어준다 
select last_name || ' ' || salary as "사원 정보" 
 from employees;

desc employees;

-- 아래의 결과 형태로 출력되도록 SQL문을 작성하시오
-- 단 컬럼의 이름은 '사원정보'로 변경한다.
-- 100번 사원의 이름은 King이고 급여는 24000원입니다. 

select employee_id || '번 사원의 이름은 ' || last_name || '이고 급여는 ' 
    || salary || '원 입니다.' as 사원정보
 from employees;
 
---------------------------------------------------------------
 
WHERE COMMAND: 조건에 대한 처리를 진행하여 원하는 결과 데이터만 가져오게 한다. 
전체 데이터에서 범위를 줄여 조건에 맞는 데이터만 조회
---------------------------------------------------------------
select column,... (3번 순서)
  from table_name (1번 순서, 집합체 접근)
where condition.... (2번 순서, 가져올 데이터 필터를 통한 데이터량 한정)

-- where 연산자를 활용하기, 논리 연산자, 비교 연산자, SQL 연산자 
-- 사원중에 급여가 10000 이상인 사원의 정보를 출력하시오.
-- select: 사원의 정보
-- from: 사원테이블
-- where: 급여가 10000 이상 (salary >= 10000)
select *
  from employees
 where salary >=10000;

-- 사원 중에서 급여가 10000 이상하면서 15000이하인 사원의 정보를 출력하시오.
select *
  from employees
 where salary >= 10000 
   and salary <= 15000;

-- 사원 중에서 급여가 10000인 사원의 정보를 출력하시오.
select *
  from employees
 where salary=10000;

-- 사원중에서 이름이 'King'인 사원의 정보를 출력하시오.
select *
  from employees
 where last_name='King';
 
-- 사원중에서 100번 부서에서 근무하지 않은 사원의 정보를 출력하시오.
select *
  from employees
-- where department_id <> 100;
 where department_id != 100;
 
-- 사원의 부서가 100 번이거나 또는 110번에 속하는 사원의 정보를 출력하시오.
select *
  from employees
 where department_id = 100
    or department_id = 110;

-- 사원의 부서가 110번 또는 100번에 소속된 사원 중에서 급여가 10000 이상인 사원들의 정보를 출력하라
-- 비교연산자의 우선순위는 and>or 임으로 or부터 비교연산 부터 수행하려면 () 묶어준다. 
select *
  from employees
 where (department_id = 110
     or department_id = 100)
    and salary >= 10000;

/*
-- SQL 연산자: 
    1. column between A and B: A와 B 사이의 값을 선택(A,B 포함), A가 B보다 값이 작아야한다. 
    2. column IN (value,...): 컬럼의 값이 괄호안의 값과 일치하는지 체크, 값이 같으면 true
    3. column like '포멧 문자열': 컬럼의 값이 특정한 포멧 형태에 포함되는지 체크, (true, false) 
    like 연산자와 같이 사용되는 패턴 문자: _(한문자), %(0개 이상의 문자)
    4. column is null: value of the column 이 null인 상태일때 true
    null: 컬럼에 데이터가 입력되지 않은 상태, 1)값이 미정이고 2) null값과 연산한 결과는 무조건 null  3) null 값과 비교연산 결과는 무조건 false
*/

-- 1. between
select *
  from employees
 where salary between 10000 and 15000;
 
-- 2. IN 
-- 사원의 부서가 90, 100, 110, 120 에 속해 있는 사원의 정보를 출력
select *
  from employees
 where department_id in(90,100,110,120)
   and salary>=10000;
   
-- 3. like
-- like 연산자와 같이 사용되는 패턴 문자: _(한문자), %(0개 이상의 문자)
-- 사원의 이름이 'L'자로 시작되는 사원의 정보를 출력
select *
  from employees
 where last_name like 'L%';

-- 사원의 이메일이 5자리인 사원의 정보 출력
select *
  from employees
 where email like '_____';
 
-- 사원의 이메일의 첫글자가 'D'이고 마지막 글자가 'T'인 사원의 정보를 출력
select *
  from employees
 where email like 'D%T';

--웹사이트의 배송비가 들어가 있는 데이터 찾기
-- column like '%배송비%';

--이름이 'King'인 사원의 정보
select *
  from employees
 where last_name like '%King%';
 
-- 4. is null
-- 사원 중에서 커미션을 받지 않는 사원의 정보를 출력
select last_name, salary, commission_pct
  from employees
where commission_pct is null;

-- 사원의 연봉: (salary*15)*commission_pct + salary*15
select last_name, salary, commission_pct, (salary*15)*commission_pct+salary*15 as year_sal
 from employees;
