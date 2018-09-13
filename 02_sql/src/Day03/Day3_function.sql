//-------------------------------------------------------------
Oracle Functions: 내장함수(그룹행함수, 단일행 함수) 사용자 정의 함수

단일행 함수
--문자 함수
--숫자 함수
--날짜 함수

--타입변환
    --문자로 변환(to_char): 숫자 -> 문자, 날짜 -> 문자
    --숫자로 변환(to_number) : 문자 -> 숫자('1000')
    --날짜로 변환(to_date): 문자 -> 날짜('20180101'), ('2018-01-01')

--기타함수:  nvl, decode, case

-------------------------------------------------------------//

-- 문자형 함수
select upper('a'), lower('A'), concat('홍길동','의적')
 from dual;
 
select first_name, upper(first_name), last_name, lower(last_name),
       concat(first_name,upper(last_name))
  from employees;
  
select substr('hello', 1,2)
  from dual;

2018, 08, 09
select substr('2018-08-09',1,4),
       substr('2018-08-09',6,2),
       substr('2018-08-09',9,2)
  from dual;

-- 채워준다...
select lpad('test', 10, '*'), rpad('hello',10,'!')
  from dual;
  
select 'hi hello sql',
        translate('hi hello sql','el','am'), --by individual character
        replace('hi hello sql','el','am') -- by character group in ''
  from dual;

--데이터 안의 숫자를 * 로 표시하시오.
select 'won 12345young',
        translate('won 12345young','12345','*')
  from dual;
  
select 'hello', length('hello')
  from dual;

where email like'_____'';
where length(email) = 5;

--upper, lower, concate, substr, lpad, rpad, translate, replace, length

--숫자형 함수
-- 절대값(absolute)
select abs(100), abs(-100)
  from dual;

--ceil: 입력된 수보다 크거나 같으면서 가장 작은 정수, 3.7 -> 4, 3 -> 3
--floor: 입력된 수보다 작거나 같으면서 가장 큰 정수, 3.7 -> 3, 3-> 3

select ceil(1.1), floor(1.1)
  from dual;

--round: 반올림  
--trunc: 버림
select round(73.727), trunc(73.727)
  from dual;

select round(73.727,2), trunc(73.727,2)
  from dual;

select round(73.727,-1), trunc(73.727,-1)
  from dual;

select round(73.727,-2), trunc(73.727,-2)
  from dual;

-- round, trunc, ceil, floor

-- Date Functions
select sysdate
  from dual;

--add_months: 날짜에 월을 더한다. 
select sysdate,
        add_months(sysdate, 5),
        add_months(sysdate, -5)
  from dual;

-- 사원의 수습기간이 6개월 뒤다. 각 사원의 수습기간이 끝나는 날을 출력
select hire_date,add_months(hire_date,6)
  from employees;
  
-- months_between(날짜1, 날짜2): 두 날짜간의 월 차이를 값으로 리턴, 첫번째 매개변수 날짜 기준, 첫날짜가 뒷날짜보다 과거이면 -값 리턴

-- 각 사원의 근무 개월을 출력하라.
select last_name, 
        months_between(sysdate, hire_date),
        trunc(months_between(sysdate, hire_date))
  from employees;

--last_day(date): 날짜가 가진 월의 마지막 날짜를 반환
select sysdate, last_day(sysdate)
  from dual;
  
-- 날짜 + 숫자 = 날짜값 반환
-- 날짜 - 숫자 = 날짜값 반환
-- 날짜 - 날짜 = 숫자값 반환
select sysdate, sysdate+7, sysdate-7, sysdate+10/24
  from dual;
  
select sysdate - hire_date
  from employees;

-- add_months, months_between, last_day

--변환형 함수
-- to_date, to_char, to_number

-- to_char(날짜, '패턴'): 날짜를 문자로 변경

/*
 날짜 패턴문자
 y : 년
 m :월
 hh24 : 24시간 단위
 hh : 12시간 단위
 mi : 분
 ss : 초

*/

select to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss'),
        to_char(sysdate, 'yyyy-mm-dd'),
        to_char(sysdate, 'yyyy/mm/dd')
  from dual;
  
select to_date('2018-11-11 10:10:10','yyyy-mm-dd hh24:mi:ss'),
        to_date('2018-11-11','yyyy-mm-dd')
  from dual;
  
-- 2018-03-03 날짜 데이터로 저장
insert into tb_board(no, writer, title, contents, reg_date)
    values(s_board_no.nextval, 'aaa','bbb','ccc',
    to_date('2018-03-03','yyyy-mm-dd'));

--게시물의 데이터를 조회하세요...
select *
  from tb_board
 where reg_date between to_date('2018-08-08','yyyy-mm-dd')
                and to_date('2018-08-08 23:59:59','yyyy-mm-dd hh24:mi:ss');


-- 사원중에서 5월에 입사한 사월들의 정보를 출력하라
select * 
  from employees
 where to_char(hire_date, 'mm') = '05'; 
 
-- 현재 월과 동일한 월에 입사한 사원의 정보를 출력
select *
  from employees
 where to_char(sysdate, 'mm') = to_char(hire_date, 'mm');
 
-- to_char(숫자, '패턴'): 숫자를 문자로 변경
-- 패턴문자: 9,0 (9과 0의 차이, 공백이 있을 경우 9는 공백을, 0은 0으로 대체)
select to_char(1234),
       to_char(782478912,'999,999,999'),
       to_char(78247891,'999,999,999'),
       to_char(78247891, '000,000,000'),
       to_char(8782478912, '999,999,999'), -- 자리수가 모자르면 #으로 모두 출력
       to_char(8782478912, '999,999,999,999') -- 방지하기 위해서 자리수를 충분히 줘라
  from dual;

-- to_number()
select to_number('1234'), to_number('1,234','9,999')
  from dual;

--to_date, to_char, to_number

//----------------------------
-- 기타함수: nvl, decode, case

--nvl(): null값인 경우 지정된 값으로 변환
select employee_id, last_name, manager_id
  from employees;

select employee_id, last_name, nvl(to_char(manager_id),'THE BOSS')
  from employees;

select employee_id, last_name, nvl(manager_id || '', 'THE BOSS') -- 묵시적 형변환 
  from employees;


-- decode(): java switch와 유사..
/* in Java...
    switch(job_id) {
        case "IT_PROG" : .... break;
        case "....." : .... break;
        default: ....;
    }
*/

select job_id, 
       decode(job_id, 'IT_PROG', '개발자',
                      'SA_MAN', '세일즈',
                      '기타') as job_type
  from employees;

-- case는 decode를 대체함
/*
CASE column_name WHEN value1(비교값) THEN 처리값
                    WHEN value1(비교값) THEN 처리값
                    .....
                    ELSE default_value..
    END
*/

select job_id,
       case job_id when 'IT_PROG' then '개발자'
                   when 'SA_MAN' then '세일즈'
                   else '기타'
        end as job_type2
  from employees;


select job_id,
        case when job_id = 'IT_PROG' then '개발자'
             when job_id = 'SA_MAN' then '세일즈'            
             else '기타'
         end as job_type3
  from employees;

-- 사원의 급여에 따라서 다음과 같이 출력합니다.
-- 급여가 15000 이상이라면 '고급 인력'
-- 12000 이상이라면 '중급 인력'
-- 12000 미만이라면 '초급 인력'
select last_name, salary,
        case when salary >= 15000 then '고급 인력'
             when salary >= 12000 then '중급 인력'
             when salary < 12000 then '초급 인력'
         end as 인력구분
  from employees;



