//---------------------------------------------
-- 오라클 함수  :  내장함수(그룹행함수, 단일행 함수), 사용자 정의 함수

단일행 함수
- 문자 함수
- 숫자 함수
- 날짜 함수
- 변환형 함수 
  문자로 변환(to_char)  :  숫자 -> 문자, 날짜 -> 문자
  숫자로 변환(to_number)  :  문자 -> 숫자 ( '1000' )
  날짜로 변환(to_date)  :  문자 -> 날짜 ( '2018-01-01' )
- 기타함수 : nvl, decode, case  
  
----------------------------------------------------------------------
-- 문자형 함수
select 'a', 100, sysdate, upper('a')
  from employees;

select upper('a'), lower('A'), concat('홍길동', ' 의적')
  from dual;
  
select  first_name, upper(first_name), last_name, lower(last_name),
          concat(concat(upper(first_name), ' '), last_name)
  from employees; 
   
-- he
select substr('hello', 1, 2)
  from dual;

--2018, 08, 09
select substr('2018-08-09', 1, 4),
         substr('2018-08-09', 6, 2),
         substr('2018-08-09', 9, 2) 
  from dual;

-- 채워준다.. 

select lpad('test', 10, '*'), rpad('test', 10, '*')
  from dual;
  
select lpad(last_name, 10, '*')
  from employees;  

select 'hi hello sql', 
         translate('hi hello sql', 'el', 'am'),
         replace('hi hello sql', 'el', 'am')
  from dual;
  
-- 데이터 안의 숫자를 * 로 표시하시오...
select 'hong 12345won',
         translate('hong 11900won', '0123456789', '**********')
  from dual;  
  
select 'hello', length('hello') 
  from dual;  
  
where email like '_____';
where length(email) = 5;
  
upper, lower, concat, substr, lpad, rpad, translate, replace, length

-- 숫자형 함수
select abs(100), abs(-100)
  from dual;
  
-- ceil   : 입력된 수보다 크거나 같은면서 가장 작은 정수,   3.7  -> 4, 3 -> 3
-- floor : 입력된 수보다 작거나 같은면서 가장 큰 정수 ,     3.7 -> 3, 3 -> 3

select ceil(1.1), floor(1.1)
  from dual; 
  
-- round : 반올림
-- trunc  : 버림
select round(73.727), trunc(73.727)
  from dual;
  
select round(73.727, 2), trunc(73.727, 2)
  from dual;
  
select round(73.727, -1), trunc(73.727, -1)
  from dual;

select round(73.727, -2), trunc(73.727, -2)
  from dual;
  
-- round, trunc, ceil, floor

-- 날짜형 함수
select sysdate
  from dual;  
  
add_months : 날짜에 월을 더한다.

select  sysdate,
          add_months(sysdate, 5),
          add_months(sysdate, -5) 
  from dual;
  
-- 사원의 수습기간이 6개월 뒤다.. 각 사원의 수습기간이 끝나는 날을 출력
select hire_date, add_months(hire_date, 6)
  from employees;  
  
-- months_between(날짜1, 날짜2) : 두날짜간의 개월차를 반환

-- 각 사원의 근무 개월을 출력하라.
select last_name, 
         months_between(sysdate, hire_date),
         trunc(months_between(sysdate, hire_date))
  from employees;

-- last_day(날짜) : 날짜가 가진 월의 마지막 날짜를 반환
select sysdate, last_day(sysdate)
  from dual;
  
-- 날짜 + 숫자 = 날짜
-- 날짜 - 숫자 = 날짜
-- 날짜 - 날짜 = 숫자
select sysdate, sysdate + 7, sysdate - 7, sysdate + 10/24
 from dual;
  
select sysdate - hire_date
  from employees; 

add_months, months_between, last_day

-- 변환형 함수
to_date, to_char, to_number

-- to_char(날짜, '패턴') : 날짜를 문자로 변경
SimpleDateFormat sdf = new SimpleDateFormat(
    "yyyy-MM-dd hh:mm:ss"
); 
String sDate = sdf.format(new Date());          -- to_char
Date d = sdf.parse("2018-08-09 11:11:11");  -- to_date

/* 
       날짜 패턴문자
       y : 년
       m : 월
       d : 일
       hh24 : 24시간 단위
       mi : 분
       s : 초
 */
select to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss'),
         to_char(sysdate, 'yyyy-mm-dd'),
         to_char(sysdate, 'yyyy/mm'),
         to_char(sysdate, 'mm') 
  from dual;
  
select to_date('2018-11-11 10:10:10', 'yyyy-mm-dd hh24:mi:ss'),
         to_date('2018-11-11', 'yyyy-mm-dd')
  from dual;  
  
-- 2018-03-03 날짜 데이터로 저장
insert into tb_board(no, writer, title, content, reg_date)
values (s_board_no.nextval, 'aaa', 'bbb', 'ccc',  
            to_date('2018-03-03', 'yyyy-mm-dd') )
 
-- 게시물의 데이터를 조회하세요...
select *
  from tb_board
 where reg_date between to_date('2018-08-08', 'yyyy-mm-dd') 
                         and to_date('2018-08-08 23:59:59', 'yyyy-mm-dd hh24:mi:ss');
                         
-- 사원중에서 5월에 입사한 사원들의 정보를 출력하라
select *
  from employees
 where to_char(hire_date, 'mm') = '05';

-- 현재 월과 동일한 월에 입사한 사원의 정보를 출력
select *
  from employees
 where to_char(hire_date, 'mm') = to_char(sysdate, 'mm');
 
-- to_char(숫자, '패턴') : 숫자를 문자로 변경
-- 패턴 문자 : 9, 0
-- 자리수가 모자라면 #으로 출력됨...
select to_char(1234),
         to_char(782478912, '999,999,999'),
         to_char(8782478912, '999,999,999,999')  
  from dual;
  
select to_number('1234'), to_number('1,234', '9,999')
  from dual;  
  
-- 기타함수 : nvl, decode, case
select employee_id, last_name, manager_id
  from employees;

select employee_id, last_name, nvl(to_char(manager_id), '관리자 없음')
  from employees;
  
select employee_id, last_name, nvl(manager_id || '', '관리자 없음')
  from employees;

/*
      switch (job_id) {
         case "IT_PROG" :   .....  break;
         case "............." :   .....  break;
         default: .......;
      }
*/
decode : java switch 와 유사하다...

select job_id, 
         decode(job_id, 'IT_PROG', '개발자',
                               'SA_MAN', '세일즈',
                               '기타'
         ) as job_type
  from employees;
  
decode 대체한다..  
case 컬럼 when 비교값1 then 처리값 
             when 비교값1 then 처리값 
             ....
             else 기본값...
  end
  
select job_id, 
         decode(job_id, 'IT_PROG', '개발자',
                               'SA_MAN', '세일즈',
                               '기타'
         ) as job_type,
         case job_id  when 'IT_PROG' then '개발자'
                           when 'SA_MAN' then '세일즈'
                           else '기타'
          end as job_type2,
          case when job_id = 'IT_PROG' then '개발자'
                 when job_id = 'SA_MAN' then '세일즈'
                 else '기타'
           end as job_type3 
  from employees;
  
-- 사 원의 급여에 따라서 다음과 같이 출력합니다.
-- 급여가 15000 이상이라면 '고급 인력'
--         12000 이상이라면 '중급 인력'
--         12000 미만 이라면 '초급 인력'
select salary,
         case when salary >= 15000 then '고급 인력'
                when salary >= 12000 then '중급 인력'
                else '초급 인력'
          end as sal_type
  from employees;
  



  
                      




