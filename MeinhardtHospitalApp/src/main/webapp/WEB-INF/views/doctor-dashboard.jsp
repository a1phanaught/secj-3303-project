<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Dashboard</title>
</head>
<body>
    <c:choose>
        <c:when test="${not empty sessionScope.doctor}">
            <h1>Welcome, Dr. ${sessionScope.doctor.name}</h1>
            <h2>Your Appointments</h2>
            <c:if test="${not empty appointments}">
                <table border="1">
                    <tr>
                        <th>Appointment ID</th>
                        <th>Patient Name</th>
                        <th>Date & Time</th>
                        <th>Description</th>
                    </tr>
                    <c:forEach var="appointment" items="${appointments}">
                        <tr>
                            <td>${appointment.id}</td>
                            <td>${appointment.patient.name}</td>
                            <td>${appointment.datetime}</td>
                            <td>${appointment.description}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${empty appointments}">
                <p>No appointments found.</p>
            </c:if>
        </c:when>
        <c:otherwise>
            <p>You must be logged in as a doctor to access this page.</p>
            <a href="${pageContext.request.contextPath}/doctor/login">Login</a>
        </c:otherwise>
    </c:choose>
</body>
</html>