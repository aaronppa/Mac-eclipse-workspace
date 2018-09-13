<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test01.jsp</title>
</head>
<body>
	<h1>one.jsp 페이지 포함하기</h1>
	<%-- 
	one.jsp 내용을 포함시키기 위해 include 지시자 사용.
	지시자 인클루드 방식 : test.jsp 페이지가 서블릿으로 변경될 때 one.jsp 파일의 내용을 같이 포함시켜서 만든다. 
	               : 선언된 변수를 같이 사용할 수 있다.
	               : 인클루드시 파라미터 전송이 안된다.
	                 ex> one.jsp?no=1
	
	
	include : 페이지 포함기술 : 내 페이지 안에서 다른 페이지를 부를 때
	            https://land.naver.com/community/
                ex> 네이버 상위 메뉴단, 하단 은 변하지 않고 중간 부분만 바뀐다.
		           각각의 파일마다 공통의 코드를 추가하지 말고
                           공통으로 쓰이는 코드를 별도의 코드로 만든다.
		     inculde로 이 코드를 가져와서 적용한다.
		     html 태그와 같은 것들은 제외하고 처리할 내용만 가짐.
		     
		   ( 정적??) include : 소스 자체를 가져온다.
		     동적 인클루드 : 실행결과만을 가져온다.
		  

forward : 페이지 이동기술
	
	
	--%>
	<%@include file="one.jsp" %>
	<hr>
	one.jsp 호출 끝난 뒤...
	<hr>
	msg: <%=msg %> <br>
	msg2: ${msg}
	<%-- <%@include file="one.jsp?no=1" %>   --%>
</body>
</html>