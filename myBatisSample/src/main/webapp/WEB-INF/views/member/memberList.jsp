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
	<div align ="center">
		<div><h1>회원목록</h1></div>
		<div>
			<c:forEach var="member" items="${members } ">
				아이디: ${member } 이 름: ${member } <br>
			</c:forEach>
			
		</div>
		아이디 입력:
		<form id="frm" name="frm" action="memberSelect.do" method="post">
			<input type="text" id="id" name="id">
			<button type="submit">버튼</button>
		</form>
	</div>
</body>
</html>