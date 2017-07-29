<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="apples" value="${5}"/>
<div>
    Apple Count: <c:out value="${apples}"/>
</div>
</body>
</html>
