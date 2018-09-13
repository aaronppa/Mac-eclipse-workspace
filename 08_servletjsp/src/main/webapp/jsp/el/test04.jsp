<%--
		객체를 찾은 다음 객체의 값을 꺼내는 방법 1
		
		찾은 객체가 VO 형태의 클래스 일 경우, 또는 Map 클래스 일 경우
		${Object.key} <-- Map  
		${Object.getMethod(without "get" and first letter in lowercase)} <-- VO  
		
 --%>
<%@page import="kr.teamfive.repository.domain.Board"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Map<String, String> data =new HashMap<>();
    	data.put("id", "hong");
    	data.put("name", "홍명보");
    	data.put("msg", "다들 축구장으로~");
    	pageContext.setAttribute("data", data);
    	
    	pageContext.setAttribute(/*  */"b", "test");

    	Board board = new Board();
    	board.setNo(1);
    	board.setTitle("연습");
    	board.setWriter("홍금보");
    	
    	pageContext.setAttribute("b", board);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	data : ${data}<br>
	<%--
			data.get("id")
			data.get("addr") : 없는 키를 호출할 경우에는 null이 반환되어 비어있는 형태 출력이 된다.
	 --%>
	id : ${data.id}<br>
	name : ${data.name}<br>
	msg : ${data.msg}<br>
	<%-- 없는 키를 호출할 경우에는 null이 반환되어 비어있는 형태 출력이 된다.  --%>
	addr : ${data.addr }<br>
	
	<hr>
	title: ${b.title}<br> <!-- 연습: b.getTitle() -->
	no : ${b.no}<br> <!-- 1: b.getNo() -->
	writer: ${b.writer}<br> <!-- 홍금보: b.getWriter() -->
	addr: ${b.addr } <!-- null : b.getAddr() -->
</body>
</html>