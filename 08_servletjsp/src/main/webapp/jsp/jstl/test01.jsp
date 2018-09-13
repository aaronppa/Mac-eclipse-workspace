<%--
		JSTL(JSP Standard Tag Library)
		
		개발자가 직접 생성하는 태그(커스텀 태그) : 반복, 조건, 변수 태그  
		
		JSP 자체에는 제공되지 않는다. 
		JSTL을 사용하기 위해서는 라이브러리를 다운로드해서 사용해야한다.
		 - mvn을 활용 
		 
		JSTL에서 제공하는 태그의 종류(기능별)
		1. core - 가장 많이 사용됨(95%)
		2. fmt - 국제화, 날짜, 숫자 처리 (4%)
		3. function - String class의 주요 메소드 기능 구현 (1%)
		4. sql - 거의 사용 안함, myBatis와 완전 분리되어 있음 
		5. xml - 거의 사용 안함, JavaScript 사용 
		
		JSTL을 JSP에서 사용하기
		 - 커스텀 태그이기 떄문에 캐그에 어떤 라이브러리와 연관되어 있는지 알려주어야 한다. (taglib 지시자 사용)
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		데이터 공유를 태그를 활용 
		pageContext.setAttribute("a","b");
		
		set 태그
		scope를 생략한다면 디폴트로 page가 적용된다. 
		
		<c:set var="a" value="b" scope="page"/>
	 --%>
	<c:set var="a" value="b" />
	공유된 데이터(a) : ${a}<br>
	
	page 영역에 cnt 변수이름으로 1을 설정한다. <br>
	<c:set var="cnt" value="1" scope="page" />
	page 영역에 cnt 변수의 값: ${cnt}<br>
	
	request 영역에 cnt  변수이름으로 100을 설정한다. <br>
	<c:set var="cnt" value="100" scope="request" />
	request 영역에 cnt  변수의 값 : ${requestScope.cnt}<br>
	
	page 영역의 cnt변수 자체의 값을 1 증가시켜라.. <br>
	<c:set var="cnt" value="${cnt+1}" scope="page" />
	page 영역에 cnt  변수의 값 : ${cnt}<br>

</body>
</html>