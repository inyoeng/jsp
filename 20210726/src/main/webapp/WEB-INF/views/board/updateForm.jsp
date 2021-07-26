<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateForm</title>
</head>
<body>
	<div align="center">
		<div>
			<h2>게시글 상세보기</h2>
		</div>
		<div>
		<form id="frm" name="frm" action="updateBoard.do" method="post">
		
		<div>
			<table border="1">
				<tr>
				
					<th width="100">글번호</th>
					<td width="70" align="center">${board.bId }</td>
					<th width="100">작성자</th>
					<td width="150" align="center">${board.bWriter }</td>
					<th width="100">작성일</th>
					<td width="150" align="center">${board.bDate }</td>
					<th width="100">조회수</th>
					<td width="70" align="center">${board.bHit }</td>
				</tr>
				<tr>
					<th width="100">글제목<input type="hidden" id="bId" name="bId" value="${board.bId }"></th>
					<td colspan="7"><input type="text" id="bTitle" name="bTitle" value="${board.bTitle }"></td>
				</tr>
				<tr>
					<th width="100">내용</th>
					<td colspan="7">
					<textarea rows="7" cols="110" id="bContent" name="bContent">${board.bContent }</textarea>
					</td>
				</tr>

			</table>
		</div><br/>
		<div>
			<button type="submit">수정</button>&nbsp;&nbsp;&nbsp;
			<button type="reset">취소</button>
		</div>
		</form>
		</div>
	</div>
</body>
