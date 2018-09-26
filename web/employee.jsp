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
<div class="container">
    <table class="table table-bordered table-striped" border="1px">
        <%--<jsp:useBean id="parkingBean" scope="request" class="beans.ParkingBean"/>--%>
        <%--<c:out value="${parkingBean.parkings}"/>--%>
        <tr>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Телефон</th>
        </tr>
        <jsp:useBean id="userBean" scope="request" class="beans.UserBean"/>
        <c:forEach var="userBean" items="${userBean.users}">
            <tr>
                <td>${userBean.lastName}</td>
                <td>${userBean.firstName}</td>
                <td>${userBean.phone}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<jsp:include page="footer.jsp"/>