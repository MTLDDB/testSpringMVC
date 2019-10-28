<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2019/10/24
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
    <%@ include file="/WEB-INF/commo/taglibs.jsp"%>
</head>
<body>
<form action="${basePath}register/form">
    name    :<input type="text" name="name">
    password:<input type="password" name="password">
    role:<input type="text" name="role" value="用户">
    description:<input type="text" name="description">
    Permission_url:<input type="text" name="url" value="/test">
    <input type="submit" value="submit">
</form>
</body>
</html>
