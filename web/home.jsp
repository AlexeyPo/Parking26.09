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
<%--<table>--%>
    <%--<c:forEach var="p" items="${customerBean.customers}">--%>
        <%--<tr>--%>
            <%--<td>${p.firstName}</td>--%>
            <%--<td>${p.lastName}</td>--%>
            <%--<td>${p.phone}</td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
<%--</table>--%>


<table>
    <c:forEach var="p" items="${parkingBean.parkings}">
        <tr>
            <td>${p.parkingAddress}</td>
            <td>${p.quantityOfParking}</td>
            <td>${p.ratePerDay}</td>
            <td>${p.ratePerMonth}</td>
        </tr>
    </c:forEach>
</table>

<table>
    <c:forEach var="p" items="${userBean.users}">
        <tr>
            <td>${p.firstName}</td>
            <td>${p.lastName}</td>
            <td>${p.phone}</td>
        </tr>
    </c:forEach>
</table>

<c:if test="${user.id > 0}">
    <form action="signout.html">
        <input type="submit" value="SignOut">
    </form>
</c:if>
</body>
</html>
