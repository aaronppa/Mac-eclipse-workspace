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
	<h2>File Upload -2 </h2>
	<hr>
	<%--
		File Upload Restriction: 
			method="post"
			enctype="multipart/form-data"
	 --%>
	<%--- <form action="<%=request.getContextPath()%>"> --%>
	<%-- <form action="${pageContext.request.contextPath}/jsp/file/upload1.do"> --%>
	<form action="<c:url value="/jsp/file/test02.do"/>" 
		  method="post"
		  enctype="multipart/form-data" 
	>
	<div>
		<input type="text" name="msg" />
	</div>
	<div>
		<input type="file" name="attach1" />
	</div>
	<div>
		<input type="file" name="attach2" />
	</div>
	<div>
		<button>Submit</button>
	</div>
	</form>
</body>
</html>