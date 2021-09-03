<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>

 <div class="row">
  <div class="col-lg-12">
      <h1 class="page-header">게시글 상세보기</h1>
  </div>
  <!-- /.col-lg-12 -->


<table class="table">
	<tr><th width="100">제목</th>
		<td>${board.title }</td>
	</tr>
	<tr><th>내용</th>
		<td>${board.content }</td>
	</tr>
	<tr><th>작성자</th>
		<td>${board.writer }</td>
	</tr>
	<tr><th>작성일자</th>
		<td><fmt:formatDate value="${board.regdate }"  pattern="yy-MM-dd" /></td>
	</tr>
	<tr><th>수정일자</th>
		<td><fmt:formatDate value="${board.updateDate }" pattern="yy-MM-dd" /></td>
	</tr>
</table>
<br>
	
	<form action="delete" method="post">
		<input value="${board.bno }" name="bno" type="hidden">
		<button class="btn btn-default" >삭제하기</button>
	</form>
	<form action="update" method="get">
		<input value="${board.bno }" name="bno" type="hidden">
		<button class="btn btn-default" >수정하기</button>
	</form>
	
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>