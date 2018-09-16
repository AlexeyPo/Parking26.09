<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Zver
  Date: 16.09.2018
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<table class="table table-bordered table-striped" border="1px">
    <tr>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Телефон</th>
    </tr>
    <c:forEach var="userBean" items="${userBean.users}">
        <tr>
            <td>${userBean.firstName}</td>
            <td>${userBean.lastName}</td>
            <td>${userBean.phone}</td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="footer.jsp"/>