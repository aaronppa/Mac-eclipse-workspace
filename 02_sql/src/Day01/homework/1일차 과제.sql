/*
1. 112, 118부서를 대상으로 과장과 사원의 이름, 직급, 급여, 부서ID를 조회하되, 급여는 1500 이상 4000 이하인 직원만 
   출력되도록 하시오. 
   단, 급여가 많은 사람부터 화면에 출력합니다.
*/
select name, title, salary, dept_id
  from s_emp
 where dept_id in (112, 118) 
   and salary between 1500 and 4000
 order by salary desc;
 

-- 2. 관리자가 없는 직원의 이름, 직급, 급여를 조회하시오. 
select name, title, salary
  from s_emp
 where manager_id is null;

-- 3. 직급이 부장이어야 하고 급여는 3000 이상을 받는 직원의 이름, 직급, 급여를 조회하시오. 
select name, title, salary
  from s_emp
 where title like '%부장%'
  and  salary >=3000;

/*
4. 직급이 부장과 과장인 사람들을 대상을 이름, 직급, 급여를 조회하시오. 
   단, 부서는 112, 113, 117, 118 부서중에서 조회해야 하며, 
   급여는 2300 이상 3000 사이인 직원만 조회되도록 하시오. 
*/
select name, title, salary
  from s_emp
 where dept_id in (112, 113, 117, 118)
  and (title like '%부장%'
  or title like '%과장%')
  and salary between 2300 and 3000;
  
/*
5. 직원의 연봉에 1000 을 더한 값을 조회하시오. 연봉은 급여에 16을 곱하면 된다. 
   단, 연봉은 ALIAS를 지정하여 출력되도록 한다. 
*/
select name, salary*16+1000 as 연봉
  from s_emp;
 
/*
6. 출력결과가 다음과 같도록 조회하시오. 
	직원 급여 
	--------------------------------- 
	박구곤 사장의 급여 5000 
	손명성 기획부장의 급여 3000 
	이은선 영업부장의 급여 3500 
	서의홍 총무부장의 급여 3000 
	김심선 인사부장의 급여 3200 
	... 
	...
*/
select name || ' '||title||'의 급여 '||salary as "직원    급여"
 from s_emp;

-- 7. 커미션을 받는 직원과 관리자가 있는 직원을 대상으로 급여를 2500이상 받는 직원만 조회하시오. 
select *
  from s_emp
 where commission_pct>=0
 and manager_ID is not null
 and salary >= 2500;

--8. 부장(기획, 영업, 총무, 인사)은 제외하고 월급이 높은 사람부터 출력하시오
select name
  from s_emp
 where title not like '%부장%'
 order by salary desc;

/*
9. 사원의 직책과 급여를 출력하시오.
    단, 사원은 제외하고 또 그 급여가 2000 이상인 것만 나오게 하고 급여가 높은 순으로 출력하시오
*/
select name, title, salary
  from s_emp
 where title not like '%사원%'
 and salary >= 2000
 order by salary desc;
 
/*
---------------------------------------------------------------------------
아래의 절에대한 정보를 찾아서 정리
group by column_name: 선택한 column의 동일한 값이 있으면 해당의 다른 column 값을 합산
having condition: group by로 합산된 테이블에 추가로 column을 기준으로 condition을 걸어 filter 하는 절임. 
                  group by가 없으면 사용 불가하고 where과 같이 사용 가능
insert into (column1, column 3... values value1, value3...) 
            또는 column 생략하고 value로 모든 column에 순서대로 
            또는 그냥 insrt into table_name: 로 데이터 추가
delete table_name 
  where condition : delete 만 쓰면 table 전체가 날라가고 *와 비슷하나, where condition을 써서 조건에 맞는 필요한 데이터만 삭제 가능
update table_name
  set column1 =  value1, column3 = value3
 where condition : where 조건이 없으면 모든 지정된 column의 데이터가 엎어치기됨
*/
    
    