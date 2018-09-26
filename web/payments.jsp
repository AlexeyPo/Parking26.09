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
    <table>
        <c:forEach var="CarBean" items="${carBean.customers}">
            <tr>
                <td>${CarBean.make}</td>
                <td>${CarBean.model}</td>
                <td>${CarBean.carNumber}</td>
            </tr>
        </c:forEach>
    </table>
    <h1>Payments</h1>
</div>

<jsp:include page="footer.jsp"/>
