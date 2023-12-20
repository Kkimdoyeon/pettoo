<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>pettoo 회원가입</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<style>

</style>

<script>
function userCreate() {
	if (joinForm.userId.value == "") {
		alert("사용자 ID를 입력하시오.");
		joinForm.userId.focus();
		return false;
	}
	if (joinForm.userPw.value == "") {
		alert("비밀번호를 입력하시오.");
		joinForm.userPw.focus();
		return false;
	}
	if (joinForm.userPw2.value == "") {
		alert("비밀번호를 다시 한번 입력하시오.");
		joinForm.userPw2.focus();
		return false;
	}
	if (joinForm.userPw.value != joinForm.userPw2.value) {
		alert("비밀번호가 일치하지 않습니다.");
		joinForm.userPw.focus();
		return false;
	}
	if (joinForm.userName.value == "") {
		alert("이름을 입력하시오.");
		joinForm.userName.focus();
		return false;
	}
	if (joinForm.address.value == "") {
		alert("주소를 입력하시오.");
		joinForm.address.focus();
		return false;
	}
	if (joinForm.gender.value == "") {
		alert("성별을 선택하시오.");
		joinForm.gender.focus();
		return false;
	}
	var emailExp = /^[A-Za-z-0-9_\.\-]+@[A-Za-z-0-9_\.\-]+\.[A-Za-z-0-9_\.\-]+/;
	if (emailExp.test(joinForm.email.value) == false) {
		alert("이메일 형식이 올바르지 않습니다. ");
		joinForm.email.focus();
		return false;
	}
	var phoneExp = /^\d{2,3}-\d{3,4}-\d{4}$/;
	if (phoneExp.test(joinForm.phoneNumber.value) == false) {
		alert("전화번호 형식이 올바르지 않습니다.");
		joinForm.phoneNumber.focus();
	}
	if (joinForm.userBirth.value == "") {
		alert("생일을 입력하시오.");
		joinForm.userBirth.focus();
		return false;
	}
	if (joinForm.petId.value == "") {
		alert("반려동물 아이디를 입력하시오.");
		joinForm.address.focus();
		return false;
	}
	alert("회원가입이 완료되었습니다.");
	joinForm.submit();
}
function goBack() {
    window.location.href = "<c:url value='/user/login/form'/>";
  }
</script>
</head>

<body>
<form name="joinForm" action="<c:url value='/user/login/form' />" method="POST">
<table>
	<tr>
		<td height="100" colspan=2><img src="<c:url value='/images/logo.png' />" width="300" height="100" alt="로고" /></td>
		<td><span style="font-size:400%">|</span></td>
		<td><span style="font-size:200%">회원가입</span></td>
	</tr>
	<tr>
		<td height="50">아이디</td>
		<td colspan=3><input type="text" name="userId"></td>
	</tr>
	<tr>
		<td height="50">비밀번호</td>
		<td colspan=3><input type="password" name="userPw"></td>
	</tr>
	<tr>
		<td height="50">비밀번호 확인</td>
		<td colspan=3><input type="password" name="userPw2"></td>
	</tr>
	<tr>
		<td height="50">이름</td>
		<td colspan=3><input type="text" name="userName"></td>
	</tr>
	<tr>
		<td height="50">주소</td>
		<td colspan=3><input type="text" name="address"></td>
	</tr>
	<tr>
		<td height="50">성별</td>
		<td colspan=3><input type="radio" name="gender" value="man">남
		<input type="radio" name="gender" value="woman">여</td>
	</tr>
	<tr>
		<td height="50">이메일</td>
		<td colspan=3><input type="email" name="email"></td>
	</tr>
	<tr>
		<td height="50">전화번호('-'포함하여 입력)</td>
		<td colspan=3><input type="tel" name="phoneNumber"></td>
	</tr>
	<tr>
		<td height="50">생일</td>
		<td colspan=3><input type="date" name="userBirth" min="1950-01-01" max="2023-12-31"></td>
	</tr>
	<tr>
		<td height="50">펫 아이디</td>
		<td colspan=3><input type="text" name="petId"></td>
	</tr>
	<tr>
		<td colspan=4>
			<input type="button" value="회원가입" onClick="userCreate()"> &nbsp;
			<input type="button" value="돌아가기" onClick="goBack()">
		</td>
	</tr>
</table>
</form>
</body>
</html>