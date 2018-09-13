package kr.co.mlec.project.repository.vo;

public class User {
	private String id;
	private String password;
	private String passHint;
	private String gender;
	private String name;
	private String phone;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassHint() {
		return passHint;
	}
	public void setPassHint(String passHint) {
		this.passHint = passHint;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
/*
create table tb_mail_user(
    id varchar2(50) not null,
    password varchar2(50) not null, 
    pass_hint varchar2(50) not null, 
    gender varchar2(3) not null, 
    name varchar2(50) not null, 
    phone varchar2(50) not null,
    primary key (id)
    );
    
create table tb_mail(
    mail_no number not null,
	sender varchar2(50) not null,
	recipient varchar2(50) not null,
	reg_date date default sysdate,
	title varchar2(200) not null,
	content varchar2 not null,
	read_yn varchar2(10),
	delete_yn varchar2(10),
    primary key (mail_no)
);
    
*/