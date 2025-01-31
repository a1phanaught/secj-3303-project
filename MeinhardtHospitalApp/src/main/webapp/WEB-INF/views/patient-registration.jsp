<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Registration</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/form.css">
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/patient/register">
        <p>Name:</p>
        <input type="text" name="name" required>
        <p>Email:</p>
        <input type="text" name="email" required>
        <p>Password:</p>
        <input type="password" name="password" required>
        <p>Address:</p>
        <input type="text" name="address" required>
        <p>Phone Num:</p>
        <input type="number" name="phoneNum" required>
        <br><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>