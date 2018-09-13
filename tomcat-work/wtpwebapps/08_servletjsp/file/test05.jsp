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
	<h2>File Download -1 </h2>
	<hr>
	<a href="<c:url value="/common/file/download?name=3febb66d-af4d-405b-9bb1-53be502b356a.jpg&path=/2018/09/06/13"/>">보여주기</a>
	<a href="<c:url value="/common/file/download?name=3febb66d-af4d-405b-9bb1-53be502b356a.jpg&path=/2018/09/06/13&dname=아론.jpg"/>">다운로드</a>
	<div>
	<img src="<c:url value="/common/file/download?name=3febb66d-af4d-405b-9bb1-53be502b356a.jpg&path=/2018/09/06/13"/>" width="500px" />
	</div>
</body>
</html>