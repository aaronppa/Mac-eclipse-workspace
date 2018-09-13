<%--
	${객체} 
	
	객체찾기
	
		${param.id} --> <%=request.getParameter("id")%>
	
	 순서
	 	1. EL에서 제공하는 기본객체에서 객체와 같은 이름이 있는지 찾는다. 
	 		- param, paramValues
	 		- pageScope, requestScope, SessionScope, applicationScope
	 		- pageContext
	 		- cookie

		${name} 
	 	2. 1번에서 못찾은 경우 JSP 4가지 공유 영역에서 찾는다. 
	 		- JSP 4가지 공유영역과 연관된 객체(pageContext --> request --> Session --> application)
	 		- 특정 객체의 Key 값을 찾을 경우 ${requestScope.id} 와 같이 찾을 수 있다.  
	 		   
	 	
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	id Parameter : <%=request.getParameter("id")%><br>
	<%-- el은 null 값에 대한 처리를 한다 ("") --%>
	id Parameter(el) : ${param.id}<br>
</body>
</html>