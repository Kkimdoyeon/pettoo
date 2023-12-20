<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='../css/main.css' />" type="text/css">
<title>MY PAGE</title>
<style>
	.diary {
		display: flex;
		width: 70%;
		margin: 220px auto;
		
		justify-content:right;
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
  <div class="diary">
  <img src="../img/diary.png">
  </div>
        
</body>

</html>
   