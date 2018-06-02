<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h2 align="center">Welcome Home</h2>

	<spring:url value="add" var="addURL" />
	<a href="${addURL }"> Add User </a>

	<table width="100%" border="1">
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>E-mail Id</td>
		</tr>
		<c:forEach items="${list }" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.name }</td>
				<td>${user.emailId }</td>
				<td><a href="update?id=${user.id}">Update</a></td>
				<td><a href="delete?id=${user.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>