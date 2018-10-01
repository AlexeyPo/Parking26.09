<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Zver
  Date: 16.09.2018
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="jumbotron col-xs-12">
        <h3>Список всех клиентов</h3>
        <table class="table table-bordered table-striped" border="1px">
            <tr>
                <th>Номер тр. средства</th>
                <th>Марка тр. средства</th>
                <th>Модель тр. средства</th>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Платеж (грн)</th>
            </tr>

            <c:forEach var="customerList" items="${customerList}">
                <tr>
                    <td>${customerList.carNumber}</td>
                    <td>${customerList.make}</td>
                    <td>${customerList.model}</td>
                    <td>${customerList.lastName}</td>
                    <td>${customerList.firstName}</td>
                    <td>${customerList.payment}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<jsp:include page="footer.jsp"/>
