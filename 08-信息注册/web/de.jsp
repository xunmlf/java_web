<%--
  Created by IntelliJ IDEA.
  User: XUN~MLF
  Date: 2020/12/21
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <%
        String result = (String) request.getAttribute("de");
    %>
    <font style="color: red;font-size: 40px">
        <%=result%>
    </font>
</center>

</body>
</html>
