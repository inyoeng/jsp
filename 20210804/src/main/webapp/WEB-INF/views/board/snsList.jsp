<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SnsList</title>
</head>
<body>
	<div align="center">
		<div><h1>게시글 목록</h1></div>
		<div>
			<c:forEach var="sns" items="${list }">
				${sns.SNo} : ${sns.STitle }<br>
			</c:forEach>
		</div>
		<form id= "frm" name="frm" action="snsSelect.do" method="post" >
			<input type="text" id ="sno" name ="sno" placeholder="sno입력">
			<button type="submit">검색</button>
		</form>
	</div>
</body>
</html>