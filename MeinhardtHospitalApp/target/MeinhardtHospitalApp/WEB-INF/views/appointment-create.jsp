<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Appointment</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty sessionScope.doctor}">
			<h1>Create New Appointment</h1>
			<form method="post"
				action="${pageContext.request.contextPath}/appointment/create">
				<p>Doctor ID:</p>
				<input type="number" name="doctor_id" value="${doctor.id}" required readonly>
				<p>Patient ID:</p>
				<input type="number" name="patient_id" required>
				<p>Date:</p>
				<input type="datetime-local" name="datetime" required>
				<p>Description:</p>
				<input type="text" name="description">
				<p></p>
				<input type="submit" value="Register">
			</form>
		</c:when>
		<c:otherwise>
			<p>You must be logged in as a doctor to access this page.</p>
			<a href="${pageContext.request.contextPath}/doctor/login">Login</a>
		</c:otherwise>
	</c:choose>
</body>
</html>