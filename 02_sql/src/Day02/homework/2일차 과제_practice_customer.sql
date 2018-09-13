-- 2조: 나원석, 이경, 임유신, 최원영

create table tb_customer(
    user_no number,
    reg_date date default sysdate,
    name varchar2(30) not null,
    user_id varchar2(50) not null,
    password varchar2(32) not null,
    dob date not null,
    gender char not null,
    zip varchar2(5) not null,
    address varchar2(60) not null,
    address2 varchar2(60) not null,
    phone_num varchar2(11) not null,
    email varchar2(128) not null,
    e_domain varchar2(510) not null,
    cell_num varchar2(11),
    work_num varchar2(11),
    work_zip varchar2(5),
    work_address varchar2(60),
    constraint customer_user_id_pk primary key (user_id), 
    constraint email_uq unique (email, e_domain)
);

drop table tb_customer purge;

select * 
  from tb_customer;