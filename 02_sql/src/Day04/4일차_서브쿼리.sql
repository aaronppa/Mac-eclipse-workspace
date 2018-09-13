-------------------------
서브쿼리 (SubQuery) - 
-------------------------

-- Chen 의 부서번호를 화면에 출력
select department_id
  from employees
where last_name = 'Chen';  

-- Chen 사원은 100번 부서에 근무합니다. 같은 부서에 근무하는 사원의 정보를 출력하라
select *
  from employees
where department_id = 100;

-- Single Row SubQuery : 결과행이 하나인 것
-- Chen 사원과 같은 부서에 근무하는 사원의 정보를 출력하라
select *
  from employees
where department_id = (select department_id
                                      from employees
                                    where last_name = 'Chen');

-- King 사원과 같은 부서에 근무하는 사원의 정보를 출력하라
select *
  from employees
where department_id = (select department_id
                                      from employees
                                    where last_name = 'King');
                                    
select *
  from employees
where department_id = (80, 90);
where department_id in (80, 90);                                       

-- Multi Row SubQuery : 결과 행이 여러개 인것
-- 연산자 : IN, ANY, ALL
select *
  from employees
where department_id in (select department_id
                                      from employees
                                    where last_name = 'King');

-- 30번 부서의 사원들이 받는 급여보다 급여를 많이 받는 사원의 정보를 출력하라.
/*
     30번 부서의 사원 급여
     a     1000
     b     5000
     c     6000
*/
select *
  from employees
where salary >ALL (30번부서에 근무하는 사원들의 급여);  

select *
  from employees
where salary >ALL (select salary
                               from employees
                             where department_id = 30);

select *
  from employees
where salary > (select max(salary)
                          from employees
                        where department_id = 30);                             

/*
     30번 부서의 사원 급여
     a     1000
     b     5000
     c     6000
*/
select *
  from employees
where salary >ANY (select salary
                               from employees
                             where department_id = 30);
                             
select *
  from employees
where salary > (select min(salary)
                         from employees
                       where department_id = 30);                             

-- 각 부서에서 가장 작은 급여를 받는 사원 정보를 출력(부서번호, 사원명, 급여)
select department_id, last_name, salary
  from employees
where salary in (부서별 최소급여);

-- Multi Column SubQuery
select department_id, last_name, salary
  from employees
where (department_id, salary) in (select department_id, min(salary) 
                                                    from employees
                                                   group by department_id);
                                                   
-- 서브쿼리가 사용 가능한 위치...
-- INSERT, UPDATE, DELETE
insert into tb_board (
    no, title, writer, content
) values (
    (select nvl(max(no), 0) + 1 from tb_board), 'a', 'b', 'c'
);                                                      

-- SELECT 절에 사용되는 서브쿼리
-- 사원의 이름과 부서번호, 부서명을 화면에 출력하시오
select e.last_name, e.department_id, d.department_name
  from employees e
  inner join departments d
     on e.department_id = d.department_id;
     
select e.last_name, e.department_id, 부서이름
  from employees e;

select e.last_name, 
         e.department_id, 
         (select department_name
            from departments
           where department_id = e.department_id) as department_name
  from employees e;
       
-- FROM 절의 서브쿼리
-- 인라인뷰(INLINE VIEW) : 서브쿼리의 결과를 테이블처럼 사용한다.  
-- TOP-N SubQuery : 상위 몇개 가져오기...
-- 결과 집합을 일부분만 가져오기 : rownum 을 활용한다.

-----------------
rownum 의 이해...
-----------------

-- 급여를 많이 받는 상위 5명의 정보를 출력
select rownum, last_name, salary
  from employees;
  
select rownum, last_name, salary
  from employees
 where rownum < 11;   

select rownum, last_name, salary
  from employees
 where rownum = 1;   

-- 결과 없음... ????
select rownum, last_name, salary
  from employees
 where rownum = 2;

select rownum, last_name, salary
  from employees
 where rownum between 11 and 20;
 
select last_name, salary         3번       4번
  from employees                  1번       1번
 where rownum < 6               2번       3번
order by salary desc;             4번       2번
 

select last_name, salary
 from employees
order by salary desc;

select *
  from (select last_name, salary
             from employees
            order by salary desc)
where rownum < 6; 

select rownum rnum, a.*
  from (select *
             from employees
            order by salary desc) a
            
where rownum between 1 and 5; 

select rownum rnum, a.*
  from (select *
             from employees
            order by salary desc) a;
            
            
select *
from (select rownum rnum, a.*
          from (select *
                     from employees
                    order by salary desc) a)
where rnum between 1 and 10;

-- 테이블 생성시 서브쿼리 활용하기(참고)
create table employees_copy
as
서브쿼리;

create table employees_copy
as
select * from employees;

select * from employees_copy;

drop table employees_copy purge;

-- 테이블 생성시 구조만 복사..
create table employees_copy
as
select * from employees
where 1 != 1;

select * from employees_copy;

insert into employees_copy
서브쿼리;

insert into employees_copy
select * from employees;

select * from employees_copy;