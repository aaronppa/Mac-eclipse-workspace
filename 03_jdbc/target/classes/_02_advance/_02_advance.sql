create table tb_account(
    user_id varchar2(10),
    money number(6)
);

insert into tb_account values('won', 100000);

insert into tb_account values('kim', 100000);

commit;


