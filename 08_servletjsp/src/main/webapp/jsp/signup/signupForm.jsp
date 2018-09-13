<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sign Up Form</title>
</head>
	<link rel="stylesheet" href="signup-form-style.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">    
<body>
	<div class="box">
		<h1>SIGN-UP</h1>
		<form method="post" action="<c:url value="/jsp/signup/signup.do"/>">
			<i class="fa fa-user icon" aria-hidden="true"></i> 
			<input type="text" placeholder=" Enter your name" required name="name"><br> 
			<i class="fa fa-envelope icon" aria-hidden="true"></i> 
			<input type="email" placeholder=" Enter your Email(User ID)" name="id" required><br />
			<i class="fa fa-phone icon" aria-hidden="true"></i> 
			<input type="text" placeholder=" Enter your phone number"><br /> 
			<i class="fa fa-lock icon" aria-hidden="true"></i> 
			<input type="password" placeholder="Enter your Password" name="password" required><br />
			<i class="fa fa-lock icon" aria-hidden="true"></i> 
			<input type="password" placeholder="Re-type Password" name="repassword" required>
			<button type="submit">Submit</button>
		</form>
	</div>


</body>
</html>