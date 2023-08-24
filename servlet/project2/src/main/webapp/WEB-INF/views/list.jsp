<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href ="<%=request.getContextPath() %>/board/insert">게시글 등록</a><br>
<table>
	<c:forEach items="${list}" var="board">
	<tr>
		<td>${board.bo_number }</td>
		<!-- 여기 수정해야함 -->
		<td><a href="<c:url value='/board/detail?bo_number=${board.bo_number}'/>">${board.bo_tilte }</a></td>
		<td>${board.bo_me_id }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>