create table tb_todo(
 no number,
 item varchar2(50)
);

alter table tb_todo
modify no number not null;

create sequence s_todo_no;

alter table tb_todo
add todo_date date,
    reg_date date default sysdate;
    

create table tb_board_attach(
    file_no number(6) Constraint file_no_pk primary key,
    no number(6) not null references tb_board(no) on delete cascade,
    file_path varchar2(4000) not null,
    file_original_name varchar2(2000) not null,
    file_sys_name varchar2(2000) not null
);
commit;

create sequence s_board_file_attach_no;
commit;

drop sequence s_board_file_attach;
drop table tb_board_attach purge;

drop table tb_comment purge;

create table tb_comment (
	comment_no number(6) primary key,
	no number(6) not null references tb_board(no),
	content varchar2(200) not null,
	writer varchar2(20) not null,
	reg_date date default sysdate
);
commit;

create sequence s_comment_no;
commit;