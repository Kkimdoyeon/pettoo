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
		display: flex;
		width: 70%;
		margin: 250px auto;
		
		justify-content:right;
	}
	.profile {
		width: 40%;
		border-right: 1px solid #000;
	}
	.profile img {
		width: 300px;
	}
	.right {
		width: 35%;
		margin-left: 80px;
		margin-right: 40px;
	}
	    .calendar-wrap {
            background-color : white;
            height: auto;
            width: 400px;
            margin: 0px;
            padding: 40px auto;
            margin: 0 auto;
            border-radius:5px;
        }
        .button-wrap {
            margin: 0 auto;
            text-align: center;
        }

        td {
            width: 50px;
            height: 50px;
        }

        .Calendar {
            text-align: center;
            margin: 0 auto;
        }

        .Calendar>thead>tr:first-child>td {
            font-family: 'Questrial', sans-serif;
            font-size: 1.1em;
            font-weight: bold;
        }

        .Calendar>thead>tr:last-child>td {
            font-family: 'Questrial', sans-serif;
            font-weight: 600;     
        }

        .Calendar>tbody>tr>td>p {
            font-family: 'Montserrat', sans-serif;
            height: 45px;
            width: 45px;
            border-radius: 45px;
            transition-duration: .2s;
            line-height: 45px;
            margin: 2.5px;
            display: block;
            text-align: center;
        }        

        .futureDay {
            color: lightgray;
        }

        .today {
            background-color: #F5D042;            
            color: #fff;
            font-weight: 600;
            cursor: pointer;
        }

        .pastDay {
            background-color: #FFFFFF;
            cursor: pointer;
        }
        .pastDay:hover{
            background:#eee;
        }

        .pastDay.choiceDay,
        .today.choiceDay {
            background: #0A174E;
            color: #fff;
            font-weight: 600;
            cursor: pointer;
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
<div class="content">
	<div class="profile">
		<img src="../img/profile.png">
	</div>
	<div class="right">
		<div class="calendar-wrap">
        <table class="Calendar">
            <thead>
                <tr>
                    <td onClick="prevCalendar();" style="cursor:pointer;">&#60;</td>
                    <td colspan="5">
                        <span id="calYear"></span>년
                        <span id="calMonth"></span>월
                    </td>
                    <td onClick="nextCalendar();" style="cursor:pointer;">&#62;</td>
                </tr>
                <tr>
                    <td>일</td>
                    <td>월</td>
                    <td>화</td>
                    <td>수</td>
                    <td>목</td>
                    <td>금</td>
                    <td>토</td>
                </tr>
            </thead>

            <tbody>
            </tbody>
        </table>
    	</div>
    	<div class="button-wrap">
        	<button id="walk">DIARY 작성</button>
         	<button id="walk2">DIARY 보기</button>
    	</div>
    </div>
</div>
</body>
	 <script>
        window.onload = function () { buildCalendar(); }    // 웹 페이지가 로드되면 buildCalendar 실행

        let nowMonth = new Date();  // 현재 달을 페이지를 로드한 날의 달로 초기화
        let today = new Date();     // 페이지를 로드한 날짜를 저장
        today.setHours(0, 0, 0, 0);    // 비교 편의를 위해 today의 시간을 초기화

        // 달력 생성 : 해당 달에 맞춰 테이블을 만들고, 날짜를 채워 넣는다.
        function buildCalendar() {

            let firstDate = new Date(nowMonth.getFullYear(), nowMonth.getMonth(), 1);     // 이번달 1일
            let lastDate = new Date(nowMonth.getFullYear(), nowMonth.getMonth() + 1, 0);  // 이번달 마지막날

            let tbody_Calendar = document.querySelector(".Calendar > tbody");
            document.getElementById("calYear").innerText = nowMonth.getFullYear();             // 연도 숫자 갱신
            document.getElementById("calMonth").innerText = leftPad(nowMonth.getMonth() + 1);  // 월 숫자 갱신

            while (tbody_Calendar.rows.length > 0) {                        // 이전 출력결과가 남아있는 경우 초기화
                tbody_Calendar.deleteRow(tbody_Calendar.rows.length - 1);
            }

            let nowRow = tbody_Calendar.insertRow();        // 첫번째 행 추가           

            for (let j = 0; j < firstDate.getDay(); j++) {  // 이번달 1일의 요일만큼
                let nowColumn = nowRow.insertCell();        // 열 추가
            }

            for (let nowDay = firstDate; nowDay <= lastDate; nowDay.setDate(nowDay.getDate() + 1)) {   // day는 날짜를 저장하는 변수, 이번달 마지막날까지 증가시키며 반복  

                let nowColumn = nowRow.insertCell();        // 새 열을 추가하고


                let newDIV = document.createElement("p");
                newDIV.innerHTML = leftPad(nowDay.getDate());        // 추가한 열에 날짜 입력
                nowColumn.appendChild(newDIV);

                if (nowDay.getDay() == 0) {                 // 일요일인 경우 글자색 빨강으로
                    nowColumn.style.color = "#DC143C";
                }

                if (nowDay.getDay() == 6) {                 // 토요일인 경우
                    nowRow = tbody_Calendar.insertRow();    // 새로운 행 추가
                    nowColumn.style.color = "#0000CD";      // 글자색 빨간색
                }

                if (nowDay < today) {                       // 지난날인 경우
                    newDIV.className = "pastDay";
                    newDIV.onclick = function () { choiceDate(this); }
                }
                else if (nowDay.getFullYear() == today.getFullYear() && nowDay.getMonth() == today.getMonth() && nowDay.getDate() == today.getDate()) { // 오늘인 경우           
                    newDIV.className = "today";
                    newDIV.onclick = function () { choiceDate(this); }
                }
                else {                                      // 미래인 경우
                    newDIV.className = "futureDay";
                }
            }
        }

       
        
        function choiceDate(newDIV) {
            if (document.getElementsByClassName("choiceDay")[0]) {
                document.getElementsByClassName("choiceDay")[0].classList.remove("choiceDay");
            }
            newDIV.classList.add("choiceDay");

            // 출석 체크
            const btnWalk = document.getElementById("walk");
            btnWalk.addEventListener("click", function() {
                // 선택한 날짜의 배경을 노란색으로 변경
                const choicedDay = document.querySelector(".choiceDay");
                if (choicedDay) {
                    choicedDay.style.backgroundColor = "green";
                }else { alert("날짜를 선택하세요");}

                // next.jsp로 이동
                window.location.href = "myPage_write.jsp";
            
            });
            const btnWalk2 = document.getElementById("walk2");
            btnWalk2.addEventListener("click", function() {
                // 선택한 날짜에 대한 처리
                const choicedDay2 = document.querySelector(".choiceDay");
                const backgroundColor = window.getComputedStyle(choicedDay2).getPropertyValue("background-color");
                if (backgroundColor === "rgb(0, 128, 0)") { // 초록색 (RGB 값)
                    // 초록색이면 next.jsp로 이동
                    window.location.href = "myPage_diary.jsp";
                } else {
                    // 초록색이 아니면 '일기가 없습니다' 알림창 표시
                    alert("일기가 없습니다.");
                }
            });
            
        }

        // 이전달 버튼 클릭
        function prevCalendar() {
            nowMonth = new Date(nowMonth.getFullYear(), nowMonth.getMonth() - 1, nowMonth.getDate());   // 현재 달을 1 감소
            buildCalendar();    // 달력 다시 생성
        }
        // 다음달 버튼 클릭
        function nextCalendar() {
            nowMonth = new Date(nowMonth.getFullYear(), nowMonth.getMonth() + 1, nowMonth.getDate());   // 현재 달을 1 증가
            buildCalendar();    // 달력 다시 생성
        }

        // input값이 한자리 숫자인 경우 앞에 '0' 붙혀주는 함수
        function leftPad(value) {
            if (value < 10) {
                value = "0" + value;
                return value;
            }
            return value;
        }
        
        
    </script>
</html>         