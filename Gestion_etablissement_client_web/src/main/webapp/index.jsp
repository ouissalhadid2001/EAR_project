<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<center><h1>Application Gestion établissement</h1> </center>
<form action="UserController">
<div class="d-grid gap-2 col-6 mx-auto">
  <button class="btn btn-primary mt-5"  >User</button>
</div></form>
<form action="FieldController">
<div class="d-grid gap-2 col-6 mx-auto">
<button class="btn btn-primary mt-5" >Field</button>
</div></form>
<form action="RoleController">
<div class="d-grid gap-2 col-6 mx-auto">
<button class="btn btn-primary mt-5" >Role</button>
</div></form>
<form action="StudentController">
<div class="d-grid gap-2 col-6 mx-auto">

<button class="btn btn-primary mt-5" >Student</button></div>
</form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</body>
</html>