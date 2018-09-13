<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		실행문: Javacode 
		표현식: 출력할 부분을 명시 (out.println(값))
		
	 --%>
	 <%-- 
	 	안녕하세요 문자열을 msg 변수에 답는 선언 
	  --%>
	  
	  <%
	  String msg = "Hello World";
	  %>
	  
	  <br>
	  <%-- 
	  	화면에 담과 같이 출력한다.
	  	msg 변수에 담긴 값을 확인...
	  	msg: 안녕하세요. 
	    out.println("msg : " + msg");
	   --%>
	   <%= "msg : " + msg %>
	   <br>
	   msg : <%= msg %>
</body>
</html>