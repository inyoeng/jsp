<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="/WEB-INF/views/includes/header.jsp" %>


 <div class="row">
<div class="col-lg-12">
    <h1 class="page-header">게시글 등록하기 </h1>
</div>
</div>
<p></p>

     <form role="form" action="${pageContext.request.contextPath }/board/register" method="post">
        <div class="form-group">
            <label>제목을 입력하세요</label>
            <input class="form-control" placeholder="Enter text" id="title" name="title">
        </div>

        <div class="form-group">
            <label>게시글 내용 입력</label>
            <textarea class="form-control" rows="3" id="content" name="content"></textarea>
        </div>
     	 <div class="form-group">
            <label>작성자</label>
            <input class="form-control" placeholder="Enter text" id="writer" name="writer">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
        <button type="reset" class="btn btn-default">Reset</button>
    </form>
                            
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>