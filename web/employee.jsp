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
    <c:forEach var="u" items="${userBean.users}">
        <tr>
            <td>${u.firstName}</td>
            <td>${u.lastName}</td>
            <td>${u.phone}</td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="footer.jsp"/>