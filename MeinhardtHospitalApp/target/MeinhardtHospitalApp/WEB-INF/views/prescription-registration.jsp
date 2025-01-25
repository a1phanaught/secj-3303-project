<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prescription Registration</title>
</head>
<body>
<h1>Prescription Registration</h1>
	<form method="post" action="${pageContext.request.contextPath}/prescription/register">
        <p>Name:</p>
        <input type="text" name="name" required>
        <p>dosage:</p>
        <input type="number" name="dosage" required>
        <p>Register Date:</p>
        <input type="date" name="registerDate" required>
        <p>Expiry Date:</p>
        <input type="date" name="expiryDate" required>
        <p>Quantity:</p>
        <input type="number" name="quantity" required>
        <br><br>
        <input type="submit" value="Register">
    </form>
    
</body>
</html>