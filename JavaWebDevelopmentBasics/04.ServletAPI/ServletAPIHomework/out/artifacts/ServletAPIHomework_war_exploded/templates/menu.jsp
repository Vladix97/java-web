<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.bookhut.models.binding_models.LoginUserModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
    <link rel="stylesheet" href="../css/menu.css">
</head>
<body>

    <ul>
        <li><a href="/">Home</a></li>
        <%
            LoginUserModel loginModel = (LoginUserModel) session.getAttribute("user");
            String username = null;
            if (loginModel != null) username = loginModel.getUsername();
            request.setAttribute("username", username);
        %>
        <c:set var="username" value="${username}" scope="session"/>
        <c:choose>
            <c:when test="${username != null}">
                <li>${username}<a href="/sign-out">Sign Out</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="/sign-up">Sign Up</a></li>
                <li><a href="/sign-in">Sign In</a></li>
            </c:otherwise>
        </c:choose>

        <li><a href="/add-book">Add Book</a></li>
        <li><a href="/shelves">Shelves</a></li>
    </ul>

</body>
</html>
