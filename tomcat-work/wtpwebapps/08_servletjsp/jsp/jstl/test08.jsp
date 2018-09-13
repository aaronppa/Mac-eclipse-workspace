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
		프로젝트(웹어플리케이션) 경로를 동적으로 가져오는 방법  
		
	 --%>
	 <h2>/08_servletjsp/board/list.do</h2>
	 
	 <%-- Java code로 프로젝트 경로 가져오기 --%>
	 <h2><%= request.getContextPath()%>/board/list.do</h2>
	 
	 <%--
	 	EL로 프로젝트 경로 가져오기
	 	 pageContext 다른 내장객체를 접근하는 내장객체 
	 	 pageContext.getRequest()
	 --%>
	 <h2>${pageContext.request.contextPath}/board/list.do</h2>
	 
	 <%-- JSTL 사용 --%>
	 <h2><c:url value="/board/list.do"/></h2>
</body>
</html>