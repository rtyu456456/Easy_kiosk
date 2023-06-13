<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<div class="contents">

<c:forEach var="menus" items="${menus }">
<div class="content-box">
<div>${menus.m_img }</div>
<div>${menus.m_name}</div>
<div>${menus.m_price }</div> 
</div>
<br>
</c:forEach>

</div>
<div class="contents-under">
<button>이전</button>
<div>현재 페이지 표시</div>
<button>다음</button>
</div>
</div>
</body>
</html>