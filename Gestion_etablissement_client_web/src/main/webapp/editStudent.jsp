<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Student</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoI..." crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1 class="my-4">Edit Student</h1>
        <form action="StudentController" method="post">
            <input type="hidden" name="action" value="<c:out value='edit' />">
<input type="hidden" class="form-control" id="id" name="id" value="<c:out value='${student.id}' />">
            
            <div class="mb-3">
                <label for="firstname" class="form-label">Firstname:</label>
<input type="text" class="form-control" id="firstname" name="firstname" value="<c:out value='${student.firstname}' />">
            </div>
            <div class="mb-3">
                <label for="lastname" class="form-label">Lastname:</label>
                <input type="text" class="form-control" id="lastname" name="lastname" value="<c:out value="${student.lastname}" />">
            </div>
             <div class="mb-3">
                <label for="tel" class="form-label">Telephone:</label>
                <input type="text" class="form-control" id="tel" name="tel" value="<c:out value="${student.telephone}" />">
            </div>
             <div class="mb-3">
                <label for="login" class="form-label">Login:</label>
                <input type="text" class="form-control" id="login" name="login" value="<c:out value="${student.login}" />">
            </div>
             <div class="mb-3">
                <label for="password" class="form-label">Mot de passe:</label>
                <input type="password" class="form-control" id="password" name="password" value="<c:out value="${student.motdepasse}" />">
            </div>
           <div class="mb-3">
    <label for="field" class="form-label">Field:</label>
    <select class="form-select" id="field" name="field">
        <c:forEach items="${fields}" var="field">
            <c:choose>
                <c:when test="${field.id == student.field.id}">
                    <option value="<c:out value='${field.id}' />" selected><c:out value='${field.name}' /></option>
                </c:when>
                <c:otherwise>
                    <option value="<c:out value='${field.id}' />"><c:out value='${field.name}' /></option>
                </c:otherwise>
            </c:choose>
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
