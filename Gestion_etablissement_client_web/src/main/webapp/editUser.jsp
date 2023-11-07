<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edit User</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoI..." crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1 class="my-4">Edit User</h1>
        <form action="UserController" method="post">
            <input type="hidden" name="action" value="<c:out value='edit' />">
<input type="hidden" class="form-control" id="id" name="id" value="<c:out value='${user.id}' />">
            
            <div class="mb-3">
                <label for="name" class="form-label">Login:</label>
<input type="text" class="form-control" id="name" name="name" value="<c:out value='${user.login}' />">
            </div>
            <div class="mb-3">
                <label for="code" class="form-label">Mot de passe:</label>
                <input type="password" class="form-control" id="code" name="password" value="<c:out value="${user.motdepasse}" />">
            </div>
             <div class="mb-3">
    <label for="role" class="form-label">Role:</label>
    <select class="form-select" id="role" name="role">
        <c:forEach items="${roles}" var="role">
                    <option value="<c:out value='${role.id}' />"><c:out value='${role.name}' /></option>
        </c:forEach>
    </select>
</div>
           
            
            <button type="submit" class="btn btn-primary">Save Changes</button>
        </form>
    </div>
    
    <!-- Include Bootstrap JavaScript if needed -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
