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
		조건 처리하는 태그: if
		
		if(statement){
		
				// 처리할 일 
			
		}
		
		char auth = "S";
		if(auth=="S") { 
			System.out.println("관리자 계정입니다.");
			}
		if(auth=="U") { 
			System.out.println("일반 사용자 계정입니다.");
			}
		if(auth=="A") { 
			System.out.println("인증되지 않은 사용자입니다.");
			}
			
		
	 --%>
	<c:set var="auth" value="S" /> 
	<c:set var="auth" value="U" /> 
	<c:set var="auth" value="A" /> 
	<c:if test="${auth == 'S'}">
		<h2>관리자 계정입니다.</h2>
	</c:if>
	<c:if test="${auth == 'U'}">
		<h2>일반 사용자 계정입니다.</h2>
	</c:if>
	<c:if test="${auth != 'S' and auth!='U'}">
		<h2>인증되지 않은 사용자입니다.</h2>
	</c:if>
	
	
</body>
</html>


























