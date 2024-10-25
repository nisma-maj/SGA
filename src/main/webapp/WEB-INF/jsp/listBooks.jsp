<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>
<h2>Book List</h2>
<table border="1">
    <tr>
        <th>Title</th>
        <th>Genre</th>
        <th>Author</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.title}</td>
            <td>${book.genre}</td>
            <td>${book.author.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>