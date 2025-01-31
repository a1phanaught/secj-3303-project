<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Appointment</title>
</head>
<body>
    <h1>Edit Appointment</h1>
    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>
    <form method="post" action="${pageContext.request.contextPath}/appointment/edit">
        <input type="hidden" name="appointment_id" value="${appointment.id}">
        <p>Doctor:</p>
        <input type="text" name="doctor_name" value="${appointment.doctor.name}" readonly>
        <p>Patient:</p>
        <input type="text" name="patient_name" value="${appointment.patient.name}" readonly>
        <p>Date:</p>
        <input type="datetime-local" name="datetime" value="${appointment.datetime}" required>
        <p>Description:</p>
        <input type="text" name="description" value="${appointment.description}">
        <p></p>
        <input type="submit" value="Update">
    </form>
    <a href="${pageContext.request.contextPath}/doctor/dashboard">Back to Dashboard</a>
</body>
</html>