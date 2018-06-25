
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register here</title>
</head>
<body>

	<form:form action="loginCheck" method="POST" modelAttribute="value">

		<div align="center">

			<table>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="userName" />
				</tr>
				<tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" />
				</tr>
				<tr>
					<td><input type="submit" name="Submit" />
				</tr>
			</table>
			<div style="color: red">${error}</div>
			<p align="center">
				<a href="register">New User?</a>
			</p>
		</div>

	</form:form>
</body>
</html>
