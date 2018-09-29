<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Zver
  Date: 09.09.2018
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<div class="container">

    <div class="jumbotron col-xs-12 col-xs-5" style="width: 45%">
        <h3>Контроль въезда/выезда клиентов</h3>
        <h4 style="color: #c9302c">${message}</h4>
        <form action="moveControl.html" class="navbar-form navbar-left" method="post">
            <div class="form-group">
                <label for="carNumberIn">Номер тр. средства</label>
                <input type="text" class="form-control" placeholder="Номер тр. средства" id="carNumberIn"
                       name="carNumber">
            </div>
            <button type="submit" class="btn btn-default" name="comeIn" value="comeIn">Въезд</button>
            <div class="form-group">
                <label for="carNumberOut">Номер тр. средства</label>
                <input type="text" class="form-control" placeholder="Номер тр. средства" id="carNumberOut"
                       name="carNumberOut">
                <button type="submit" class="btn btn-default" name="goOut" value="goOut">Выезд</button>
            </div>
        </form>
    </div>

    <div class="jumbotron col-xs-12 col-xs-5 col-xs-offset-1" style="width: 45%">
        <h3>Оплата за парковку</h3>
        <h4 style="color: #c9302c">${messageP}</h4>
        <form action="payment.html" class="navbar-form navbar-left" method="post">

            <table>
                <tr>
                    <td><label class="control-label" for="carNumberP">Номер тр. средства</label></td>
                    <td><input class="form-control" type="text" id="carNumberP" name="carNumberP"
                               placeholder="Номер тр. средства" style="margin-left: 3px" required></td>
                    <td rowspan="2">
                        <button type="submit" class="btn btn-default btn-lg" name="toPay" value="toPay"
                                style="margin-left: 3px">Оплатить</button>
                    </td>
                </tr>
                <tr>
                    <td><label class="control-label" for="payment">Сумма оплаты</label></td>
                    <td><input class="form-control" type="text" id="payment" name="payment" placeholder="Сумма оплаты"
                               style="margin-left: 3px" required></td>
                </tr>
            </table>
        </form>
    </div>


    <div class="jumbotron col-xs-12">
        <h3>Добавить нового клиента / с отметкой въезда</h3>
        <div class="container">
            <form action="client.html" method="post">
                <table class="table">
                    <tr>
                        <td><input type="text" class="form-control" placeholder="Номер тр. средства" id="carNumber"
                                   name="carNumber" required></td>
                        <td><input type="text" class="form-control" placeholder="Марка тр. средства" id="carMake"
                                   name="carMake" required></td>
                        <td><input type="text" class="form-control" placeholder="Модель" id="carModel" name="carModel">
                        </td>
                        <td><input type="text" class="form-control" placeholder="Фамилия клиента" id="lastName"
                                   name="lastName" required>
                        </td>
                        <td><input type="text" class="form-control" placeholder="Имя клиента" id="firstName"
                                   name="firstName" required>
                        </td>
                        <td><input type="text" class="form-control" placeholder="Номер телефона" id="phone"
                                   name="phone" required></td>
                        <td>
                            <button type="submit" class="btn btn-default" name="add" value="add">Добавить</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

    <div class="jumbotron col-xs-12">
        <h3>Транспортные средства находящиеся на парковке</h3>
        <table class="table table-bordered table-striped" border="1px">
            <tr>
                <th>Номер тр. средства</th>
                <th>Марка тр. средства</th>
                <th>Модель тр. средства</th>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Телефон</th>
            </tr>

            <c:forEach var="customerListOnParking" items="${customerListOnParking}">
                <tr>
                    <td>${customerListOnParking.carNumber}</td>
                    <td>${customerListOnParking.make}</td>
                    <td>${customerListOnParking.model}</td>
                    <td>${customerListOnParking.lastName}</td>
                    <td>${customerListOnParking.firstName}</td>
                    <td>${customerListOnParking.phone}</td>
                </tr>
            </c:forEach>
        </table>

    </div>

</div>
<jsp:include page="footer.jsp"/>
