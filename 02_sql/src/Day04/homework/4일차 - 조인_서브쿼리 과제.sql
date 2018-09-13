--1. 담당업무별 최대 급여와 최소 급여를 출력하시오. 단, 담당업무는 영업 부서로 제한. (영업부서: SA_REP, SA_MAN)
select job_id, max(salary), min(salary)
  from employees
 where job_id like 'SA%'
 group by job_id; 
 
--2. 담당업무별로 최대 급여가 얼마인지 출력하시오. (급여가 높은 순 출력)
select job_id, max(salary) max_sal
  from employees
 group by job_id
 order by max_sal desc;
 
--3. 사원의 월급이 Programmer 업무에 해당하는 연봉의 상한과 하한에 포함되는 사원의 정보를 출력하시오. - 연봉의 상한과 하한은 JOBS 테이블 참고
select employee_id, first_name, salary
  from employees e, jobs j
 where j.job_title = 'Programmer'
   and salary between j.min_salary and j.max_salary;

select employee_id, first_name, salary
  from employees e
  inner join jobs j 
   on e.job_id = j.job_id
   and salary between (select min_salary 
                         from jobs
                        where job_title = 'Programmer') 
                          and 
                             (select max_salary 
                                from jobs
                               where job_title = 'Programmer');
                      
--4. job_title이 'Sales Representative' 인 직원 중에서 연봉이 9,000이상
-- 10000이하인 직원들의 이름, 성, 연봉을 출력하시오. 
select first_name, 
       last_name, 
       salary
  from employees e, jobs j
 where j.job_title =  'Sales Representative'
   and j.job_id = e.job_id
   and salary between 9000 and 10000;

select first_name, last_name, salary
  from employees e
  inner join jobs j
   on e.job_id = j.job_id
  and j.job_title = 'Sales Representative'
  and e.salary between 9000 and 10000;

--5. 각 사원에 대해서 사번, 이름, 업무명, 부서명을 조회하시오. 단 도시명이 'Seattle'인 지역의 부서에 근무하는 직원만 출력하시오. 
select employee_id 사번, 
       first_name 이름, 
       j.job_title 업무명, 
       d.department_name 부서명 
  from employees e
  inner join departments d
   on e.department_id = d.department_id
  inner join locations l
   on d.location_id = l.location_id
  inner join jobs j
   on e.job_id = j.job_id
 where l.city = 'Seattle';
  
--6. 각 업무 별로 연봉의 총합을 구하고자한다. 연봉 총합이 가장 높은 업무로부터 업무명과 연봉 총합을 조회하시오. 단 연봉총합이 30,000보다 큰 업무만 출력합니다.
select j.job_title 업무명, sum(salary) 연봉_총합
  from employees e
  inner join jobs j
   on e.job_id = j.job_id 
 group by j.job_title
  having sum(salary) > 30000;
 
--7. 자신의 매니저보다 연봉(salary)를 많이 받는 직원들의 성과 연봉을 출력하시오.
select e.last_name 이름, e.salary 연봉
  from employees e
  inner join employees m
   on e.manager_id = m.employee_id
   and e.salary > m.salary;

--8. 각 사원에 대해서 사번, 이름, 부서명, 매니저의 이름을 조회하시오.
select e.employee_id 사번, 
       e.first_name 이름, 
       d.department_name 부서명, 
       nvl(m.first_name, 'THE BOSS') 매니저이름
  from employees e
  left outer join employees m
   on e.manager_id = m.employee_id
  inner join departments d
   on e.department_id = d.department_id; 

--9. 특정 사원의 사원번호가 다른 사원의 관리자번호에 있는 사원인 경우, 이 사원을 관리자라고 가정합니다. 이름에 "v"가 들어간 사원들에 대해 사원번호, 이름, 관리자 이름
--을 조회하고 관리자가 없는 경우에는 관리자 이름에 "관리자 없음"이라고 출력하도록 SQL 쿼리를 작성하세요. 
select e.employee_id 사번,
       e.first_name 이름,
       nvl(m.first_name, '관리지없음') "관리자 이름"
  from employees e
  left outer join employees m
   on e.first_name like '%v%'
  and e.manager_id = m.employee_id(+);
  
--10. 자신의 매니저보다 채용일이 빠른 사원의 사번, 성과 채용일을 조회하라. 단, 사원입사일 순으로 출력한다.
select e.employee_id 사번,
       e.last_name 이름,
       e.hire_date 사원입사일,
       m.hire_date 매니저입사일
  from employees e
  inner join employees m
   on e.manager_id = m.employee_id
  and e.hire_date < m.hire_date
  order by e.hire_date;
  
/* 11. 자신을 관리자 ID 로 지정하고 있는 직원수(직속부하직원수)를 다음과 같이 출력되도록 쿼리문을 작성하시오. 단, 직속부하직원 수가 8이상인 경우만 출력하고,
직속부하직원 수 순으로 내림차순 정열 */
select e.manager_id 사번, 
       m.last_name 이름,
       count(*) 직속부하직원수
  from employees e
  inner join employees m
   on e.manager_id = m.employee_id
  group by e.manager_id, m.last_name
   having count(*) >= 8;
  
-- 12. 자신의 부서 평균 급여보다 연봉이 많은 사원의 사번(employee_id), 성과 연봉을 조회하라
select e.employee_id 사번,
       e.last_name 이름, 
       e.salary 급여, 
       e.department_id 부서번호,
       avgsal.dptavgsal 부서평균급여
  from employees e
  inner join (select department_id, 
                     trunc(avg(salary)) dptavgsal
                from employees
               group by department_id
               order by avg(salary) desc) avgsal
   on  e.department_id = avgsal.department_id
  and e.salary > avgsal.dptavgsal;

