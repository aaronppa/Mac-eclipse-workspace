<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.teamfive.repository.domain.Board"%>
<%@page import="java.util.List"%>
<%@page import="kr.teamfive.common.db.MyAppSqlConfig"%>
<%@page import="kr.teamfive.repository.mapper.BoardMapper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	List<Board> list = (List<Board>)request.getAttribute("list");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board Exercise</title>
<style>
	.button{
		background-color: blue;
	    border: none;
	    color: white;
	    padding: 15px 32px;
	    text-align: center;
	    text-decoration: none;
	    display: inline-block;
	    font-size: 16px;
	    margin: 4px 2px;
	    cursor: pointer;
	}
	
	td{
		text-align: center;
	}
</style>
</head>
<body>
	<!-- 게시물 목록 표현하기 -->
	<h2>자유게시판</h2>
	<hr>
	<table>
	<tr>
		<th>번호</th><th>제목</th><th>글쓴이</th><th>작성일</th><th>조회수</th>
	</tr>
	<%
	for (Board b : list){
	%>
	<tr>
		<td><%=b.getNo()%></td>
		<td><a href='/08_servletjsp/servlet/board/content_detail.do?no=<%=b.getNo()%>'><%=b.getTitle()%></a></td>
		<td><%=b.getWriter()%></td>
		<td><%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(b.getRegDate())%></td>
		<td><%=b.getViewCnt()%></td>
	</tr>	
	<%
	}
	%>
	</table>
	<hr>
	<a href="/08_servletjsp/servlet/board/writeForm.jsp" class="button" type="button">글쓰기</a> 
</body>
</html>