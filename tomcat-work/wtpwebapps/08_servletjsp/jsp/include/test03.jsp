<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test03.jsp</title>
</head>
<body>
	<h2>JSTL을 이용한 include</h2>
	<hr>
	<c:import url="one.jsp">
		<c:param name="no" value="1987"/>
		<hr>
	</c:import>
</body>
</html>