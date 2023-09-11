<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>로그인</title>
</head>
<body>

<div class="container">
  <h2>로그인</h2>
  <form action="<c:url value='/member/login'/>" method="post">
    <div class="form-group">
      <label for="me_id">아이디</label>
      <input type="text" class="form-control" id="me_id"  name="me_id">
    </div>
    <div class="form-group">
      <label for="me_pw">비밀번호</label>
      <input type="password" class="form-control" id="me_pw" name="me_pw">
    </div>
    <input type="checkbox" class="form-check-input" value="true" name="autoLogin">자동로그인
    <button class="btn btn-outline-warning col-12">로그인</button>
  </form>
</div>

</body>
</html>