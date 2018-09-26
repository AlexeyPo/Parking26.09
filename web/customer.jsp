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

<div class="container">

        <table class="table table-bordered table-striped" border="1px">
            <tr>
                <th>Номер тр. средства</th>
                <th>Марка тр. средства</th>
                <th>Модель тр. средства</th>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Телефон</th>
                <th>Действие</th>
            </tr>

            <c:forEach var="customerList" items="${customerList}">
                <tr>
                    <td>${customerList.carNumber}</td>
                    <td>${customerList.make}</td>
                    <td>${customerList.model}</td>
                    <td>${customerList.lastName}</td>
                    <td>${customerList.firstName}</td>
                    <td>${customerList.phone}</td>
                    <td>
                        <button type="submit" class="btn btn-default" name="change" value="change">Изменить</button>
                    </td>
                </tr>
            </c:forEach>
        </table>

</div>
<jsp:include page="footer.jsp"/>
