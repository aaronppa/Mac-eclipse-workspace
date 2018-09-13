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
	다중 조건 처리하는 태그:
		<choose>
			<when test="조건">
				참일때 수행 
			</when>
			<when test="조건">
				참일때 수행 
			</when>
			.....
			<otherwise>
			.....
			</otherwise>
		</choose>
		
		
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
	<c:when test="${auth == 'S'}">
		<h2>관리자 계정입니다.</h2>
	</c:when>
	<c:when test="${auth == 'U'}">
		<h2>일반 사용자 계정입니다.</h2>
	</c:when>
	<c:otherwise>
		<h2>인증되지 않은 사용자입니다.</h2>
	</c:otherwise>
	
	
</body>
</html>





















