<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<!-- 로그인 구현 -->
	<div align="center">
		<div><h1>로 그 인</h1></div>
		<form action="login.do">
			<div>
				<table border="1">
					<tr>
						<th width="100">아 이 디</th>
						<td><input type="text" id="id" name="id" placeholder="아이디를 입력하세요"></td>				
					</tr>
					<tr>
						<th width="100">패스워드</th>
						<td><input type="password" id="password" name="password" placeholder="패스워드를 입력하세요"></td>				
					</tr>
				</table>
				<br>		
			</div>
				<input type="submit" value="로그인">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소">
		</form>
	</div>
	
</body>
</html>