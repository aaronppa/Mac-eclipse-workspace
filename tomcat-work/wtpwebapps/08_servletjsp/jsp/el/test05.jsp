<%-- 
		${객체[...]} : array, list [] 

 --%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String[] arr1 = {"one","two","three"};
    	List<String> arr2 = Arrays.asList(new String[]{"하나","둘","셋"});
    	
    	pageContext.setAttribute("arr1", arr1);
    	pageContext.setAttribute("arr2", arr2);
    	
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	arr1[0] : ${arr1[0]}<br>
	arr1[1] : ${arr1[1]}<br>
	arr2[0] : ${arr2[0]}<br>
	arr2[1] : ${arr2[1]}<br>
</body>
</html>