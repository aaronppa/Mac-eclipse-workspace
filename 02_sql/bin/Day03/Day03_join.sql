-- JOIN(조인)
    -- : 논리적으로 2개 이상의 테이블을 연결해서 원하는 정보를 가져온다. 
    -- : from employees, departments, ...
    -- : 증거조건 - 테이블과 테이블을 연결하는 조건(최소 테이블 개수 -1)
    
-- 사원의 번호, 사원명, 부서번호, 부서명을 출력하라
select employee_id, last_name, department_id
  from employees;
  
select department_id, department_name
  from departments;

select employee_id, last_name, department_id, department_name
  from employees, departments;
/*
    카테시안 프로덕트(Cartesian Product)
    여러개의 테이블을 조인할때 증거조건을 명시하지 않은 경우 M * N 결과 반환
*/
--Cartesian Product
select employee_id, last_name, employees.department_id, department_name
  from employees, departments;

--JOIN
--양쪽 테이블에 존재하는 컬럼을 출력하려 할때는 테이블명.컬럼명으로 알려줘야 한다. 
-- 증거조건의 연산자가 "="를 사용하는 조인: Equi 조인방식
select employee_id, last_name, employees.department_id, department_name
  from employees, departments
 where employees.department_id = departments.department_id;
 
-- 권장하는 방식: 컬럼 앞에 테이블 표시해라..
select employees.employee_id, 
       employees.last_name, 
       employees.department_id, 
       department.department_name
  from employees, departments
 where employees.department_id = departments.department_id;

-- 쿼리의 복잡함을 해결하자..
-- 테이블 별칭 사용(alias): from 테이블명 alias (as 사용불가) 
select e.employee_id, 
       e.last_name, 
       e.department_id, 
       d.department_name
  from employees e, departments d
 where e.department_id = d.department_id;
 
-- 각 사원의 이름과 직무아이디, 직무에서 받을 수 있는 최대 급여
select e.first_name,
       e.job_id,
       j.max_salary
  from employees e, jobs j
 where e.job_id = j.job_id;
 
select *
  from countries;
  
-- Canada에 근무하는 사원의 이름, 부서명, 도시명을 출력하시오. 
select e.first_name,
       d.department_name,
       l.city
  from employees e, departments d, locations l, countries c
 where c.country_name = 'Canada'
   and e.department_id = d.department_id
   and d.location_id = l.location_id
   and l.country_id = c.country_id;
   

create table tb_salgrade (
  grade char(1),
  min_sal number(6),
  max_sal number(6)
);
insert into tb_salgrade values('1', 20000, 100000);
insert into tb_salgrade values('2', 10000, 19999);
insert into tb_salgrade values('3', 6000, 9999);
insert into tb_salgrade values('4', 3000, 5999);
insert into tb_salgrade values('5', 1, 2999);

select *
  from tb_salgrade;
  
-- 사원명, 급여, 급여등급 출력
-- 같다 (=) 의 Equi 연산자 이외 모든 연산자는 NonEqui 조인이라고함.
select e.last_name,
       e.salary,
       sg.grade
  from employees e, tb_salgrade sg
 where e.salary between sg.min_sal and sg.max_sal
 order by grade asc;

-- Self JOIN: 물리적으로 하나의 테이블을 논리적으로 두개이상으로 나누어 사용하는 것..
-- 각 사원의 이름과 관리자의 이름을 화면에 출력
select e.employee_id,
       e.last_name 사원명, 
       m.last_name 관리자명
  from employees e, employees m
 where e.manager_id = m.employee_id
 order by e.employee_id;

-- outer join: 조인조건을 만족하지 않더라도 결과에 포함
-- 연산자 (+)
-- 모자른쪽에 연산자를 표시함...
-- 양쪽이 모자른 경우 사용이 불가능함...
select e.employee_id,
       e.last_name 사원명, 
       nvl(m.last_name,'관리자 없음') 관리자명
  from employees e, employees m
 where e.manager_id = m.employee_id(+)
 order by e.employee_id;

