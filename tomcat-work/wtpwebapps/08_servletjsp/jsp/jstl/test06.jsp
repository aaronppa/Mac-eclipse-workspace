<%@page import="java.util.List"%>
<%@page import="kr.teamfive.repository.domain.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	List<Board> list = new ArrayList<>();
    	for (int i =1; i < 6; i++){
    		Board b = new Board();
    		b.setNo(i);
    		b.setTitle("제목" + i);
    		list.add(b);
    	}
    	
    	pageContext.setAttribute("list", list);
    	
    	String[] arr = {"fishing","cooking","coding","billiard"};
    	pageContext.setAttribute("arr", arr);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	for(Board b:list){
	
	}
 --%>
	<c:forEach var="b" items="${list}">
		${b.no} - ${b.title}<br>
	
	</c:forEach>
	
	취미: fishing, cooking, coding, billiard
	<br>
	취미:  
	<c:set var="i" value="0" />
	<c:forEach var="data" items="${arr}">
		<c:if test="${i !=0}">, </c:if>${data}
		<c:set var="i" value="${i+1}" />
	</c:forEach>
	
	<br>
	취미:
	<c:forEach var="data" items="${arr}" varStatus="loop">
		${data}::${loop.first}::${loop.last}::${loop.index}::${loop.count}::
		<c:if test="${!loop.last}">,</c:if>
	</c:forEach>
	<br>
	취미:
	<c:forEach var="data" items="${arr}" varStatus="loop">
		${data}
		<c:if test="${!loop.last}">,</c:if>
	</c:forEach>
</body>
</html>