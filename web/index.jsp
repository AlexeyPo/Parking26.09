<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Zver
  Date: 09.09.2018
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%--<table>--%>
    <%--<c:forEach var="p" items="${customerBean.customers}">--%>
        <%--<tr>--%>
            <%--<td>${p.id}</td>--%>
            <%--<td>${p.firstName}</td>--%>
            <%--<td>${p.lastName}</td>--%>
            <%--<td>${p.phone}</td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
<%--</table>--%>

<jsp:useBean id="user" class="beans.User" scope="session"/>
<c:if test="${user.id==0}">
    <form action="login.html" method="post">
        <input type="text" name="login" title="login" required >
        <input type="password" name="password" title="password">
        <input type="submit" name="button" value="Sign In">
    </form>
</c:if>

</body>
</html>
