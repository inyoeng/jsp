<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여기가 시작이야!</h1>
	<!-- a href에서 호출할 때 /HelloWorld 안됨. /빼야...!또는 ./HelloWorld해야함.  -->
	<h1><a href="HelloWorld?id=hong">servlet 호출 </a></h1>
	
	<form id="frm" name="frm" method="get" action="HelloWorld"> 
		<input type="submit" value="전송">
	</form>
</body>
</html>