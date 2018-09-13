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
	반복문 처리 태그 
	for(int i=1;i<=10;i++){
	
	}
	
	for(String val: arr){
	
	}
	
 --%>
<%-- <c:forEach var="i" begin="1" end="10" step="1"> step은 디폴트 값--%>
 <c:forEach var="i" begin="1" end="10" step="1">
 ${ i }<br>
 </c:forEach>
 <hr>
 년도:
 <select>
 	<c:forEach var="i" begin="1960" end="2000">
 	<option value="${i}">${i}</option>
 	</c:forEach>
 </select>
</body>
</html>