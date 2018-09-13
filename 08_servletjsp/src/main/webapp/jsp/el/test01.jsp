<%--
		EL : Express Language
		 - jsp script(<% %>) 대신 사용
		 - 자바클래스의 메서드 호출, 집합 객체에 대한 접근 방법을 제공
		 - JSP에서 제공되는 내장객체 중에서 공유와 관련된 4가지 객체 접근해서 사용함
		 	(request, session, application, pageContext) : 내장객체 안의 특정 영역 (공유 영역)을 같이 사용함.
		 구문 :  ${??}, 오늘점심은${??}에서 먹자
		 
		EL 연산자
		 : 산술 연산자 사용가능(+,-,/(div),*,%(mod)) 
		 : 비교 연산자 (==(eq), !=(ne), <=(lt), >=(gt)) 
		 : 논리 연산자(&&(and), ||(or), !(not))
		 : 삼항 연산자 (? :)
		 
		추가된 연산자
		 : empty 연산자
		 	1. 값이 null인지 확인해서 null이면 true
		 	2. null이 아닌데 참을 받을 경우
		 		- 문자열 데이터의 길이가 9일떄 (String s=null, String s="")
		 		- 배열 또는 리스트의 데이터가 없는 경우, 길이가 0인 경우 true를 반환  
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>연산자 확인</h2>
	5 + 5 = <%=5+5%><br>
	5 + 5 = ${5+5}<br> 
	5 % 2 = ${5 % 2}<br>
	5 % 2 = ${5 mod 2}<br>
	5 == 2 = ${5 == 2}<br>
	5 == 2 = ${ 5 eq 2}<br>
	empty "a" = ${empty "a"}<br>
	empty "" = ${empty ""}<br>
	not empty "" = ${not empty ""}<br>
	
</body>
</html>