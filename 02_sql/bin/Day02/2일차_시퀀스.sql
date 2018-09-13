//--------------------------------------------
시퀀스(sequence) - 오라클에서 제공하는 자동 번호 발번하는 객체....
고유번호 생성기??, 영화관에 번호표 기계,,,

delete from tb_board;

insert into tb_board(no, title, writer, content) values(??, 'a', 'b', 'c');

-- 글번호 컬럼의 최대값을 찾아서 + 1을 한 값을 출력
-- 그룹함수는 행 데이터가 하나도 없을 경우 null을 반환한다.
select nvl(max(no), 0) + 1 from tb_board;

insert into tb_board(no, title, writer, content) 
values((select nvl(max(no), 0) + 1 from tb_board), 'a', 'b', 'c'); 
  
select * from tb_board;  

-- 시퀀스 생성하기
create sequence 시퀀스명;

create sequence s_board_no;

-- 번호 꺼내기  :  시퀀스이름.nextval
-- dual : 더미 테이블...
select s_board_no.nextval from dual; 

insert into tb_board(no, title, writer, content) 
values(s_board_no.nextval, 'a', 'b', 'c');

drop sequence 시퀀스명; 

drop sequence s_board_no;