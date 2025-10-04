<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="pt-br">
<head>
    <meta charset="utf-8" />
    <title>Create Car</title>
</head>
<body>
<h2>Create Car</h2>

<form action="/create-car" method="post">
    <input type="text" name="car-name" id="car-name" value="${param.name}">
    <input type="hidden" id="id" name="id" value="${param.id}">

    <button type="submit">Save</button>
</form>
</body>
</html>