<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="main-login-signup-style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Welcome to FishBang</title>
<c:import url="/jsp/common/basicIncludeCss.jsp" />
</head>

<body>
<c:import url="/jsp/common/menubar.jsp" />
	<div class="box">
		<h1>Welcome to FishBang</h1>
		<form action="<c:url value ='/jsp/login/login.do'/>" method="post">
			<i class="fa fa-user icon" aria-hidden="true"></i> 
			<input type="email" placeholder=" Enter your Email" name="id" required><br> 
			<i class="fa fa-lock icon" aria-hidden="true"></i> 
			<input type="password" placeholder="Enter your password" name="password" required><br />
			<button type="submit">Log In</button>
		</form>
		<br>
		<div class="login-signup">
			Don't have an account? <br>
		<a href="<c:url value="/jsp/signup/signup-form.do"/>">Sign Up</a>
		</div>
	</div>
</body>
</html>