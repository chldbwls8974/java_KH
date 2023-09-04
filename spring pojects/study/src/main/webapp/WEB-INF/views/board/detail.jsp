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
<h1>게시글 상세</h1>
<div>
	<div>
		<label>제목</label>
		${board.bo_title }
	</div>
	<div>
		<label>작성자</label>
		${board.bo_me_id }
	</div>
	<div>
		<label>조회수</label>
		${board.bo_views }
	</div>
	<div>
		<label>내용</label>
		${board.bo_content }
	</div>
	<div>
		<label>추천</label>
		${board.bo_up }
	</div>
	<div>
		<label>비추천</label>
		${board.bo_down }
	</div>
	
	<a href="/board/update?bo_num=${board.bo_num }">수정</a>
</div>



				
			
		
</body>
</html>