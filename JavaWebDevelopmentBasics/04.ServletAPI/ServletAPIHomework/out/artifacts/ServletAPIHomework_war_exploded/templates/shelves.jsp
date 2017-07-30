<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shelves</title>
    <link rel="stylesheet" href="../css/shelves.css">
</head>
<body>

    <c:import url="menu.jsp"></c:import>

        <table>
        <thead>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Pages</th>
                <th>CreationDate</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
        <c:set var="books" value="${books}"/>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.getTitle()}</td>
                <td>${book.getAuthor()}</td>
                <td>${book.getPages()}</td>
                <td>${book.getCreationDate().toString()}</td>
                <td><a href="/shelves/edit/${book.getTitle()}">Edit</a></td>
                <td><a href="/shelves/delete/${book.getTitle()}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
