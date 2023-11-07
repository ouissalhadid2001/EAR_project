<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Roles</title>
<!-- Include Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet" integrity="sha384-T3c6CoI..." crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="my-4">List of Roles</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${RoleList}" var="role">
					<tr>
						<td><c:out value="${role.id}" /></td>
						<td><c:out value="${role.name}" /></td>
						<td>
						<div class="btn-group" role="group">
							<form method="post" action="RoleController">
								<input type="hidden" name="action" value="showform"> <input
									type="hidden" name="id" value="${role.id}">
								<button type="submit" class="btn btn-warning btn-sm">Edit</button>
							</form>
							<form method="post" action="RoleController">
								<input type="hidden" name="action" value="delete"> <input
									type="hidden" name="id" value="${role.id}">
								<button type="submit" class="btn btn-danger btn-sm">Delete</button>
							</form> </div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="btn btn-success" href="addRole.jsp">Add Role</a>
	</div>

	<!-- Include Bootstrap JavaScript if needed -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>
