<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	request.setCharacterEncoding("utf-8");
	String id= request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	int age = Integer.valueOf(request.getParameter("age"));
	String[] hobbies = request.getParameterValues("hobby");
%>
<body>
	<div align="center">
		<div><h1>회원가입 내역</h1></div>
		<div>
			<h3>아이디:<%= id %></h3>
			<h3>비 번: <%= password %></h3>
			<h3>이 름: <%= name %></h3>
			<h3>나 이: <%= age %></h3>
			<h3>취 미: <%= hobbies[0] %></h3>
		</div>
	</div>
</body>
</html>