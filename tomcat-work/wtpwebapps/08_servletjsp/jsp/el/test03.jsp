
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- pageContext: 현재 자신 페이지에서만 사용가능(공유영역), 그래서 생각보다 많이 사용하지 않음 --%>
    <%
    	pageContext.setAttribute("msg", "page msg"); 
    	request.setAttribute("msg", "request msg"); 
    	request.setAttribute("name", "el"); 
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	page msg: ${msg}, ${pageScope.msg}<br>
	request msg: ${requestScope.msg}<br>
	request name: ${requestScope.name}<br>
</body>
</html>