<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/css/newmain.css"/>">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- javascript -->
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


<!-- fontawesone 로고 -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous"> 


<c:import url="rankingCss.jsp"/>
<c:import url="rankingScript.jsp"/>
<c:import url="rankingSideCss.jsp"/>


<title>Insert title here</title>
<style>
#mains{
border:1px solid tomato;
height:8000px;
}
#feedBoard{
border:1px solid blue;
width:1000px;
height:3000px;
margin-right:10px;
float:left;
display:block;
}
#side{
border:1px solid yellow;
width:355px;
height:3000px;
margin-left:1000px;

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
          <a class="navbar-brand" href="<c:url value="/jsp/newmain.jsp"/>"><span><i class="fas fa-fish fa-1x"></i></span>&nbsp;fishbang</a>	<!-- 현재 페이지 새로 고침  -->
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav navbar-user navbar-right">
          
          	<!-- 비로그인 시  -->
            <li><a href="<c:url value="/jsp/firstpage.jsp"/>"><span class="glyphicon glyphicon-plus"></span> signup</a></li>
            <li><a href="<c:url value="/jsp/firstpage.jsp"/>"><span class="glyphicon glyphicon-log-in"></span> login</a></li>
            
            <!-- 로그인 시  -->
            <li><a href="<c:url value="/jsp/updateuserpage.jsp"/>"><span class="glyphicon glyphicon-user"></span> fishbang@fish.bang</a></li>
            <li><a href="<c:url value="/jsp/newmain.jsp"/>"><span class="glyphicon glyphicon-log-out"></span> logout</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
<nav class="navbar-primary">
  <a href="#" class="btn-expand-collapse"><span class="glyphicon glyphicon-menu-left"></span></a>
  <ul class="navbar-primary-menu">
    <li>
      <a href="#"><span class="glyphicon glyphicon-book"></span><span class="nav-label">내어장보기(로그인)</span></a>
      <a href="#"><span class="glyphicon glyphicon-book"></span><span class="nav-label">어류도감(비회원)</span></a>
      <a href="#"><span class="glyphicon glyphicon-tint"></span><span class="nav-label">날씨,물때정보(opt)</span></a>
      <a href="#"><span class="glyphicon glyphicon-thumbs-up"></span><span class="nav-label">조과랭킹</span></a>
      <a href="#"><span class="glyphicon glyphicon-question-sign"></span><span class="nav-label">고객센터(opt)</span></a>

    </li>
  </ul>
</nav>
<div class="main-content">

 <div id="mains">
  	<div id="feedBoard">
  		<c:import url="rankingIllustratedBook.jsp"/>
  	</div>
  	
  	<div id="side">
  		<c:import url="sideRankingIlustratedBook.jsp"/>
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