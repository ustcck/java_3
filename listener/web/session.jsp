<%--
  Created by IntelliJ IDEA.
  User: ustcck
  Date: 2016/10/15
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<%
  session.setAttribute("sname","svalue");
  session.setAttribute("sname","sssss");
  session.removeAttribute("sname");
%>
</body>
</html>
