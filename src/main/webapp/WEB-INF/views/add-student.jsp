<%--
  Created by IntelliJ IDEA.
  User: hieuhoang
  Date: 21/12/2023
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/student/add-student" method="post">
    <input type="text" name="id" placeholder="id">
    <input type="text" name="name" placeholder="fullname">
    <br>
    <input type="text" name="age" placeholder="age">
    <br>
    <button type="submit">Add</button>

</form>
</body>
</html>
