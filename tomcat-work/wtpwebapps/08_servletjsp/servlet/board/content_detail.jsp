<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.teamfive.repository.domain.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
   		Board board = (Board)request.getAttribute("board");
   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자유게시판: 글상세 조회</title>
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
</style>
</head>
<body>
	<h2>자유게시판</h2>
	 <hr />
	 번호 :  <%= board.getNo() %><br>
	 글쓴이 : <%= board.getWriter() %><br>
	 제목 : <%= board.getTitle() %><br>
	 내용 : <%= board.getContent() %><br>
	 등록일 : <%= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(board.getRegDate()) %><br>  
	 조회수 : <%= board.getViewCnt() %><br>
	 <hr />
	 <a href='delete.do?no=<%=board.getNo()%>' class="button" type="button">삭제</a>
	 <a href="/08_servletjsp/servlet/board/update_form.do?no=<%=board.getNo()%>" class="button" type="button">글수정</a>
	 <a href='/08_servletjsp/servlet/board/list.do' class="button" type="button">목록</a>
</body>
</html>