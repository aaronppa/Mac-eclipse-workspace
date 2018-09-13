-- s_emp 테이블의 데이터를 기준으로 작성합니다.
   
--1. 각 부서별 월급의 최소값 구하기
select dept_id, min(salary)
  from s_emp
  group by dept_id;
 
--2. 직책별 최소 월급을 구하는데 부장(기획, 영업, 총무, 인사)은 제외하고 구하시오
select title, min(salary)
  from s_emp
 where title not like '%부장%'
 group by title;

--3. 직책별 평균 월급 구하기
select title, avg(salary)
  from s_emp
 group by title;

--4. 직책별 인원수 구하기
select title, count(*) Count
  from s_emp
 group by title;

--5. 직책별 최대 월급을 구하는데 그 최대 월급이 2000 이상인 것만 출력하시오
select title, max(salary)
  from s_emp
 group by title
 having max(salary)>2000;

--6. 직책별 최소 월급을 구하는데 부장(기획, 영업, 총무, 인사)은 제외하고 월급이 높은사람부터 출력하시오
select title, min(salary) minsal
  from s_emp
 group by title
 having title not like '%부장%'
 order by minsal desc;

--7. 직책별 평균 월급을 구하는데 사원은 제외하고 월급이 낮은 사람부터 출력하시오
select title, avg(salary) avgsal
  from s_emp
 group by title
 having title not like '%사원%'
 order by avgsal asc;

/* 8. 직책별 토탈 월급을 출력하는데 사원은 제외하고 또 그 토탈 월급이 2000 이상인 것만 나오게하고 
   직책별 토탈 월급을 높은 순으로 출력하시오 */
select title, sum(salary) totalsal
  from s_emp
 where title not like '%사원%'
 group by title
 having sum(salary)>2000
 order by totalsal desc;
   