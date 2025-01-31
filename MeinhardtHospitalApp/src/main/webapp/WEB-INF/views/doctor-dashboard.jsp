<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Dashboard</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/dashboard.css">
<script type="text/javascript">
    function confirmDeletion(appointmentId) {
        if (confirm("Are you sure you want to delete this appointment?")) {
            document.getElementById('deleteForm-' + appointmentId).submit();
        }
    }
</script>
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
                        <th>Actions</th>
                    </tr>
                    <c:forEach var="appointment" items="${appointments}">
                        <tr>
                            <td>${appointment.id}</td>
                            <td>${appointment.patient.name}</td>
                            <td>${appointment.datetime}</td>
                            <td>${appointment.description}</td>
                            <td>
                                <form id="deleteForm-${appointment.id}" method="post" action="${pageContext.request.contextPath}/appointment/delete" style="display:inline;">
                                    <input type="hidden" name="appointment_id" value="${appointment.id}">
                                    <input type="button" value="Delete" class="button delete-button" onclick="confirmDeletion(${appointment.id})">
                                </form>
                                <form method="get" action="${pageContext.request.contextPath}/appointment/edit" style="display:inline;">
                                    <input type="hidden" name="appointment_id" value="${appointment.id}">
                                    <input type="submit" value="Edit" class="button">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${empty appointments}">
                <p>No appointments found.</p>
            </c:if>
            <a href="${pageContext.request.contextPath}/appointment/create">Create New Appointment</a>
            <form method="post" action="${pageContext.request.contextPath}/doctor/logout" style="margin-top: 20px;">
                <input type="submit" value="Logout" class="button logout-button">
            </form>
        </c:when>
        <c:otherwise>
            <p>You must be logged in as a doctor to access this page.</p>
            <a href="${pageContext.request.contextPath}/doctor/login">Login</a>
        </c:otherwise>
    </c:choose>
</body>
</html>