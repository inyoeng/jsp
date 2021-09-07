<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
        <!-- jQuery -->
    <script src="${pageContext.request.contextPath }/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath }/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.request.contextPath }/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath }/resources/dist/js/sb-admin-2.js"></script>

<script type="text/javascript">
	$(function(){
		
	$("#btn1").on("click", function(){ 
		$.ajax({
			url:"ajax1",
			method:"get",
			data:{writer:$("#writer").val()},//"writer="+$('#writer').val(),
			//async: false, //동기식
			dataType:"json",//plain="text", json, xml
			success: function(data){
				$('#result').append(data.content+"<br>");
				$('#result').append(data.writer+"<br>");
			}
		})
	});
		$("#result").append("클릭됨<br>");
		
	$("#btn2").on("click", function(){ 
		$.ajax({
			url:"ajax2",
			method:"post",
			data:JSON.stringify({writer:$("#writer").val()}),//"writer="+$('#writer').val(),
			contentType:"application/json",
			//async: false, //동기식
			dataType:"json",//plain="text", json, xml
			success: function(data){
				$('#result').append($('<p>').html(data.content));
				$('#result').append(`<p>\${data.writer}<br>\${data.content}</p>`);
			}
		})
	});
	
	//그룹이벤트! :위임-동적으로 추가된 테그에도 미리 이벤트 지정
		$("#result").on("click","p", function(){
			$(this).remove();
		})
	})
	//end of function
</script>

</head>
<body>
<input name="writer" id="writer">
	<button type="button" id="btn1">문자열</button>
	<button type="button" id="btn2">파라미터(json)</button>
<div id="result"></div>

</body>
</html>