<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form</title>
</head>
<body>

	<form:form action="save" method="POST" modelAttribute="user">

	<table>
		<form:hidden path="id" />
			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>E-mail Id</td>
				<td><form:input path="emailId" /></td>
			</tr>
			<tr>
				<td></td>
				<td><form:button type="submit">Submit</form:button></td>
			</tr>
		</table>
	</form:form>
</body>
</html>