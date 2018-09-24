<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자유게시판: 게시글 쓰기</title>
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
	<h2>자유 게시판</h2>
	<hr>
	<form action="<c:url value="/servlet/eljstlboard/write.do" />" 
		  method="POST" 
		  enctype="multipart/form-data" 
	>
	<div>
		제목 : <input type="text" name="title" />
	</div>
	<div>
		작성자 : <input type="text" name="writer" value="${id.id}" readonly />
	</div>
	<div>
		내용 : 
		<textarea name="content" rows="8" cols="70"></textarea>
	</div>
	<div>
		<input type="file" name="attach1" />
	</div>
	<div>
		<input type="file" name="attach2" />
	</div>
	<div>
		<input type="file" name="attach3" />
	</div>
	<div>
		<input type="file" name="attach4" />
	</div>
	<div>
		<input type="file" name="attach5" />
	</div>
	<div>
	<hr>
	<input class="button" type="submit" value="등록"/>
	<a href="/08_servletjsp/servlet/eljstlboard/list.do" class="button" type="button">목록</a>
	</div>
	</form>
</body>
</html>