<%--
  Created by IntelliJ IDEA.
  User: hieuhoang
  Date: 22/12/2023
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--xác định loại dữ liệu gửi về server khi user submit--%>
<form action="/upload/upload-image" method="post"
enctype="multipart/form-data"
>
    <input type="file" name="image" multiple>
    <button type="submit">Upload</button>
</form>
</body>
</html>
