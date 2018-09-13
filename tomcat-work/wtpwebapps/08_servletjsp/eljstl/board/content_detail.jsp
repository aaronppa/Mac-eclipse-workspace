<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%--
   <%
   		Board board = (Board)request.getAttribute("board");
   %>
    --%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL JSTL - 자유게시판: 글상세 조회</title>
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
	table > tr:first-child > th:nth-child(2){
		width: 400px;
	}
	input.writer{
		width: 400 px;
	}
</style>
<c:import url="/jsp/common/basicIncludeCss.jsp" />
</head>

<c:import url="/jsp/common/menubar.jsp" />
<body>
	<h2>자유게시판</h2>
	 <hr />
	 번호 :  <c:out value="${board.no}" /><br>
	 글쓴이 : <c:out value="${board.writer}" /><br>
	 제목 : <c:out value="${board.title}" /><br>
	 내용 : <c:out value="${board.content}" /><br>
	 등록일 : <fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd HH:mm:ss" />
	 <br>  
	 조회수 : ${board.viewCnt}<br>
	 <hr />
	 <c:forEach var="afl" items="${attFileList}">
	<div>
	<img src="<c:url value="/common/file/download?name=${afl.fileSysName}&path=${afl.filePath}"/>" width="500px" />
	</div>
	 <a href="<c:url value="/common/file/download?name=${afl.fileSysName}&path=${afl.filePath}"/>">보여주기</a>
     <a href="<c:url value="/common/file/download?name=${afl.fileSysName}&path=${afl.filePath}&dname=${afl.fileOriName }"/>">다운로드</a>
     </c:forEach>
     <hr/>
     
     <form action="<c:url value="/servlet/eljstlboard/write_comment.do"/>" method="post">
     <input type="hidden" name="no" value="${board.no}" />
     <div>
     	<table>
     	<tr>
     		<th>댓글 작성자</th>
     		<th width="400px">댓글 내용</th>
     		<th></th>
     	</tr>
			<tr>
				<td><input class="writer" type="text" name="writer"	value="${id.id}" readonly /></td>
				<td><input class="comment" type="text" name="comment" size="100" required/></td>
				<td><input class="button" type="submit" value="댓글 등록"/></td>
			</tr>
		</table>
     </div>	
     </form>
     <hr/>
     
     	<table>
     	<tr>
     		<th>댓글 작성자</th>
     		<th width="400px">댓글 내용</th>
     		<th colspan="2"></th>
     	</tr>
     <c:forEach var="commlist" items="${commList}">
			<tr>
				<td style="width: 200px;">${commlist.writer}</td>
				<td style="width: 700px;">${commlist.content}</td>
				<td style="width: 50px;"><a href="#">수정</a></td>
				<td style="width: 50px;"><a href="#">X</a></td>
			</tr>
     </c:forEach>
		</table>
	 <hr/>
	 <a href='delete.do?no=${board.no}' class="button" type="button">삭제</a>
	 <a href="<c:url value="/servlet/eljstlboard/update_form.do?no=${board.no}" />" class="button" type="button">글수정</a>
	 <a href='/08_servletjsp/servlet/eljstlboard/list.do' class="button" type="button">목록</a>
</body>
</html>