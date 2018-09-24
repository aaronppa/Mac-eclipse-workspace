<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%--
 <%
 	List<Board> list = (List<Board>)request.getAttribute("list");
 %>
  --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
  src="https://code.jquery.com/jquery-3.3.1.js"
  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous"></script>
<title>EL JSTL - 자유게시판: 상세조회</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<style>
	div.container{
	margin-bottom: 50px;
	}
	
	th{
		background-color: #3166EC;
		color: white;
	}
	
	td{
		text-align: center;
	}
	
	tr:hover{
		font-weight: bold;
	}
	
</style>
<c:import url="/jsp/common/basicIncludeCss.jsp" />
<c:import url="/jsp/common/menubar.jsp" />
</head>

<body>
<main role="main">
<div class="container">
	<!-- 게시물 목록 표현하기 -->
	<h2>자유게시판</h2>
	<hr>
	<table class="table table-hover">
	<tr>
		<th>번호</th><th>제목</th><th>글쓴이</th><th>작성일</th><th>조회수</th>
	</tr>

	<c:forEach var="b" items="${list}">
	
	<tr class='clickable-row' data-href='<c:url value='/servlet/eljstlboard/content_detail.do' />?no=${b.no}'>
		<td>${b.no}</td>
		<td><c:out value="${b.title}"/>s</td>
		<td><c:out value="${b.writer}" /></td>
		<td><fmt:formatDate value="${b.regDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		<td>${b.viewCnt}</td>
	</tr>	
	</c:forEach>
	</table>
	<hr>
	<button class="btn btn-primary btn-dark btn-lg" id="write-content">글쓰기</button>
	</div> 
</main>
<script>
	$("button#write-content").click( function (){window.location.href = "<c:url value="/eljstl/board/writeForm.jsp" />"
	})
	
    $(".clickable-row").click(function() {
        window.location = $(this).data("href");
    });
</script>	  
</body>
</html>