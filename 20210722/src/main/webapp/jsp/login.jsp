<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginPage</title>
</head>
<%@include file="header.jsp" %>
<body>
	<div align="center">
		<div><h1>Login</h1></div>
		<div>
			<form id= "frm" name="frm" action="LoginCheck.jsp" method="post">
				<table border="1">
					<tr>
						<th width="200">아 이 디</th>
						<td width="300"><input type="text" id="id" name="id"></td>
					</tr>
					<tr>
						<th width="200">비밀번호</th>
						<td width="300"><input type="password" id="password" name="password"></td>
					</tr>
				</table>
				<br>
				<input type="submit" value="login">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="취소">
			</form>
		</div>
	</div>
	
<jsp:include page="footer.jsp"/>
</body>
</html>