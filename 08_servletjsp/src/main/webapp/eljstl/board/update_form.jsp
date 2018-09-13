<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
<%
	Board board = (Board)request.getAttribute("board");
%>
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL JSTL - 자유게시판: 게시글 수정</title>
<style>
	.button{
		background-color: #353276;
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
<c:import url="/jsp/common/basicIncludeCss.jsp" />
</head>

<body>
<c:import url="/jsp/common/menubar.jsp" />
	<h2>자유게시판: 글수정</h2>
	<hr>
	<form action="<c:url value="/servlet/eljstlboard/update.do" />" method="POST">
	<div>
	 <input type="hidden" name="no" value="${board.no}" />
	</div>
	<div>
		제목 : <input type="text" name="title" value="${board.title}" />
	</div>
	<div>
		내용 : 
		<textarea name="content" rows="8" cols="70">${board.content}</textarea>
	</div>
	<hr>
	<button class="button" type="submit">수정등록</button>
	<a href="content_detail.do?no=${board.no}" class="button" type="button">수정취소</a>
	</div>
	</form>
</body>
</html>