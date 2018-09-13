select count(*) count
  from tb_board;
  
select *
  from tb_board;
  
select no, title, reg_date regDate, writer, view_cnt viewCnt, content
	from tb_board
 order by no desc;
 
 desc tb_board;
 
 select no, title, reg_date regDate, writer, view_cnt viewCnt, content   from tb_board  order by no desc 