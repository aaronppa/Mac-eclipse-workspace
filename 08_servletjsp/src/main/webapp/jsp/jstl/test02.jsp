<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		출력에 사용되는 태그: out 
	 --%>
	 <c:set var="msg1" value="test" />
	 <c:set var="msg2" value="<h1>test</h1>" />
	 
	 el msg1: ${msg1}<br>
	 el msg2: ${msg2}<br>
	 <c:out value="${msg2}"/>
	 <c:out value="${msg3}" default="메세지가 없습니다." />  
</body>
</html>