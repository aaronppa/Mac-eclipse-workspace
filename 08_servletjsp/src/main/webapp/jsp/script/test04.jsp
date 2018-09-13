 <%-- <%@ page import="java.util.List, java.util.ArrayList" %>  따로따로 쓰는 걸 권장  --%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%-- 
   		import java.util.List;
   		import java.util.ArrayList;
    --%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<% 
	// 문자열을 여러개 담을 수 있는 List 를 사용한다.
	List<String> list = new ArrayList<>();
	list.add("하나");
	list.add("둘");
	list.add("셋");
%>
</head>
<body>
	<%--
		지시문
		1. page
		: JSP 파일 실행시 필요한 정보를 설정
		: 여러가지 속성과 함께 사용한다.
		: 여러가지 속성과 함께 사용한다. 
		: import, contentType 이것만.. 이것... 
		
		// 나중에 설명~~
	 --%>
	 
	 <%--
	 	화면에 아래와 같이 출력하는 코드 작성 
	 	1. 하나
	 	2. 둘
	 	3. 셋 
	  --%>
	  <ol>
	  	  <% for(String l:list){
		  %>
		  	<li><%= l %></li>
		  <%
	  	  }
		  %>
	  </ol>
</body>
</html>