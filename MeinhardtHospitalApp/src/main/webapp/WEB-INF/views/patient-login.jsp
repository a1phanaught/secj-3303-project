<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Login</title>
</head>
<body>
	<h1>Patient Login</h1>
	<c:if test="${not empty error}">
        <p style="color:red;">${error}</p>
    </c:if>
	<form method="post" action="${pageContext.request.contextPath}/patient/login">
        <p>Email:</p>
        <input type="text" name="email" required>
        <p>Password:</p>
        <input type="password" name="password" required>
        <p></p>
        <input type="submit" value="Login">
    </form>
</body>
</html>