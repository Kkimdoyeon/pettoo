<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='../css/main.css' />" type="text/css">
<title>MY PAGE</title>
<style>
.content {
		width: 70%;
		margin: 0 auto;
		display: flex;
		justify-content:center;
		position: relative;
	}
.tit {
	width: 70%;
	margin: 250px auto 0;
}
.tit .label-wrap {width:18%;}
.tit .input-wrap {width: 100%;}
.button-wrap {
	width: 100%;
	position: relative;
	justify-content:center;
	margin: 0 auto;
}
.button-wrap .upload  {
  width: 200px;
  padding: 10px 20px;
  background: #548235;
  color: white;
  font-weight: 900;
  font-family: Gong Gothic OTF;
  font-size: 20px;
  position:absolute;
  line-height: 30px;
  bottom:-60px;
  right: calc(50% - 100px);
  border: 0;
}
.button-wrap .upload:hover {
  background-color: #385723 !important;
}
.input-item { 
  display: flex;
  width: 90%;
  margin-bottom: 20px;
  align-items: center;
  position: relative;
} 
.right .input-item { 
  width: 90%;
  margin-bottom: 20px;
} 
.label-wrap { 
  width: 30%;
  text-align: left;
}
.right .label-wrap {
	text-align: center;
	position: relative;
}
.left, .right {
	width: 50%;
}

.label-wrap p { 
color: black;
font-size: 20px;
font-style: normal;
font-weight: 500;
line-height: 40px; /* 200% */
}

.diary{margin: 250px auto 0;} 

.input-wrap {width: 70%;}
select {width: 100; padding: 10px 20px; font-size: 20px;  background: #F2F2F2;}
.input-wrap input {
  border: 2px solid #F2F2F2;
  background: #F2F2F2;
  width: 100%;
  font-size: 20px;
  padding: 10px 20px;
  color: black;
}
.input-wrap input:focus {
  outline: none !important;
  border: 2px solid #548235 !important;
}
textarea { 
  border: 2px solid #F2F2F2;
  background: #F2F2F2;
  width: 100%;
  font-size: 20px;
  padding: 10px 20px;
  resize: none;
  height: 220px;
  color: white;
}
textarea:focus {
  outline: none !important;
  border: 2px solid var(--bluegreen, #00C3A0) !important;
}
</style>
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
                                <a href="../friend/find.jsp">FRIEND</a>
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
<form class="diary" id="diaryForm">
<div class="tit">
<div class="input-item">
	<div class="label-wrap"><p>제목</p></div>
    <div class="input-wrap"><input type="text" ></input></div>
</div>
</div>
<div class="content">
<div class="left">
<div class="input-item">
	<div class="label-wrap"><p>장소</p></div>
    <div class="input-wrap"><input type="text" ></input></div>
</div>
<div class="input-item">
	<div class="label-wrap"><p>날짜</p></div>
    <div class="input-wrap"><input type="date" name="diaryDate"></input></div>
</div>
<div class="input-item">
	<div class="label-wrap"><p>산책시간</p></div>
	<div class="input-wrap">
		<select name="walkingTime">
	  		<option value="30">30min</option>
	  		<option value="60">1h</option>
  			<option value="90">1h 30min</option>
  			<option value="120">2h</option>
  			<option value="150">2h 30min</option>
  		</select>
  	</div>
</div>
<div class="input-item"> 
	<div class="label-wrap"><p>사진</p></div> 	
	<div class="input-wrap"><input type="file" name="petPhoto"></div>
</div>
</div>

<div class="right">
<div class="input-item">
	<div class="label-wrap"><p>메모</p></div>
    <div class="input-wrap"><textarea name="contact_desc" ></textarea></div>
</div>
</div>
</div>
<div class="button-wrap">
	<input type="button" value="UPLOAD" class="upload" onclick="goToMyPage()">
</div>

</form>
</body>
<script>
// JavaScript 코드
function goToMyPage() {
    // 폼 요소 선택
    var form = document.getElementById("diaryForm");

    // FormData 객체 생성하여 폼 데이터 수집
    var formData = new FormData(form);

    // URL 생성 및 데이터 전송
    alert('업로드 되었습니다');
}
</script>
</html>