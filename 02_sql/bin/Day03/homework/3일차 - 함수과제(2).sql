--1. 부서의 이름이 10자 미만인 경우만 화면에 출력하되 10자리에 맞추어 남는 자리에 자신의 지릿수에 해당하는 숫자를 붙여서 출력하시오.
select department_name || substr('1234567890',length(department_name)+1,10-length(department_name)) as "Custom Department Name"
  from departments
 where length(department_name) < 10;
 
--2. 각 직책별 급여의 합계를 부서별로 구하시오, 단 사원, 과장을 제외한 직책은 기타로 구하시오 
-- decode 또는 case 함수 이용하여 풀이하시오
select dept_id, (select sum(salary) from s_emp group by title, dept_id HAVING title = '사원') 사원
  from s_emp m
 order by dept_id;