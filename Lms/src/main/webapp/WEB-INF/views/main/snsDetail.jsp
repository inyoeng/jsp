<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
</head>
<body>
	<!-- 몸체 -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">글 세부내역</h6>
			<div class="card-body">
				<p>작성자 : ${list[0].sWriter } 작성일자: ${list[0].sDate }</p>
				<p>${list[0].sContent }
			</div>
		</div>
			<c:forEach var="sns" items="${list }">
			<div class="card-body">
				<i class="fas fa-smile-wink"></i>
				<p><${sns.cName }${sns.cDate }</p>
				<p>${sns.cSubject }
			</div>
		</c:forEach>
	</div>
	
</body>
</html>