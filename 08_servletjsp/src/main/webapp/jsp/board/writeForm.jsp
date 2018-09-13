<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 쓰기</title>
</head>
<body>
	<h2>자유 게시판</h2>
	<hr>
	<form action="write.jsp" method="POST">
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
	<button>등록</button>
	<a href="list.jsp">목록</a>
	</form>
</body>
</html>