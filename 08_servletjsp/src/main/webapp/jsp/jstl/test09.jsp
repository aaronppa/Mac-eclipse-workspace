<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	날짜 -> 문자 
	String date = sdf.format(new Date());
	
	문자 -> 날짜 
	Date d = sdf.parse("2018-02-02");
	int year = d.getYear(); + 1900;
	
 --%>
 
 <fmt:parseDate var ="d" value="2018-02-02" pattern="yyyy-MM-dd" />
 년도 : ${d.year+1900} <br>
 
 변환된 날짜 : 
 <fmt:formatDate value="${d}" pattern="yyyy-MM-dd" />
</body>
</html>