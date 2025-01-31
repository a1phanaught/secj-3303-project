<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Login</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/form.css">
</head>
<body>
	<c:if test="${not empty error}">
		<p class="error">${error}</p>
	</c:if>
	<form method="post"
		action="${pageContext.request.contextPath}/doctor/login">
		<h1>Doctor Login</h1>
		<p>Email:</p>
		<input type="text" name="email" required>
		<p>Password:</p>
		<input type="password" name="password" required>
		<p>
			<input type="submit" value="Login">
	</form>
</body>
</html>