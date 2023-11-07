<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add Student</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoI..." crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1 class="my-4">Add Student</h1>
        <form action="StudentController" method="POST">
            <div class="mb-3">
                <label for="firstname" class="form-label">Firstname</label>
                <input type="text" class="form-control" id="firstname" name="firstname" required>
            </div>
             <div class="mb-3">
                <label for="lastname" class="form-label">Lastname</label>
                <input type="text" class="form-control" id="lastname" name="lastname" required>
            </div>
             <div class="mb-3">
                <label for="tel" class="form-label">Telephone</label>
                <input type="text" class="form-control" id="tel" name="tel" required>
            </div>
            <div class="mb-3">
                <label for="login" class="form-label">Login</label>
                <input type="text" class="form-control" id="login" name="login" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Mot de passe</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
           <div class="mb-3">
                <label for="field" class="form-label">Field:</label>
                <select name="field" class="form-select">
                    <c:forEach items="${fieldList}" var="field">
            <option value="<c:out value='${field.id}' />"><c:out value='${field.name}' /></option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Add Student</button>
        </form>
        <a class="btn btn-secondary mt-3" href="StudentController">Back to List</a>
    </div>
    <!-- Include Bootstrap JavaScript if needed -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
