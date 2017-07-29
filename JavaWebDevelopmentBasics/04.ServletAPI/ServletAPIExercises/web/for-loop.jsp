<%--
  Created by IntelliJ IDEA.
  User: vladix
  Date: 7/29/17
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>For Loop</title>
</head>
<body>
    <%! int elements = 10; %>
    <% for (int i = 0; i < elements; i++) { %>
    <div style="color: green;">
        <%= i %>
    </div>
    <%}%>
</body>
</html>
