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
    <jsp:useBean id="theCustomerDAO" class="dao.CustomerDAO" scope="session"/>
    <c:set var="customers" value="${theCustomerDAO.findAllCustomers()}" scope="session"/>
    <c:forEach items="${customers}" var="customer" varStatus="loop">
        <td>${customer.id}</td>
        <td>${customer.firstName}</td>
        <td>${customer.lastName}</td>
        <td>${customer.phone}</td>
    </c:forEach>


    <form action="signout.html">
        <input type="submit" value="SignOut">
    </form>
</c:if>
</body>
</html>
