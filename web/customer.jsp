<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Zver
  Date: 15.09.2018
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>


<table class="table table-bordered table-striped" border="1px">
    <tr>
        <th>Номер тр. средства</th>
        <th>Марка тр. средства</th>
        <th>Модель тр. средства</th>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Телефон</th>
    </tr>
    <c:forEach var="p" items="${customerBean.customers}">
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
<jsp:include page="footer.jsp"/>
