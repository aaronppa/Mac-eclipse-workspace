<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	// 공유 데이터 가져오기
    	String msg = (String)request.getAttribute("msg");
    	List<String> list = (List<String>)request.getAttribute("list");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>msg: <%=msg%></h2>
	<h2>list</h2>
	<ul>
	<%
	for(String li:list){
	%>
		<li><%=li%></li>
	<%
	}
	%>
	</ul>
</body>
</html>