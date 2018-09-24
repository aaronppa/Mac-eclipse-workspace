<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--font  -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/css/firstpage_adv.css"/>">

<title>welcome to fishbang, this is main page.</title>
</head>

<body>
	<center><div id="title">
		<h2>welcome to fishbang</h2>
	</div></center>
<!-- login html -->
<div class="form-modal">
    
    <div class="form-toggle">
        <button id="login-toggle" onclick="toggleLogin()">log in</button>
        <button id="signup-toggle" onclick="toggleSignup()">sign up</button>
    </div>

    <div id="login-form">
        <form name="loginForm" onsubmit="return doLogin()" method="post">
            <input name ="email" id="email" type="text" placeholder="Enter email or username"/>
            <input name ="password" id="password" type="password" placeholder="Enter password"/>
            <button type="button" class="btn login" onclick="doLogin()">login</button>
            <p><a href="#" onclick="showPopup()">Forgotten account</a></p>
            <hr/>
            <button type="button" class="btn -box-sd-effect naver"> <i class="fa fa-plus fa-lg" aria-hidden="true"></i> sign in with Naver</button>
            <button type="button" class="btn -box-sd-effect kakao"> <i class="fa fa-plus fa-lg" aria-hidden="true"></i> sign in with Kakao</button>
        </form>
    </div>

    <div id="signup-form">
        <form name="signupForm" onsubmit="return doSignup()" method="post">
            <input name="email" id="email" type="email" placeholder="Enter your email"/>
            <input name="name" id="name" type="text" placeholder="Choose username"/>
            <input name="password" id="password" type="password" placeholder="Create password"/>
            <button type="button" onclick="doSignup()" class="btn signup">create account</button>
            <p>Clicking <strong>create account</strong> means that you are agree to our <a href="javascript:void(0)">terms of services</a>.</p>
            <hr/>
            
        </form>
    </div>

</div>
<script src="<c:url value="/script/firstpage_adv.js"/>"></script>
	
	
	
	<!-- forgot password popup -->
	<script>
	var showPopup = () => {
	window.open("findpassword.jsp","findPass","width=480,height=450,left=100,top=50, resizable=no") 
	}
	
	
	var doLogin =  () => {
		var form = document.loginForm
		if(form.email.value==""){
			alert("Enter email or username")
			form.email.focus()
			return false
		}
		if(form.password.value==""){
			alert("Enter password")
			form.password.focus()
			return false 
		}
			
		form.action = "newmain.jsp"
		form.submit()
			
	}	
	
	var doSignup = () => {
		var form = document.signupForm
		if(form.email.value==""){
			alert("Enter your Email")
			form.email.focus()
			return false
		}
		if(form.email.value)
		
		
		if(form.name.value==""){
			alert("Enter username")
			form.email.focus()
			return false
		}
		
		if(form.password.value==""){
			alert("Enter password")
			form.password.focus()
			return false 
		}
			
		alert("회원가입이 완료되었습니다.")
		form.action = "firstpage_adv.jsp"
		form.submit()
	}
	</script>

	
</body>
</html>