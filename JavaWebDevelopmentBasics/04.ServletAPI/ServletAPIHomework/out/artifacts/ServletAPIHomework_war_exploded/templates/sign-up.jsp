<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SinUp</title>
</head>
<body>
    <jsp:include page="menu.jsp"></jsp:include>

    <form method="POST">
        <label for="username">Username</label>
        <input type="text" id="username" name="username">
        <label for="password">Password</label>
        <input type="password" id="password" name="password">
        <input type="submit" value="Sign Up">
    </form>
</body>
</html>
