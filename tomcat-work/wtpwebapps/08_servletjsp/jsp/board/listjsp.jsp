<%@page import="kr.teamfive.repository.domain.Board"%>
<%@page import="java.util.List"%>
<%@page import="kr.teamfive.common.db.MyAppSqlConfig"%>
<%@page import="kr.teamfive.repository.mapper.BoardMapper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	// BoardMapper 인터페이스에 있는 selectBoard() 호출 
 	BoardMapper mapper = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardMapper.class);
 	// 데이터베이스게시물 목록 가지고 오기 
 	List<Board> list = mapper.selectBoard();
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board Exercise</title>
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
		<td><a href=""><%=b.getNo()%></a></td><td><%=b.getTitle()%></td><td><%=b.getWriter()%></td><td><%=b.getRegDate()%></td><td><%=b.getViewCnt()%></td>
	</tr>	
	<%
	}
	%>
	</table>
	<a href="writeForm.jsp">글쓰기</a> 
</body>
</html>