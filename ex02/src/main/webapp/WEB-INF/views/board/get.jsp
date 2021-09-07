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
	<%-- 	<input type="hidden" name="pageNum" value="${cri.pageNum } ">
		<input type="hidden" name="amount" value="${cri.amount } "> --%>
		
		<button class="btn btn-default" >삭제하기</button>
	</form>
	<form action="update" method="get">
<%-- 		<input type="hidden" name="pageNum" value="${cri.pageNum } ">
		<input type="hidden" name="amount" value="${cri.amount } "> --%>
		
		<input value="${board.bno }" name="bno" type="hidden">
		<button class="btn btn-default" >수정하기</button>
	</form>
	</div>
	<br><br>
	
	<!-- 댓글 등록 -->
	<div class="panel-heading">
		<form id="replyForm">
			<input type="hidden" name="bno" value="${board.bno}">
			<input name="replyer">
			<input name="reply">
			<button type="button" id="saveReply">댓글 등록</button>
		</form>
	</div>
	<!-- 댓글 목록 -->
	<div class="row">
	  <div class="col-lg-12">
	  	<div class="panel panel-default">
	  		<div class="panel-heading">
	  			<i class="fa fa-comments fa-fw"></i>댓글
	  			<button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">New Reply</button>
	  		</div>
	  	</div>
	    <div class="panel-body">
	      <ul class="chat">
	      	<!-- 댓글 목록 script에 -->
	      </ul>
	    </div>
	  </div>
  	</div>
	
	<br>
	<a class="btn btn-success" href="list?pageNum=${cri.pageNum }&amount=${cri.amount}">목록으로</a>
	
	
<script src="../resources/js/reply.js"></script>

<script>
	let bno = "${board.bno }";	
	$(function(){
		//등록처리
		$('#saveReply').on('click', function(){
			//등록 호출하는 ajax가져오기
			replyService.add(function (data){
				$(".chat").append(makeLi(data));
			});
			
		});
	
		
		//목록 조회
		replyService.getList({bno:bno}, listCallback)
		
		function listCallback(datas){
				str = "";
				for(i=0; i<datas.length; i++){
					str += makeLi(datas[i])
				}
			$(".chat").html(str);
			}
		
		function makeLi(data){
			return	'<li class="left calearfix">'
					+ '  <div>'
					+ '  	<div class="header">'
					+ '		<strong class="primary-font">'+ data.replyer +'</strong>'
					+ '	      	<small class="pull-right text-muted">'+ data.replyDate +'</small><br>'
					+ '	      		<p>'+ data.reply +'</p>'
					+ '	      	</div>'
					+ '	      </div>'
					+ '	  </li>';
		}
		
		

	})

	
</script>	
	
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>