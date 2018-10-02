<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Zver
  Date: 16.09.2018
  Time: 12:02
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

    <title>Parking</title>

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
                <span class="sr-only"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="./index.html">Parking</a>
        </div>
        <form action="menu.html" method="post">
            <div id="navbar" class="collapse navbar-collapse">
                <div id="bottom-panel" class="navbar-btn">

                    <button class="btn btn-default" type="submit" name="button" value="home">Home</button>
                    <button class="btn btn-default" type="submit" name="button1" value="customer">Клиенты</button>
                    <button class="btn btn-default" type="submit" name="button2" value="payment">Оплата</button>
                    <button class="btn btn-default" type="submit" name="button3" value="employee">Сотрудники</button>
                    <jsp:useBean id="user" type="beans.User" scope="session"/>
                    <button class="btn btn-success navbar-right" type="submit" name="button4" value="signOut">Выйти</button>
                    <h5 class="navbar-text navbar-right">Смена: ${user.phone} ${user.firstName}</h5>
                </div>
            </div><!--/.nav-collapse -->
        </form>
    </div>
</nav>

<!-- Begin page content -->
<div class="container">

</div>


<!-- Bootstrap core JavaScript
================================================== -->
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>