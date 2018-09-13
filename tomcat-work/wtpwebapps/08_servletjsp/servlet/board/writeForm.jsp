<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자유게시판: 게시글 쓰기</title>
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
	<h2>자유 게시판</h2>
	<hr>
	<form action="/08_servletjsp/servlet/board/update.do" method="POST">
	<div>
		제목 : <input type="text" name="title" />
	</div>
	<div>
		작성자 : <input type="text" name="writer" />
	</div>
	<div>
		내용 : 
		<textarea name="content" rows="8" cols="70"></textarea>
	</div>
	<hr>
	<input class="button" type="submit" value="등록"/>
	<a href="list.jsp" class="button" type="button">목록</a>
	</div>
	</form>
</body>
</html>