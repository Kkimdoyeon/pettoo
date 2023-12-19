<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PRORILE</title>
</head>
<body>
<div class="front-bar">
                    <nav>
                        <a class="logo">
                            <img width="280" height="100"  src="../img/logo.png"/>
                        </a>
                        <div class="menu">
                        <ul>
                            <li class="sc-76e69317-0 kvRpqN nav-menu">
                                <a href="myPage.jsp" style="color: #647B54;">MY PAGE</a>
                            </li>
                            <li class="sc-76e69317-0 kvRpqN nav-menu">
                                <a href="profile.jsp">PROFILE</a>
                            </li>
                            <li class="sc-76e69317-0 kvRpqN nav-menu">
                                <a href="../community/list.jsp">COMMUNITY</a>
                            </li>
                            <li class="sc-76e69317-0 kvRpqN nav-menu">
                                <a href="../map/search.jsp">MAP</a>
                            </li>
                        </ul>
                        </div>
                    </nav>
</div>
<div class="myProfile">
<form name="myForm" action="profile.jsp" method="POST">
<table>
	<tr>
		<td colspan=4><span style="font-size:200%">회원 정보 수정</span></td>
	</tr>
	<tr>
		<td height="50">아이디</td>
		<td colspan=3><input type="text" name="userId" readonly></td>
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
			<input type="button" value="돌아가기" onClick="loginForm('/user/loginFrom.jsp')">
		</td>
	</tr>
</table>
</form>
</div>
</body>
</html>