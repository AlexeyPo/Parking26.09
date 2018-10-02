<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Zver
  Date: 15.09.2018
  Time: 12:00
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
    <link href="<c:url value="/resources/css/signin.css"/>" rel="stylesheet">
</head>

<body>
<div class="container">
    <div class="jumbotron col-xs-4 col-xs-offset-4">
        <h4 style="color: #c9302c">${message}</h4>
        <form action="login.html" method="post" class="form-signin">
            <div class="form-group">
                <h3 class="form-signin-heading">Введите логин и пароль</h3>
                <label for="login" class="sr-only">Логин</label>
                <input type="text" id="login" class="form-control" name="login" placeholder="Логин" required autofocus>
                <label for="password" class="sr-only">Пароль</label>
                <input type="password" id="password" class="form-control" name="password" placeholder="Пароль" required>
                <button class="btn btn-primary btn-lg btn-block active" type="submit" name="button" value="signIn">
                    Войти
                </button>
            </div>
        </form>
    </div>
</div> <!-- /container -->
</body>
</html>