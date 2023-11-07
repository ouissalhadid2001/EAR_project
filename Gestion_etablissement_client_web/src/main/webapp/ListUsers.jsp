<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Users</title>
<!-- Include Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet" integrity="sha384-T3c6CoI..." crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="my-4">List of Users</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Login</th>
					<th>Password</th>
					<th>Roles</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${UserList}" var="user">
					<tr>
						<td><c:out value="${user.id}" /></td>
						<td><c:out value="${user.login}" /></td>
						<td><c:out value="${user.motdepasse}" /></td>
						<td><c:forEach items="${user.roles}" var="role"
								varStatus="loop">
								<c:out value="${role.name}" />
								<c:if test="${!loop.last}">,</c:if>
							</c:forEach></td>

						<td>
						<div class="btn-group" role="group">
						<form method="post" action="UserController">
								<input type="hidden" name="action" value="showform"> <input
									type="hidden" name="id" value="${user.id}">
								<button type="submit" class="btn btn-warning btn-sm">Edit</button>
							</form>
							<form class="ml-5" method="post" action="UserController">
								<input type="hidden" name="action" value="delete"> <input
									type="hidden" name="id" value="${user.id}">
								<button type="submit" class="btn btn-danger btn-sm">Delete</button>
							</form>
						</div>
							
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form method="post" action="UserController">
			<input type="hidden" name="action" value="showaddform">
			<button type="submit" class="btn btn-danger btn-sm">Add User</button>
		</form>
		
	</div>

	<!-- Include Bootstrap JavaScript if needed -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>
