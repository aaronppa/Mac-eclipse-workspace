<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous"> <!-- fontawesome logo -->
<link href="https://fonts.googleapis.com/css?family=Shadows+Into+Light"
	rel="stylesheet">
<link rel="stylesheet" href="<c:url value="/project/css/project_topmenu.css"/>">
<!-- google font -->
<style>
* {
	 font-family: 'Shadows Into Light', cursive;	
	 font-size :24px;
	 font-weight:bold;
}
nav{
	width:100%
	height:50px;
	
}
</style>
<title>top menu</title>
</head>
<body>
	<!-- Top Menu bar Navigation -->
	<nav class="top-bar" data-topbar role="navigation">
	<ul class="title-area">
		<li class="name">
			<h1>
				<a href="<c:url value="/project/jsp/boardMainUi.jsp"/>">
				<i class="fas fa-fish"></i>&nbsp;
				FishBang</a>
			</h1> <!--title  -->
		</li>

		<li class="toggle-topbar menu-icon"><a href="#"><span>Menu</span></a></li>
	</ul>

	<section class="top-bar-section">

	<ul class="right">
		<c:if test="${not empty session.id}">
			<li class="divider"></li>
			<li><a href="#">게시글 등록</a></li>
		</c:if>
		<c:choose>
			<c:when test="${empty session.id}">
				<li class="divider"></li>
				<li><a href="login.jsp">login</a></li>
			</c:when>
			<c:otherwise>
				<li class="divider"></li>
				<li><a href="logout.do">logout</a></li>
			</c:otherwise>
		</c:choose>

		<li class="divider"></li>
		<li><a href="signup.jsp">Signup</a></li>
		<li class="divider"></li>
	</ul>
	</section> </nav>

</body>
</html>