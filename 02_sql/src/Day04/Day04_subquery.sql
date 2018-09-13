---------------------------------------------
SUBQUERY
---------------------------------------------

--Chen의 부서번호를 화면에 출력
select last_name, department_id
  from employees
 where last_name ='Chen';

-- Chen 사원은 100번 부서에 근무합니다. 같은 부서에서 근무하는 사원의 정보를 출력하라
select *
  from employees
where department_id =100;

-- Single Row SUBQUERY: subquery의 결과가 하나일때 
-- Chen 사원과 같은 부서에 근무하는 사원의 정보를 출력하라
select *
  from employees
where department_id = (select department_id
                         from employees
                        where last_name ='Chen');

-- Multi Row SUBQUERY: subquery의 행이 여러개일때 
-- 연산자: IN, ANY, ALL
-- King 사원과 같은 부서에 근무하는 사원의 정보를 출력하라 (King 사원이 두명임)
select *
  from employees
-- where department_id = (select department_id
 where department_id IN (select department_id
                          from employees
                         where last_name = 'King');
            
--  30번 부서의 사원들이 받는 급여보다 급여를 많이 받는 사원의 정보를 출력하라.
/* 
    30번 부서의 사원 급여
    a   1000
    b   5000
    c   6000 <---
*/

select *
  from employees
 where salary > (select max(salary)
                   from employees
                  where department_id = 30);

-- 위와 동일
select *
  from employees
 where salary > all (select salary
                       from employees
                      where department_id = 30);        

--  30번 부서의 사원들이 받는 급여중 아무거나 비교해서 그중 하나의 급여보다 많이 받는 사원의 정보를 출력하라.
/* 
    30번 부서의 사원 급여
    a   1000
    b   5000
    c   6000 <---
*/

select *
  from employees
 where salary > (select min(salary)
                   from employees
                  where department_id = 30);

-- 위와 동일
select *
  from employees
 where salary > any (select salary
                       from employees
                      where department_id = 30);

-- MULTI COLUMN SUBQUERY                      
-- 각 부서에서 가장 작은 급여를 받는 사원 정보를 출력(부서번호, 사원명, 급여)
select department_id, last_name, salary
  from employees
 where (department_id, salary) IN (select department_id, min(salary) 
                        from employees 
                       group by department_id)
 order by department_id; 
 
-- subquery가 사용 가능한 위치...
-- INSERT, UPDATE, DELETE
insert into tb_board(
  no, title, writer, content
) values (
  (select nvl(max(no),0 from tb_board), 'a','b','c'
);

-- SELECT 절에 사용되는 서브쿼리
-- 사원의 이름과 부서번호, 부서명을 화면에 출력하시오.
select e.last_name, e.department_id, d.department_name
  from employees e
  inner join departments d
  on e.department_id = d.department_id;

select e.last_name, 
       e.department_id, 
       (select department_name 
           from departments d 
          where d.department_id = e.department_id) department_name
  from employees e;


-- SUBQUERY ON FROM: INLINE VIEW(인라인뷰) - subquery의 결과를 테이블처럼 사용한다. 
-- TOP-N SUBQUERY: 상위 몇개 가져오기..
-- 결과 집합을 일부분만 가져오기: rownum 을 활용한다. 

-----------------------
rownum의 이해...
-----------------------

-- 급여를 많이 받는 상위 5명의 정보를 출력
select rownum, last_name, salary
  from employees
 where rownum <= 5;

--rownum 1 조건을 주면 결과값이 출력 
select rownum, last_name, salary
  from employees
 where rownum = 1;

--하지만 2부터는 결과값이 나오지 않음
--rownum 은 1부터  assign되는데 출력하는 값이 없으면 그대로 rownum이 
select rownum, last_name, salary
  from employees
 where rownum = 2;

select rownum, last_name, salary
  from employees
 where rownum between 1 and 10; 

select last_name, salary
  from employees
 order by salary desc; 
 
-- FROM INLINE VIEW를 통해서 미리 정열한 임의 테이블 사용
select *
 from (select last_name, salary
  from employees
 order by salary desc)
 where rownum <=5;

-- 부분범위 query방식: FROM INLINE VIEW에 FROM INLINE VIEW가 있는 테이블로 부분범위만 
-- rownum을 활용한 paging 을 구현할때 사용
select * 
 from (select rownum rnum, a.*
         from (select *
               from employees
               order by salary desc) a)
 where rnum between 5 and 7;
 
-- 테이블 생성시 서브쿼리 활용하기(참고)
create table employees_copy
as 
SUBQUERY;

create table employees_copy
as
select * from employees;

drop table employees_copy purge;

-- 테이블 생성시 구조만 복사...
create table employees_copy
as
select * from employees
 where 1 !=1;

insert into employees_copy
SUBQUERY;

insert into employees_copy
select * from employees;
