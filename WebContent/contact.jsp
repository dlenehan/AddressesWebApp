<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css"
href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Add new contact</title>
</head>
<body>

<form method="POST" action='ContactController' name="frmAddUser">
        User ID : <input type="text" readonly="readonly" name="userid"
            value="<c:out value="${contact.userid}" />" /> <br /> 
        First Name : <input type="text" name="firstname"
            value="<c:out value="${contact.firstname}" />" /> <br /> 
        Last Name : <input type="text" name="lastname"
            value="<c:out value="${contact.lastname}" />" /> <br /> 
        DOB : <input type="text" name="dob"
            value="<c:out value="${contact.dob}" />" /> <br /> 
        Email : <input type="text" name="email"
            value="<c:out value="${user.email}" />" /> <br /> <input
            type="submit" value="Submit" />
    </form>


</body>
</html>