--13. 'Sales' 부서에 속한 직원의 이름(first_name), 급여(salary)를 조회하시오. 단, 급여는 100번 부수의 평균보다 적게 받는 직원 정보만 출력되어야 합니다.
select e.first_name 이름,
       e.salary 급여,
       d.department_name 부서명
  from employees e
  inner join departments d
   on e.department_id = d.department_id
  and d.department_name = 'Sales'
  and e.salary < (select avg(salary)
                    from employees e
                    group by department_id
                    having department_id = 100);

--14. 각 도시에 있는 모든 부서 직원들의 평균급여를 조회하고자 한다. 평균급여가 가장 낮은 도시부터 도시명과 평균연봉을 출력하시오.
-- 단, 도시에 근무하는 직원이 10명 이하인 곳은 제외하고 조회한다. 
select city 도시,
       trunc(avg(e.salary)) 급여,
       count(e.employee_id) 근무인원수
  from departments d
  inner join locations l
   on d.location_id = l.location_id
  inner join employees e
   on d.department_id = e.department_id
  group by city
   having count(employee_id) > 10;

--15. 각 부서별로 최고 연봉을 받는 사원의 사번, 성과 연봉을 조회하시오. 단 조회결과는 연봉의 내림차순으로 정렬해서 나타내시오,
select employee_id, 
       last_name,
       salary
  from employees
  where (department_id, salary) in (select department_id, max(salary)
                                      from employees
                                      group by department_id)
  order by salary desc;
  
--16. 각 업무 별로 연봉의 총합을 구하고자한다. 연봉 총합이 가장 높은 업무부터 업무명과 연봉 총합을 조회하시오.
select job_title,
       sum(salary)
  from jobs j
  inner join employees e
   on j.job_id = e.job_id
  group by job_title
  order by sum(salary) desc;
  
--17. 각 업무가 어느 부서에서 수행되는지 조회하는 SQL 쿼리문을 작성하세요. 화면 출력은 JOB_TITLE 순으로 출력합니다.
-- 단, 수행하지 않는 업무는 표시하지 않고 중복되는 정보는 하나만 표시합니다. 
select job_title,
       department_name
  from (select j.job_title,
               d.department_name,
               count(*)
          from jobs j
          inner join employees e
           on j.job_id = e.job_id
          inner join departments d
           on e.department_id = d.department_id
          group by j.job_title, d.department_name)
 order by job_title;

--18. 사원이 입사한 연도별 입사자 수를 출력하시오. (입사년도가 빠른 순 출력)
select yr as "입사 년도",
       cnt as "입사자 인원"
  from (select to_char(hire_date, 'yyyy') yr,
               count(employee_id) cnt
          from employees
          group by to_char(hire_date, 'yyyy'))
  order by yr;
  
--19. 월별 입사자 수를 출력하시오. (입사월 순 출력)
select mm as "입사 월",
       cnt as "입사자 인원"
  from (select to_char(hire_date, 'mm') mm,
               count(*) cnt
          from employees
          group by to_char(hire_date, 'mm'))
  order by mm;
  
--20. 부서 이름별 직원의 평균연봉을 조회하시오.
-- 단 '30'번 부서의 직원 평균 연보오다 평균연봉이 이하인 부서 정보만 출려되어야합니다.
select d.department_name 부서명,
       avg(salary) 평균연봉
  from departments d
  inner join employees e
   on e.department_id = d.department_id
  group by department_name
   having avg(salary) <= (select avg(salary)
                           from employees e
                           group by department_id
                           having department_id ='30');
                           
--21. 2007년 입사한 직원들의 사번, 이름, 성, 부서명을 조회합니다.
-- 이때, 부서에 배치되지 않은 직원의 경우, '<NOT ASSINGED>'로 보여줍니다.
select employee_id,
       first_name,
       last_name,
       nvl(department_name, 'NOT ASSINGED') "NOT ASSIGNED"
  from employees e
  left outer join departments d
   on e.department_id = d.department_id
  where to_char(hire_date, 'yyyy') = '2007';

--22. 특정 사원의 사원번호가 다른 사원의 관리자 번호에 있는 사원인 경우, 이 사원을 관리자라고 가정합니다. 
-- 관리자가 있는 국가와 해당 국가에 있는 관리자 수를 국가 이름 순으로 조회하세요.
select country_name,
       count(사번) cnt
  from (select e.manager_id 사번, 
               count(*) 직속부하직원수
               from employees e
               inner join employees m
                on e.manager_id = m.employee_id
               group by e.manager_id) m
  inner join employees e
   on e.employee_id = m.사번
  inner join departments d
   on d.department_id = e.department_id
  inner join locations l
   on l.location_id = d.location_id
  inner join countries c
   on c.country_id = l.country_id 
  group by country_name
  order by country_name;

--23. 도시명이 'Southlake'인 지역에 근무하는 직원 중에 연봉을 가장 많이 받는 직원의 사번, 이름, 연봉을 출력하시오.
select employee_id,
       first_name,
       salary
  from (select rownum a,
               employee_id,
               first_name,
               salary
          from employees e
          inner join departments d
           on e.department_id = d.department_id
          inner join locations l
           on d.location_id = l.location_id
          where city ='Southlake'
          order by salary desc)
 where a = 1;
   
  