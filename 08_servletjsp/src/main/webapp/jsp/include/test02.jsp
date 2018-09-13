<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test02.jsp</title>
</head>
<body>
	<h1>동적인 include 사용하기</h1>
	<hr>
	<jsp:include page="two.jsp"/>
	<%-- 
		  액션 인클루드(jsp:include page)
	     - 실행된 결과를 가져와서 합치는 방식 
	     - two.jsp 페이지에 있는 선언된 변수를 사용할 수 없음.
	       ex> 	msg: <%=msg %>
	     - 파라미터 전송이 가능하다. 	
	     	파라미터 전송은 권장하지 않는 편이다.
	--%>

	two.jsp 호출 끝난 뒤...
	<hr>
	<!-- 
	<jsp:include page="two.jsp?no=100"/>
	 -->
	<hr>
	<jsp:include page="two.jsp">
		<jsp:param name="no" value="999"/>
	</jsp:include>

</body>
</html>