--효율적으로 이름이 K로시작하는 사원의 정보
select e.employee_id,
       e.last_name 사원명, 
       nvl(m.last_name,'관리자 없음') 관리자명
  from employees e, employees m
 where e.manager_id = m.employee_id(+)
   and substr(e.last_name,1,1) = 'K'
 order by e.employee_id;

--비효율적으로 이름이 K로시작하는 사원의 정보
select e.employee_id,
       e.last_name 사원명, 
       nvl(m.last_name,'관리자 없음') 관리자명
  from employees e, employees m
 where e.manager_id = m.employee_id(+)
   and e.last_name like 'K%'
 order by e.employee_id;

--Ansi Join 방식으로 변경하자...
--****************위의 것 복붙************해서 수정

-- Cross join
select e.employee_id, e.last_name, e.department_id, d.department_name
  from employees e
cross join departments d;

--inner JOIN ~ on: equi, nonequi, self join 포함
-- 테이블 inner join 테이블 on 증거조건, [and 증거조건1]
select e.employee_id, 
       e.last_name, 
       e.department_id, 
       d.department_name
  from employees e 
  inner join departments d 
    on e.department_id = d.department_id;
 
-- 각 사원의 이름과 직무아이디, 직무에서 받을 수 있는 최대 급여
select e.first_name,
       e.job_id,
       j.max_salary
  from employees e inner join jobs j
    on e.job_id = j.job_id;
 
select *
  from countries;
  
-- Canada에 근무하는 사원의 이름, 부서명, 도시명을 출력하시오. 
select e.first_name,
       d.department_name,
       l.city
  from 
    employees e inner join departments d
    on e.department_id = d.department_id
        inner join locations l
    on d.location_id = l.location_id
        inner join countries c
    on l.country_id = c.country_id
   where c.country_name = 'Canada';

create table tb_salgrade (
  grade char(1),
  min_sal number(6),
  max_sal number(6)
);
insert into tb_salgrade values('1', 20000, 100000);
insert into tb_salgrade values('2', 10000, 19999);
insert into tb_salgrade values('3', 6000, 9999);
insert into tb_salgrade values('4', 3000, 5999);
insert into tb_salgrade values('5', 1, 2999);

select *
  from tb_salgrade;
  
-- 사원명, 급여, 급여등급 출력
-- 같다 (=) 의 Equi 연산자 이외 모든 연산자는 NonEqui 조인이라고함.
select e.last_name,
       e.salary,
       sg.grade
  from employees e inner join tb_salgrade sg
    on e.salary between sg.min_sal and sg.max_sal
 order by grade asc;

-- Self JOIN: 물리적으로 하나의 테이블을 논리적으로 두개이상으로 나누어 사용하는 것..
-- 각 사원의 이름과 관리자의 이름을 화면에 출력
select e.employee_id,
       e.last_name 사원명, 
       m.last_name 관리자명
  from employees e inner join employees m
    on e.manager_id = m.employee_id
 order by e.employee_id;


-- outer join: 조인조건을 만족하지 않더라도 결과에 포함
-- (full | left | right) outer join
select e.employee_id,
       e.last_name 사원명, 
       nvl(m.last_name,'관리자 없음') 관리자명
  from employees e left outer join employees m
    on e.manager_id = m.employee_id
 order by e.employee_id;

--효율적으로 이름이 K로시작하는 사원의 정보
select e.employee_id,
       e.last_name 사원명, 
       nvl(m.last_name,'관리자 없음') 관리자명
  from employees e left outer join employees m
    on e.manager_id = m.employee_id
   where substr(e.last_name,1,1) = 'K'
 order by e.employee_id;

--비효율적으로 이름이 K로시작하는 사원의 정보
select e.employee_id,
       e.last_name 사원명, 
       nvl(m.last_name,'관리자 없음') 관리자명
  from employees e left outer join employees m
    on e.manager_id = m.employee_id
   where e.last_name like 'K%'
 order by e.employee_id;
 
-- 