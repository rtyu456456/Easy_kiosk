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
				
				<button class="content-box">
					<img src="img/${menus.m_img }">
					<div>${menus.m_name}</div>
					<div>${menus.m_price }</div>
				</button>
				
			</c:forEach>
		</div>
		<div class="contents-under">
			<c:choose>
				<c:when test="${curPageNo > 0 }">
					<button
						onclick="location.href='EasyPageController?p=${curPageNo - 1 }'">이전</button>
				</c:when>
				<c:otherwise>
					<button disabled="disabled">이전</button>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${curPageNo < pageCount }">
					<button
						onclick="location.href='EasyPageController?p=${curPageNo + 1 }'">다음</button>
				</c:when>
				<c:otherwise>
				
					<button disabled="disabled">다음</button>
					
				</c:otherwise>
			</c:choose>


		</div>
	</div>
</body>
</html>