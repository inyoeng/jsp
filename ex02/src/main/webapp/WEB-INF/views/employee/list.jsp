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
    <h1 class="page-header">직원정보</h1>
</div>
<!-- /.col-lg-12 -->
                
  <!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                직원 리스트 
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <table width="100%" class="table table-striped table-bordered table-hover" id="table">
                <thead>
               <tr>
                  <th>사번</th>
                  <th>이름</th>
                  <th>전화번호</th>
                  <th>급여</th>
                  <th>입사일</th>
               </tr>
            </thead>
            <tbody>
            <c:forEach var="emp" items="${list }">
               <tr>
                  <td>${emp.employee_id }</td>
                  <td><a class="move" href="${emp.employee_id }">${emp.last_name }</a></td>
                  <td>${emp.phone_number }</td>
                  <td>${emp.salary }</td>
                  <td><fmt:formatDate value="${emp.hire_date}"  pattern="yy-MM-dd" /></td>
               </tr>
            </c:forEach>
            </tbody>
            </table>
            <form id = "actionForm" action="list" method="get">
               <select name="type">
                  <option value="" ${empty pageMaker.cri.type ? selected :"" }>선택</option>
                  <option value="T" ${ pageMaker.cri.type =='T' ? selected :"" }>이름</option>
                  <option value="C"  <c:out value="${pageMaker.cri.type eq 'C'?'selected':'' }"/>>사번</option>
                  <option value="W"  <c:out value="${pageMaker.cri.type eq 'W'?'selected':'' }"/>>전화번호</option>
                  <option value="TC"  <c:out value="${pageMaker.cri.type eq 'TC'?'selected':'' }"/>>이름 or 사번</option>
                  <option value="TW"  <c:out value="${pageMaker.cri.type eq 'TW'?'selected':'' }"/>>이름 or 전화번호</option>
                  <option value="CW"  <c:out value="${pageMaker.cri.type eq 'CW'?'selected':'' }"/>>사번 or 전화번호</option>
                  <option value="TWC"  <c:out value="${pageMaker.cri.type eq 'TWC'?'selected':'' }"/>>이름 or 사번 or 전화번호</option>
               </select>
               <!-- 검색조건 유지하기 -->
               <input name="keyword" value="${pageMaker.cri.keyword}">
               <input type="hidden" name="pageNum" value="1">
               <input type="hidden" name="amount" value="${pageMaker.cri.amount } ">
               <button class="btn btn-default">search</button>
            </form>
            <!-- 페이지번호 넣기 -->
               <div id="pageButton" class="pull-right">
                  <ul class="pagination">
                     <c:if test="${pageMaker.prev}">
                        <li class="paginate_button previous"><a href="${pageMaker.startPage-1}">이전</a></li>
                     </c:if>
                     <c:forEach begin="${pageMaker.startPage}" 
                              end="${pageMaker.endPage}" 
                              var="num">
                        <li class="paginate_button ${pageMaker.cri.pageNum == num ? 'active' : '' }"><a href="${num}" >${num}</a></li>
                     </c:forEach>
                     <c:if test="${pageMaker.next}">
                        <li class="paginate_button next"><a href="${pageMaker.endPage+1}" >다음</a></li>
                     </c:if>
                  </ul>
               </div>
            </div>
         </div>
          <button onclick="location.href='register'"  class="btn btn-default">글등록하러가기</button>
      </div>
   </div>
</div>

<!-- /.row -->

<script>
$(function(){
   var actionForm = $("#actionForm")
   $(".move").on("click", function(e){
      e.preventDefault();
      var bno = $(this).attr("href")
      actionForm.append('<input type="hidden" name="employeeId" value="'+employeeId +'">')
      actionForm.attr("action","get")
      actionForm.submit();
   });
   
   $('#pageButton a').on("click", function(e){
      e.preventDefault(); 
      var p = $(this).attr("href")
      $('[name ="pageNum"]').val(p)
      actionForm.submit();
   })
})
</script>
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>