----------------------------------------------
SET 연산자
 : 여러개의 select 절을 연결해서 사용한다.
 : 집합 개념 이해 필요함...(합집합, 교집합, 차집합)
 : 합집합 - union(중첩된 부분은 한번만, 정렬), union all
 : 교집합 - intersect
 : 차집합 - minus
 : order by 는 제일 마지막에 한번만 사용 가능하다.
 : SELECT 절
   SET 연산자
   SELECT 절

 
create table tb_seta (
    no number,
    data varchar2(2)
); 
 
create table tb_setb (
    no number,
    data varchar2(2)
);  
 
insert into tb_seta(no, data) values(1, 'a'); 
insert into tb_seta(no, data) values(2, 'b');
insert into tb_seta(no, data) values(3, 'c');
insert into tb_seta(no, data) values(4, 'd');

select * from tb_seta;

insert into tb_setb(no, data) values(5, 'e'); 
insert into tb_setb(no, data) values(6, 'f');
insert into tb_setb(no, data) values(3, 'c');
insert into tb_setb(no, data) values(4, 'd');

-- 합집합 
select * from tb_seta
union all
select * from tb_setb;

select * from tb_seta
union
select * from tb_setb;

-- 교집합 : intersect
select * from tb_seta
intersect
select * from tb_setb;

-- 차집합 : minus
select * from tb_seta
minus
select * from tb_setb;

select last_name, salary
  from employees
union all
select department_name, department_id
  from departments;  
  
-- 주의1 : 컬럼의 수가 일치해야 한다.   
select last_name, salary
  from employees
union all
select department_name
  from departments;    
  
-- 주의2 : 대응되는 위치의 컬럼은 데이터 타입이 동일해야 한다.  
select last_name, salary
  from employees
union all
select department_id, department_name
  from departments;    

-- 주의3 : order by 절은 마지막에 위치해야 한다.
select last_name, salary
  from employees
 order by last_name 
union all
select department_name, department_id
  from departments;  
  
select last_name, salary
  from employees
union all
select department_name, department_id
  from departments
order by last_name;   

-- SET 연산자를 이용해서 여러개의 SELECT 절을 연결하면 결과컬럼의 헤딩은 첫번째 select 문이 적용
select last_name, salary
  from employees
union all
select department_name, department_id
  from departments
order by last_name;     

-- 사용 예>
select last_name 사원명, salary 급여
from employees
union all
select '총합', sum(salary)
from employees;