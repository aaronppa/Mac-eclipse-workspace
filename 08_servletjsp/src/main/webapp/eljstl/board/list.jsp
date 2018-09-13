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
<title>EL JSTL - 자유게시판: 상세조회</title>
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
	
	td{
		text-align: center;
	}
</style>
<c:import url="/jsp/common/basicIncludeCss.jsp" />
</head>

<body>
<c:import url="/jsp/common/menubar.jsp" />
	<!-- 게시물 목록 표현하기 -->
	<h2>자유게시판</h2>
	<hr>
	<table>
	<tr>
		<th>번호</th><th>제목</th><th>글쓴이</th><th>작성일</th><th>조회수</th>
	</tr>

	<c:forEach var="b" items="${list}">
	
	<tr>
		<td>${b.no}</td>
		<td><a href="<c:url value='/servlet/eljstlboard/content_detail.do' />?no=${b.no}"><c:out value="${b.title}"/></a></td>
		<td><c:out value="${b.writer}" /></td>
		<td><fmt:formatDate value="${b.regDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		<td>${b.viewCnt}</td>
	</tr>	
	</c:forEach>
	</table>
	<hr>
	<a href="<c:url value="/eljstl/board/writeForm.jsp" />" class="button" type="button">글쓰기</a> 
</body>
</html>