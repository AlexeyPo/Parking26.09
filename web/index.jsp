<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Zver
  Date: 09.09.2018
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="<c:url value="/resources/images/favicon.ico"/>">

    <title>Parking - Главная страница</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/sticky-footer-navbar.css"/>" rel="stylesheet">

</head>

<body>

<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Parking</a>
        </div>
        <form action="login.html" method="post" class="navbar-btn navbar-right">
            <button type="submit" class="btn btn-success">Войти</button>
        </form>
    </div>
</nav>

<!-- Begin page content -->
<div class="container">
    <div class="page-header">
        <h1>Sticky footer with fixed navbar</h1>
    </div>
    <div class="container">
        <form action="index.html">
            <input type="submit" value="BD">
        </form>

        <div class="table">
            <tr>
                <td>1</td>
                <td>1</td>
                <td>1</td>
                <td>1</td>
            </tr>


            <c:forEach var="p" items="${parkingBean.parkings}">
                <tr>
                    <td>${p.parkingAddress}</td>
                    <td>${p.quantityOfParking}</td>
                    <td>${p.ratePerDay}</td>
                    <td>${p.ratePerMonth}</td>
                </tr>
            </c:forEach>



        </div>
    </div>
    <p class="lead">Pin a fixed-height footer to the bottom of the viewport in desktop browsers with this custom HTML
        and CSS. A fixed navbar has been added with <code>padding-top: 60px;</code> on the <code>body &gt;
            .container</code>.</p>
    <p>Back to <a href="../sticky-footer">the default sticky footer</a> minus the navbar.</p>
</div>

<footer class="footer">
    <div class="container">
        <p class="text-muted">Place sticky footer content here.</p>
    </div>
</footer>


<!-- Bootstrap core JavaScript
================================================== -->
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>
