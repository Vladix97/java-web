<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Book</title>
    <style>
        ul li{
            display: inline;
        }

        a {
            text-decoration: none;
        }
    </style>
</head>
<body>

    <c:import url="menu.jsp"/>

    <c:set var="book" value="${book}"/>
    <form method="POST">
        <label for="title">Title</label>
        <input type="text" id="title" name="title" value="${book.getTitle()}" readonly>
        <label for="author">Author</label>
        <input type="text" id="author" name="author" value="${book.getAuthor()}">
        <label for="pages">Pages</label>
        <input type="number" id="pages" name="pages" value="${book.getPages()}">
        <input type="submit" value="Edit Book">
    </form>

</body>
</html>
