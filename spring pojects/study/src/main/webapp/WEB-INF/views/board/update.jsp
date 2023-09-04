<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시글 수정</h1>
	<form action="<c:url value='/board/insert'/>" method="post">
		<div class="form-group">
		<input type="hidden" name="bo_num">
			<label>제목</label>
			<input type="text" class="form-control" name="bo_title" value="${user.bo_title }">
		</div>
		<div class="form-group">
			<label>작성자</label>
			<input type="text" class="form-control" name="bo_me_id" value="${user.bo_me_id }" readonly>
		</div>
		<div class="form-group">
			<label>내용</label>
			<textarea class="form-control" name="bo_content" value="${user.bo_content }"></textarea>
		</div>
		<button>등록</button>
	</form>
</body>
</html>