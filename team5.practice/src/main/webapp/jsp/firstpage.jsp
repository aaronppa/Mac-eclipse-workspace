<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/css/firstpage_login.css"/>">
<!-- <link rel="stylesheet" href="<c:url value="/css/firstpage_background.css"/>"> -->
<style>


/*
body {
	background: #0B0B61
}
*/


#main {
	margin-top: 55px ;
	font-size: 3em;
	color: #C2C2C2;
}

a{
line-height:60px;
margin-left:5px;
}

/* 백그라운드 적용시 제거  ↓*/
 body{
background-image: url('../img/background.jpg'); !important;
background-size:100%;
}

 
  */
</style>
 <%-- <c:import url="/jsp/firstpage_background.jsp"/> --%>  
<title>Welcome to fishbang</title>
</head>
<body>
	<div>
	<center>
		<h1 id="main">Welcome to fishbang</h1>
	</center>
	</div>
	<!-- login form tag  -->
	<form action="#" method ="post" id ="loginForm">


	
	
	<!-- login -->
	<div class="form">
		<div class="head" class="signup">
			<div onclick="changeTab(this)" data-tab="login" class="login-tab">Login</div>
			<div onclick="changeTab(this)" data-tab="signup" class="signup-tab">Signup</div>
		</div>
		<div class="body" id="form-body">
			
		
			
			<div class="login">
			
				<div class="form-row">
					<label for="">Email</label> <input type="text" placeholder="Email">
				</div>
				<div class="form-row">
					<label for="">Password</label> <input type="password"
						placeholder="Password">
				</div>
			<!--<div class="rem-row">
					<input type="checkbox" id="rem"> <label for="rem">Remember
						me</label>
				</div> -->
				
				<div class="form-row">
					<a href="#" onclick="showPopup()" style="text-decoration:none">forgot password?</a>
				</div>
				
					<!--구현시 submit button .. -->
				<div class="form-row">
					<button type="button" onclick="location.href='newmain_board_feeds.jsp'">Login</button>
					
					
				</div>
				<div class="row">
					<span>OR</span>
				</div>
				<div class="footer">
					<div class="social-form Naver">Login with Naver</div>
					<div class="social-form Kakao">Login with Kakao</div>
				</div>
			</div>
			</form> <!-- login form end  -->
			
			
			
			
			<div class="signup">
		<form action="#" method="post" id="signupForm">
				<div class="form-row">
					<label for="">Name</label> <input type="text" placeholder="Name">
				</div>
				<div class="form-row">
					<label for="">Email</label> <input type="text" placeholder="Email">
				</div>
				<div class="form-row">
					<label for="">Password</label> <input type="password"
						placeholder="Password">
				</div>
				<div class="form-row">
					<label for="">Retype Password</label> <input type="password"
						placeholder="Password">
				</div>
				<div class="rem-row">
					<input type="checkbox" id="agr"> <label for="agr">Agree
						terms & conditions.</label>
				</div>
				<div class="form-row">
					<button onclick="location.href='firstpage.jsp'">Sign up</button>
				</div>
			</div>
		</div>
	 		</form> <!-- signup form end  -->

	</div>
	<script src="<c:url value="/script/firstpage_login.js"/>"></script>
	
	<script>
		var showPopup = () => {
			window.open("findpassword.jsp","findPass","width=480,height=450,left=100,top=50, resizable=no") 
			
		}
	</script>
	



</body>
</html>