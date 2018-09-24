<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/css/updateuser.css"/>">
</head>
<body>
	<h1>회원정보수정 페이지 입니다</h1>
	<div class="settings-message" id="js-message"></div>
	<form action="#" method="post" encType="multipart/form-data">
		<input id="js-file-uploader" class="hidden" name="profile-picture"
			type="file" accept="image/png, image/jpeg" />

		<div id="js-profile-pic" class="profile-pic__container">
			사진을 등록해주세요
			<div id="js-profile-trigger" class="profile-pic__foreground">profile
				picture</div>
		</div>

		<div class="input__container">
			<div class="input-container__single">
				<label for="id">ID:</label> <input type="text"
					placeholder="fishbang@fish.bang" disabled name="id" id="id" />
			</div>
			<div class="input-container__single">
				<label for="name">Name:</label> <input type="text" placeholder="홍길동"
					disabled name="name" id="name" />
			</div>

			<div class="input-container__single">
				<label for="js-password">Password:</label> <input type="password"
					required id="js-password" name="password"
					placeholder="변경할 비밀번호를 입력하세요" /> <span id="js-toggle-password"
					class="input-action">Display Password</span>
			</div>
			<div class="input-container__single">
				<label for="js-password-confirm">Confirm Password:</label> <input
					type="password" required id="js-password-confirm"
					name="confirm-password" placeholder="비밀번호를 다시 입력하세요" /> <span
					class="input-action" id="js-suggest-password"></span>
			</div>

			<div class="input-container__single">
				<label for="contact">Contact:</label> <input type="text"
					name="contact" id="contact" />
			</div>

			<div class="input-container__single">
				<label for="birth">Birth:</label> <input type="date" name="mydate"
					value="2018-08-28" min="1950-01-01" max="2018-10-04" />
			</div>


		</div>

		<div>
			<input type="submit" value="Save Profile" /> <input type="button"
				value="Cancel"
				onclick="location.href='<c:url value="/jsp/newmain.jsp"/>'" />
		</div>

	</form><!--  form end  -->

	<script src="<c:url value="/script/updateuser.js"/>"></script>
</body>
</html>