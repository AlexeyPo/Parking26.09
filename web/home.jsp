<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Zver
  Date: 09.09.2018
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>




<jsp:useBean id="user" class="beans.User" scope="session"/>
<c:if test="${user.id > 0}">
    <form action="signout.html">
        <input type="submit" value="SignOut">
    </form>
</c:if>
</body>
</html>
