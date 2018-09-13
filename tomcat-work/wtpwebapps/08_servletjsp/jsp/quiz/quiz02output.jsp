<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>입사 지원 내용</title>
<style>
	table * {
		border: 1px solid black;
	}
	table{
	 	width: 300px;
	}
	td{
		width: 50%;
	}
</style>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");

	final String[] MAJOR = {"","컴퓨터공학", "전자과", "수학과", "산업공학과"};	
	final String[] COMM = {"","이메일", "문자(SMS)", "우편"};	
	
	Map<String, String> subjectMap = new HashMap<>();
	subjectMap.put("1", "EJB");
	subjectMap.put("2", "Spring");
	subjectMap.put("3", "UML");
	subjectMap.put("4", "JDBC");
	subjectMap.put("5", "서블릿");
	subjectMap.put("6", "JSP");
	
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	String major = request.getParameter("major");
	if(major==null) major = "선택안함";
	else major= MAJOR[Integer.parseInt(request.getParameter("major"))];
	
	String comm = request.getParameter("comm");
	String open = request.getParameter("open");
	if(open==null) major = "동의 안함";
		
	String[] subject = request.getParameterValues("subject");
	String subjectMsg = "입력하지 않음";
	if(subject !=null) {
		for(String s:subject){
			subjectMsg += subjectMap.get(s) + " ";
		}
	}
%>
<div>
	<table>
		<tr>
			<th colspan="2">입사 지원 내용</th>
		</tr>
		<tr>
			<td>이름</td>
			<td><%= name %></td>
		</tr>
		<tr>
			<td>핸드폰</td>
			<td><%= phone %></td>
		</tr>
		<tr>
			<td>이메일 주소</td>
			<td><%=email%></td>
		</tr>
		<tr>
			<td>학과</td>
			<td><%=major%></td>
		</tr>
			<tr>
			<td>이수 과목</td>
			<td><%=subjectMsg%></td>
		</tr>
			<tr>
			<td>정보 발송 방법</td>
			<td><%=(comm.intern() =="1") ? "이메일" : "우편"%></td>
		</tr>
			<tr>
			<td>정보 발송 여부</td>
			<td><%=(open==null) ? "동의하지 않음" : "동의함"%></td>
		</tr>
		
		
	</table>
	</div>
</body>
</html>