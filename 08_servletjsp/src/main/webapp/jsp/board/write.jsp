<%@page import="kr.teamfive.repository.domain.Board"%>
<%@page import="kr.teamfive.common.db.MyAppSqlConfig"%>
<%@page import="kr.teamfive.repository.mapper.BoardMapper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    	// Post 방식일 경우 파라미터 한글 처리
    	request.setCharacterEncoding("utf-8");
    	
    	// 사용자 전송 파라미터 꺼내기 
    	String title = request.getParameter("title");
    	String writer = request.getParameter("writer");
    	String content = request.getParameter("content");
    	
    	// 파라미터를 데이터 베이스 처리를 위한 매퍼에게 넘긴다. 
    	BoardMapper mapper = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardMapper.class);
    	
    	Board board = new Board();
    	board.setTitle(title);
    	board.setWriter(writer);
    	board.setContent(content);
    	
    	mapper.insertBoard(board);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="1; url=listjsp.jsp">
<title>Insert title here</title>
</head>
<body>
	<h1>게시물이 작성되었습니다.</h1>
</body>
</html>