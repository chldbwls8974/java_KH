<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" 
	pageEncoding="utf-8" %>
<!doctype html>
<html lang="ko">
<head>
</head>
<body>
	<h1>게시판</h1>
	
	 <table class="table table-hover">
	    <thead>
	      <tr>
	        <th>번호</th>
	        <th>제목</th>
	        <th>작성자</th>
	        <th>조회수</th>
	        <th>추천/비추천</th>
	      </tr>
	    </thead>
	    <tbody>
	       <c:forEach items="${list}" var="board">
	      <tr>
	        <td>${board.bo_num}</td>
	        <td><a href="<c:url value='/board/detail${pm.cri.currentUrl}&bo_num=${board.bo_num }'/>">${board.bo_title }(${board.bo_comment })</a></td>
	        <td>${board.bo_me_id}</td>
	        <td>${board.bo_views}</td>
	        <td>${board.bo_up}/${board.bo_down}</td>
	      </tr>
	      </c:forEach>
	    </tbody>
	  </table>
	  
	  <div>
	  		<c:if test="${pm.prev }">
		    	<a class="page-link" href="<c:url value='/board/list${pm.cri.getUrl(pm.startPage-1) }'/>">이전</a>
		</c:if>
		<c:forEach begin="${pm.startPage }" end="${pm.endPage }" var="i">
		    	<a class="page-link" href="<c:url value='/board/list${pm.cri.getUrl(i) }'/>">${i }</a>
	    </c:forEach>
	     <c:if test="${pm.next }">
		    	<a class="page-link" href="<c:url value='/board/list${pm.cri.getUrl(pm.endPage+1) }'/>">다음</a>
	    </c:if>
	  </div>
	<a class="btn btn-outline-dark btn float-right" href="<c:url value='insert'/>">글쓰기</a>
	
	
</body>
</html>