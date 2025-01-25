<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Registration</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/doctor/register">
        <p>Name:</p>
        <input type="text" name="name" required>
        <p>Email:</p>
        <input type="text" name="email" required>
        <p>Password:</p>
        <input type="password" name="password" required>
        <p>Address:</p>
        <input type="text" name="address" required>
        <p>Phone Number:</p>
        <input type="text" name="phoneNum" required>
        <br><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>