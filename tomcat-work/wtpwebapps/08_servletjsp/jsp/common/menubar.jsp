<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://cdn.rawgit.com/VPenkov/okayNav/master/app/js/jquery.okayNav.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
   <style>
       .fas.fa-fish{
           color: coral;
       }
   </style>

<header id="header">
  <a class="site-logo" href="#">
            <i class="fas fa-fish fa-2x "></i>
        </a>

  <nav role="navigation" id="nav-main" class="okayNav loaded">
    <ul class="okayNav__nav--visible">
      <c:choose>
	      <c:when test="${empty id}">
		      <li><a href="<c:url value="/login/login-form.do" />">로그인</a></li>
	      </c:when>
      <c:otherwise>
	      <li><a href="#">Home</a></li>
	      <li><a href="http://localhost:8000/08_servletjsp/servlet/eljstlboard/list.do">Board</a></li>
	      <li><a href="<c:url value="/login/logout.do" />">로그아웃</a></li>
      </c:otherwise>
      </c:choose>
    </ul>
  </nav>
</header>
<!-- /header -->
<script>
	var navigation = $('#nav-main').okayNav();	
</script>
