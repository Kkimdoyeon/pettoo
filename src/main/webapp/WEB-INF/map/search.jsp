<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/main.css' />" type="text/css">
<title>MAP</title>
<style>
.map {width: 60%; margin:20px auto; height: 500px; display: block;}
.top {
		width: 70%;
		margin: 220px auto 0;
		text-align:center;
	}

.mid {width:70%;
	margin:20px auto;
	display: flex;
	justify-content: center;
	gap: 30px;
}
.mid select {
	width: 100; padding: 10px 20px; font-size: 20px;  background: #F2F2F2; border: 2px solid #548235;
}
.mid input
.mid input[type="checkbox"] {
border: 1px solid #548235
padding: 5px;
}
.mid input[type="checkbox"]:checked {
background-color: #548235;
}
.btn {
  width: 200px;
  padding: 10px 20px;
  background: #548235;
  color: white;
  font-weight: 900;
  font-family: Gong Gothic OTF;
  font-size: 20px;
  line-height: 30px;
  border: 0;
}
.btn:hover {
  background-color: #385723 !important;
}

</style>
</head>
<body>
<div class="front-bar">
	<nav>
	    <a class="logo">
	        <img width="280" height="100"  src="<c:url value='/images/logo.png' />"/>
	    </a>
	    <div class="menu">
	    <ul>
	        <li class="sc-76e69317-0 kvRpqN nav-menu">
	            <a href="<c:url value='/user/myPage/page' />">MY PAGE</a>
	        </li>
	        <li class="sc-76e69317-0 kvRpqN nav-menu">
	            <a href="<c:url value='/user/profile/page' />">PROFILE</a>
	        </li>
	        <li class="sc-76e69317-0 kvRpqN nav-menu">
	            <a href="<c:url value='/community/list/page' />">COMMUNITY</a>
	        </li>
	        <li class="sc-76e69317-0 kvRpqN nav-menu">
	            <a href="<c:url value='/map/search/page' />" style="color: #647B54;">MAP</a>
	        </li>
	    </ul>
	    </div>
	</nav>
</div>
<div class="top"><img src="<c:url value='/images/map1.png' />"></div>
<div>
<form id="searchForm" action="<c:url value='/map/search' />" method="post" class="mid">
	<div class="select-box">
		<select name="area1" id="area1">
			<option>성북구</option>
		</select>
	</div>
	<div class="select-box">
		<select name="area2" id="area2">
			<option>성북동</option>
			<option>돈암동</option>
			<option>동소문동</option>
			<option>장위동</option>
			<option>정릉동</option>
			<option>월곡동</option>
			<option>종암동</option>
			<option>안암동</option>
			<option>길음동</option>
			
		</select>
	</div>
	<div class="check-box">
	<input type="checkbox" id="check1" name="checkbox1" value="value1">
    <label for="check1">카페</label>
    </div>
    <div class="check-box">
    <input type="checkbox" id="check2" name="checkbox2" value="value2">
    <label for="check2">식당</label>
    </div>
    <button class="btn" id="srch">검색</button>
   </form>
</div>

<div id="result" data-value="${result}"></div>
<div id="displayDiv"></div>
<div class="map" id="map"></div>
<br>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4a085d537c537cbb50471bc891e9fa29&libraries=services"></script>
<script>
var infowindow = new kakao.maps.InfoWindow({ zIndex: 1 });
var markers = [];

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
        level: 5 // 지도의 확대 레벨
    };  

//지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

var searchQuery = document.getElementById("result").getAttribute("data-value");
console.log(searchQuery);
document.getElementById("displayDiv").innerText = searchQuery;
var ps = new kakao.maps.services.Places(); 
ps.keywordSearch(searchQuery, placesSearchCB); 
function placesSearchCB (data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        var bounds = new kakao.maps.LatLngBounds();

        for (var i=0; i<data.length; i++) {
            displayMarker(data[i]);    
            bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
        }       

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
        map.setBounds(bounds);
        var level = map.getLevel();
        map.setLevel(level-1);
    } 
}
//지도에 마커를 표시하는 함수입니다
function displayMarker(place) {
    
    // 마커를 생성하고 지도에 표시합니다
    var marker = new kakao.maps.Marker({
        map: map,
        position: new kakao.maps.LatLng(place.y, place.x) 
    });
    var n = place.place_name;
    var p = new kakao.maps.LatLng(place.y, place.x);
    var iwContent = '<div style="padding:5px;">' +
   					 place.place_name +
   					'<br><a href="https://map.kakao.com/link/to/' + n + ',' + place.y + ',' + place.x + '"style="color:blue" target="_blank">길찾기</div>'
   					+'<button onclick="bookMark(' + place + ')">즐겨찾기 추가</button>';
    
    	iwPosition = new kakao.maps.LatLng(place.y, place.x), 
    	iwRemoveable = true;
    
    var infowindow = new kakao.maps.InfoWindow({
        position : iwPosition, 
        content : iwContent,
        removable : iwRemoveable
    });
    // 마커에 클릭이벤트를 등록합니다
    kakao.maps.event.addListener(marker, 'click', function() {
        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
        infowindow.setContent(iwContent);
        infowindow.open(map, marker);
       
    });
}

function bookMark(place) {
    
}






</script>
</body>
</html>