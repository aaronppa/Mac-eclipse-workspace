<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>구구단 출력</title>
<style>
	table, th, tr, td{
	border: 1px solid black;
	}
	th, td{
		width: 50px; height: 10px;
		text-align: center;
	}
</style>
</head>
<body>
		<%  
		int mult = Integer.parseInt(request.getParameter("multiple"));
		%>
		<table>
		<tr>
			<th>단</th>
			<th>값</th>
		</tr>
		
		<%
		for(int i=1;i<=9;i++){ 
		%> 
			<tr>
				<td><%= mult %> * <%= i %></td>
				<td><%= mult * i %></td>
			</tr>
		<%
		}
		%>
			
		</table>
			
</body>
</html>