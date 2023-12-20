<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>pettoo 로그인</title>
<style>
.first {margin: 140px auto 0;  width: 20%;}
.first img {width: 100%;}
.login-wrap { margin: 20px auto; width: 18%; text-align: center; position: relative;}
.login-wrap .login input {
  border: 2px solid white;
  background: #F2F2F2;
  width: 100%;
  font-size: 20px;
  padding: 10px 0px 10px 10px;
}
.button-wrap .login {
  width: 52%;
  padding: 10px 20px;
  background: #548235;
  color: white;
  font-weight: 900;
  font-family: Gong Gothic OTF;
  font-size: 20px;
  border: none;
  position:absolute;
  line-height: 30px;
  left:0;
  bottom:-60px;
}
.button-wrap .join {
  width: 52%;
  padding: 10px 20px;
  background: #FFFF00;
  color: black;
  font-weight: 900;
  font-family: Gong Gothic OTF;
  font-size: 20px;
  border: none;
  position:absolute;
  line-height: 30px;
  right:-12px;
  bottom:-60px;
}
.button-wrap .login:hover {
  background-color: #385723 !important;
}
</style>

<script>
function login() {
	if (logForm.userId.value == "") { //아이디 입력 안했을 시
		alert("아이디를 입력하세요.");
		logForm.userId.focus();
		return false;
	}
	if (logForm.userPw.value == "") { //비번 입력 안했을 시
		alert("비밀번호를 입력하세요.");
		logForm.userPw.focus();
		return false;
	}
	logForm.submit();
	console.log("전송됨");
}
function userCreate(targetUri) {
	logForm.action = targetUri;
	logForm.method = "GET";
	logForm.submit();
}
</script>
</head>
<body>

<div class="login_main">
	<div class="first">
		<img src="<c:url value='/images/login1.png' />" />
	</div>
	<!-- login form -->
	<form class="login-wrap" name="logForm" method="POST" action="<c:url value='/user/login' />" >
		<div class="login">
			<input type="text" name="userId" placeholder="ID">
		</div>
		<div class="login">
			<input type="password" name="userPw" placeholder="PW">
		</div>
		<div class="button-wrap">
			<input type="button" value="로그인" class="login" onclick="login()">
			<input type="button" value="회원가입" class="join" onclick="userCreate(
										'<c:url value='/user/register'/>')">
		</div>
	</form>
</div>
</body>