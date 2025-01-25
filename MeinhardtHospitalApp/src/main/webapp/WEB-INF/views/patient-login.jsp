<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Login</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/patient/login">
        <p>Name:</p>
        <input type="text" name="name" required>
        <p>Email:</p>
        <input type="text" name="email">
        <p>Address:</p>
        <input type="text" name="address" required>
        <p>Password:</p>
        <input type="password" name="password" required>
        <p>Phone Num:</p>
        <input type="number" name="phoneNum" required>
        <br><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>