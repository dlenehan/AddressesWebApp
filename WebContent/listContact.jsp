<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Users</title>
</head>
<body>
<table border =1>
<thead>
<tr>
<th>User Id</th>
<th>First Name</th>
<th>Last Name</th>
<th>DOB</th>
<th>Email</th>
<th colspan=2>Action</th>
</tr>
</thead>
<tbody>
<c:forEach items="${contacts}" var="contact">
<tr>
	<td><c:out value="${contact.userid }"/></td>
	<td><c:out value="${contact.firstname}"/></td>
	<td><c:out value="${contact.lastname }"/></td>
	<td><c:out value="${contact.dob}"/></td>
	<td><c:out value="${contact.email}" /></td>
	<td><a href="ContactController?action=edit&userId=<c:out value="${contact.userid}"/>">Update</a></td>
	<td><a href="ContactController?action=delete&userId=<c:out value="${contact.userid}"/>">Delete</a></td>
</tr>
</c:forEach>
</tbody>
</table>
<p><a href="ContactController?action=insert">Add User</a></p>
</body>
</html>