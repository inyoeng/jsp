<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div><h1>회 원 가 입</h1></div>
		<div>
			<form id="frm" name="frm" action="memberInsert.jsp" method="post"></form>
			<div>
				<table border="1">
					<tr>
						<th width="200">아이디</th>
						<td width="300"><input type="text" id="id" name="id"></td>
					</tr>
					<tr>
						<th width="200">비밀번호</th>
						<td width="300"><input type="password" id="password" name="password"></td>
					</tr>
					<tr>
						<th width="200">이 름</th>
						<td width="300"><input type="text" id="name" name="name"></td>
					</tr>
					<tr>
						<th width="200">나 이</th>
						<td width="300"><input type="text" id="age" name="age"></td>
					</tr>
					<tr>
						<th width="200">취 미</th>
						<td width="300">
							<input type="checkbox" id="hobby" name="hoddy" value="등산">등산
							<input type="checkbox" id="hobby" name="hoddy" value="낚시">낚시
							<input type="checkbox" id="hobby" name="hoddy" value="독서">독서
							<input type="checkbox" id="hobby" name="hoddy" value="바둑">바둑
							<input type="checkbox" id="hobby" name="hoddy" value="클라이밍">클라이밍
							<input type="checkbox" id="hobby" name="hoddy" value="서핑">서핑
						
						</td>
					</tr>
				</table>
			</div><br>
			<div>
				<input type="submit" value="회원가입">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="취   소">&nbsp;
			</div>
		</div>
	</div>
</body>
</html>