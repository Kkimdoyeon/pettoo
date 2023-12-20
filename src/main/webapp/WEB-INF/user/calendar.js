/**
 * 달력 생성 코드 (myPage.jsp에 삽입)
 */
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
		} else { alert("날짜를 선택하세요");}

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