<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<html>
<head>
    <title>Student Management System</title>
    <style type="text/css">
        <%@ include file="/WEB-INF/css/style.css"%>
    </style>
</head>
<body>
<div class="container">
    <h1 class="heading">Book Management System</h1>
    <ul class="nav">
        <li><a href="/books/add">Add New Book</a></li>
        <li><a href="/books">View All Books</a></li>
        <li><a href="/authors/add">Add New Author</a></li>
        <li><a href="/authors">View All Authors</a></li>
    </ul>
    <marquee><h2>Welcome to the Book Management System</h2></marquee>
</div>
<div>${PrintSwal}</div>
</body>
</html>