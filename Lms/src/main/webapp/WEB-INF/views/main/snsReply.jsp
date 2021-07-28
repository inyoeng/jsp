<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Begin Page Content -->
<div class="container-fluid">

   <!-- Page Heading -->
   <h1 class="h3 mb-2 text-gray-800">Tables</h1>
   <p class="mb-4">Community 커뮤</p>

   <!-- DataTales Example -->
   <div class="card shadow mb-4">
      <div class="card-header py-3">
         <h6 class="m-0 font-weight-bold text-primary">Writer:
            ${list[0].sWriter } Title: ${list[0].sTitle } Date of Article:
            ${list[0].sDate }</h6>
      </div>
      <div class="card-body">
         <p>${list[0].sContents }</p>
      </div>

      <c:forEach var="sns" items="${list }">
         <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Writer:
               ${sns.cName } Date of Article:
               ${sns.cDate }</h6>
         </div>
         <div class="card-body">
            <p>${sns.cSubject }</p>
         </div>
      </c:forEach>

   </div>
   <div></div>
</div>
<!-- /.container-fluid -->
