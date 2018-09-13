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
<title>자유게시판: 게시글 수정</title>
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
	<h2>자유게시판: 글수정</h2>
	<hr>
	<form action="/08_servletjsp/servlet/board/update.do" method="POST">
	<div>
	 <input type="hidden" name="no" value="<%=board.getNo()%>" />
	</div>
	<div>
		제목 : <input type="text" name="title" value="<%=board.getTitle()%>" />
	</div>
	<div>
		내용 : 
		<textarea name="content" rows="8" cols="70"><%=board.getContent()%></textarea>
	</div>
	<hr>
	<button class="button" type="submit">수정등록</button>
	<a href="content_detail.do?no=<%=board.getNo()%>" class="button" type="button">수정취소</a>
	</div>
	</form>
</body>
</html>