<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="/WEB-INF/views/includes/header.jsp" %>
	  
 
 <!-- tables.html에 있던거 가지고 옴! -->
<!-- DataTables CSS -->
  <link href="${pageContext.request.contextPath }/resources/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">
  <!-- DataTables Responsive CSS -->
  <link href="${pageContext.request.contextPath }/resources/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">
  <!-- DataTables JavaScript -->
  <script src="https://cdn.datatables.net/1.11.0/js/jquery.dataTables.min.js"></script>
  <script src="${pageContext.request.contextPath }/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath }/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>


 <div class="row">
<div class="col-lg-12">
    <h1 class="page-header">게시판</h1>
</div>
<!-- /.col-lg-12 -->
                
  <!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                게시글 리스트
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <table width="100%" class="table table-striped table-bordered table-hover" id="table">
                <thead>
					<tr>
						<th>bno</th>
						<th>title</th>
						<th>content</th>
						<th>writer</th>
						<th>date</th>
						<th>updatedate</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="board" items="${list }">
					<tr>
						<td>${board.bno }</td>
						<td><a href="get?bno=${board.bno }">${board.title }</a></td>
						<td>${board.content }</td>
						<td>${board.writer }</td>
						<td><fmt:formatDate value="${board.regdate }"  pattern="yy-MM-dd" /></td>
						<td><fmt:formatDate value="${board.updateDate }" pattern="yy-MM-dd" /></td>
					</tr>
				</c:forEach>
				</tbody>
				</table>
				</div>
			</div>
			 <button onclick="location.href='register'"  class="btn btn-default">글등록하러가기</button>
		</div>
	</div>
</div>

<!-- /.row -->

<script>
$(function(){
	$('#table').DataTable();
})
</script>
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>