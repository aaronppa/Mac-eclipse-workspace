<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/css/newmain.css"/>">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">

<!-- javascript -->
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


<title>Insert title here</title>
<style>
#mains{
border:1px solid tomato;
height:8000px;
}
#feedBoard{

width:1000px;
height:3000px;
margin-right:10px;
float:left;
display:block;
}
#side{

width:355px;
height:3000px;
margin-left:1000px;
}

 .line{
 background-color:#FCFCFC;
 
 
  width: 900px;
        height: 2800px;
      border-bottom: 2px solid #72655F;
      border-right: 2px solid #72655F;
      border-left: 2px solid #72655F;
       margin-top: -20px;
        margin-right: 5%;
        margin-left: 5%;
 }
 
 
 
 
 
.fishinfolayout{
border-radius:10px;
background-color : white;
margin-top : 70px;
border: 1px solid black;
width: 200px;
height: 230px;
 list-style: none;/* <!--li블록의 점모양 없애줌--> */
 float: left; /*li블록 가로로 나열해줌  */
}
.fishinfoline{

border: 1px solid black;
	width: 190px;
	height: 229px;
	margin: auto;
}
.fishimg{

border: 1px solid black;
width : 188px;
height : 150px;
}
.fishname1{
font-family: 'Noto Sans KR', sans-serif;
font-weight: bold;
color: gray;

border: 1px solid black;
width: 188px;
height: 40px;
text-align: center;
}

.fishviewcnt{
font-family: 'Noto Sans KR', sans-serif;
font-weight: bold;
color: gray;


text-align: center;
border: 1px solid black;
width: 188px;
height: 20px;


}

.just{
margin-top : 8.7px;

}















ul.tabs {

width: 803px;
height: 80px;
margin-left : 50px;
margin-bottom : -10px;
list-style: none;
overflow: hidden;
padding: 0;
}
ul.tabs li {
float: left;
width: 190px;

}
ul.tabs li a {
position: relative;
display: block;
height: 70px;
margin-top: 40px;
padding: 10px 0 0 0;
font-size: 18px;
text-align: center;
text-decoration: none;
color: #444;
background: #FCFCFC;
-webkit-box-shadow: 8px 12px 25px 2px rgba(0,0,0,0.4);
-moz-box-shadow: 8px 12px 25px 2px rgba(0,0,0,0.4);
-box-shadow: 8px 12px 25px 2px rgba(0,0,0,0.4);
border: 0px solid #000;
-webkit-transition: padding 0.2s ease, margin 0.2s ease;
-moz-transition: padding 0.2s ease, margin 0.2s ease;
-ms-transition: padding 0.2s ease, margin 0.2s ease;
-o-transition: padding 0.2s ease, margin 0.2s ease;
transition: padding 0.2s ease, margin 0.2s ease;
}

.tabs li:first-child a {
  z-index: 5
-webkit-border-top-left-radius: 8px;
-moz-border-radius-topleft: 8px;
border-top-left-radius: 8px; 
}

ul.tabs li a:hover {
  margin: 35px 0 0 0;
  padding: 10px 0 5px 0;
}
ul.tabs li a.activeTab {
margin: 30px 0 0 0;
padding: 10px 0 10px 0;
color: #444;
background: #FCFCFC;
border-top: 2px solid #72655F;
border-right: 2px solid #72655F;
border-left: 2px solid #72655F;
z-index: 6;
outline: none;
}



</style>
</head>
<body>
 <nav class="navbar navbar-inverse navbar-global navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">fishbang</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav navbar-user navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> 로그인시 id 표기 </a></li>
            <li><a href="#about"><span class="glyphicon glyphicon-log-in"></span> login</a></li>
            <li><a href="#about"><span class="glyphicon glyphicon-log-out"></span> logout</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
<nav class="navbar-primary">
  <a href="#" class="btn-expand-collapse"><span class="glyphicon glyphicon-menu-left"></span></a>
  <ul class="navbar-primary-menu">
    <li>
      <a href="#"><span class="glyphicon glyphicon-book"></span><span class="nav-label">내어장보기(로그인시)</span></a>
      <a href="#"><span class="glyphicon glyphicon-book"></span><span class="nav-label">어류도감(비로그인)</span></a>
      <a href="#"><span class="glyphicon glyphicon-tint"></span><span class="nav-label">날씨,물때정보(option)</span></a>
      <a href="#"><span class="glyphicon glyphicon-thumbs-up"></span><span class="nav-label">조과랭킹</span></a>
      <a href="#"><span class="glyphicon glyphicon-question-sign"></span><span class="nav-label">고객센터(option)</span></a>

    </li>
  </ul>
</nav>
<div class="main-content">	

 <div id="mains">
  	<div id="feedBoard">
  	
 <ul class="tabs group">
    <li>
           <a class="tabOne switch" href="#">전체보기</a>
    </li>
    <li>
            <a class="tabTwo switch activeTab" href="#">바다고기</a>
    </li>
    <li>
             <a class="tabThree switch" href="#">민물고기</a>
      </li>
 
 </ul>
 
 

 
 
 
 
 
 
 	<div class = "line">
  	
  
  	
  	<div class ="contentlineass">
  <ul class = "v">
  
<li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 
  
  	
  </ul>
  <ul class = "contentline">
  
<li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 
  
  	
  </ul>
  <ul class = "contentline">
  
<li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 
  
  	
  </ul>
  <ul class = "contentline">
  
<li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 
  
  	
  </ul>
  <ul class = "contentline">
  
<li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 
  
  	
  </ul>
  <ul class = "contentline">
  
<li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 
  
  	
  </ul>
  <ul class = "contentline">
  
<li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 
  
  	
  </ul>
  <ul class = "contentline">
  
<li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 
  
  	
  </ul>
  <ul class = "contentline">
  
<li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 <li class ="fishinfolayout">
  	<div class = "fishinfoline">
  	
  		<div class = "fishimg">
  		<img src = "/team5/src/main/resources/godonga1.png" width = "185" height = "150" alt = "이미지파일이어딨지?">
  		</div>
  				<div class = "just">
  					<p class = "fishname1">고등어<br>godonga</p>
  
  					<p class = "fishviewcnt">물고기과,조회수넣기</p>
  		</div>
  				</div>
 </li>
 
 
  
  	
  </ul>
  
  
 </div>


	</div>
  	
  	<div id="side"> </div>
  	
  	
  	
  	
  	
  </div>
</div>
</div>
<script>
$('.btn-expand-collapse').click(function(e) {
	$('.navbar-primary').toggleClass('collapsed');
});
</script>
</body>
</html>