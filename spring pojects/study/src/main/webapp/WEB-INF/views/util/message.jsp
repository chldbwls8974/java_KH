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
	<script type="text/javascript">
		let msg = ${msg}; // toString 호출
		if(msg != null | msg.msg != null){
			alert(msg.msg);
		}
		location.href = '<c:url value="/"/>' + msg.url;
	</script>
</body>
</html>