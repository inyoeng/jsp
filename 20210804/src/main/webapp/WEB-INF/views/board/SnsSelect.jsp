<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>게시글 한 건 조회</h1>
		${list[0].SNo } : ${list[0].SContent }
	</div>
	<div align="center">
		<h5>댓글조회</h5>
		<c:forEach var="sns" items="${list }">
			${sns.CName }:
			${sns.CSubject }<br>
		</c:forEach>
	</div>
</body>
</html>