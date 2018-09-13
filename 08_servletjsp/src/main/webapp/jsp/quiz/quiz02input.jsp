<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>입사지원</title>
<style>
	h1, .item{
		text-weight: bold;
	}

	
</style>
</head>
<body>
	<form action="quiz02output.jsp">
	<div>
		<h1>입사지원</h1>
	</div>
	<div class="first">
		<h4>아래 항목을 입력해주세요.</h4>
		<h4 class="item">개인정보</h4>
		이름
		<input type="text" name="name"><br>
		핸드폰
		<input type="text" name="phone"><br>
		이메일주소
		<input type="email" name="email"><br>
	</div>
	<div>
		<h4 class="item">학과를 선택해 주세요.</h4>
		<input type="radio" name="major" id="major1" value="1">
		<label for="major1">컴퓨터공학과</label>
		<input type="radio" name="major" id="major2" value="2">
		<label for="major2">전자공학</label>
		<input type="radio" name="major" id="major3" value="3">
		<label for="major3">수학과</label>
		<input type="radio" name="major" id="major4" value="4">
		<label for="major3">산업공학과</label>
		<br>
		
		<h4 class="item">이수 과목은 무엇입니까?</h4>
		<input type="checkbox" name="subject" id="subj1" value="1" />
		<label for="subj1">EJB</label>
		<input type="checkbox" name="subject" id="subj2" value="2" />
		<label for="subj2">Spring</label>
		<input type="checkbox" name="subject" id="subj3" value="3" />
		<label for="subj3">UML</label><br>
		<input type="checkbox" name="subject" id="subj4" value="4" />
		<label for="subj4">JDBC</label>
		<input type="checkbox" name="subject" id="subj5" value="5" />
		<label for="subj5">서블릿</label>
		<input type="checkbox" name="subject" id="subj6" value="6">
		<label for="subj6">JSP</label>		
		
	</div>
	<div>
		<p>정보 발송방법
		<select name="comm">
			<option value="1">이메일</option>
			<option value="2">우편</option>
		</select>
	</div>
	<div>
		<input type="checkbox" name="privacy" value="y" id="open"/>
		<label for="open">개인정보 이용 약관에 동의합니다.</label> 
	</div>
	<br>
	<div class="submit">
		<button>전송</button>
	</div>
	</form>
</body>
</html>