<%@ page import="cn.ustc.domain.User" %>
<%--
  Created by IntelliJ IDEA.
  User: ustcck
  Date: 2016/10/15
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<%
  User user = new User();
  user.setId(1);
  user.setName("tom");

  session.setAttribute("user", user); //绑定
%>
</body>
</html>
