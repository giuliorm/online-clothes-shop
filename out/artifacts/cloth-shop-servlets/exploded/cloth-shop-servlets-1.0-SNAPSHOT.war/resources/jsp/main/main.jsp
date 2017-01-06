<%--
  Created by IntelliJ IDEA.
  User: GiulioRM
  Date: 12/6/2016
  Time: 2:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/resources/jsp/parts/locales.jsp"%>
<html>
<head>
    <title>Title</title>
    <%@ include file="/resources/jsp/parts/header.jsp"%>
</head>
<body>
    <c:if test="${not empty loggedInUser}">
        <div class="row">
            <label>
                <fmt:message bundle="${labels}" key="main.welcome" />,
                <%= request.getParameter("username") %>
                <%= request.getParameter("usersurname") %>
            </label>
        </div>
        <div class="row">
            <div class="col-md-2">MAIN</div>
            <div class="col-md-1">|</div>
            <div class="col-md-2">CATALOGUE</div>
            <div class="col-md-1">|</div>
            <div class="col-md-2">CART</div>
            <div class="col-md-1">|</div>
            <div class="col-md-2">LOGOUT</div>
        </div>
        <div class="row text-center">
            <label><fmt:message bundle="${labels}" key="main.changeLocale" />:</label>
        </div>
        <div class="row text-center">
            <div class="col-md-3">
                <img src="/resources/img/ru.png" />
            </div>
            <div class="col-md-3">
                <img src="/resources/img/en.png" />
            </div>
            <div class="col-md-3">
                <img src="/resources/img/zh.png" />
            </div>
            <div class="col-md-3">
                <img src="/resources/img/de.png" />
            </div>
        </div>
    </c:if>
    <c:if test="${empty loggedInUser}">
        hey not logged in
    </c:if>

</body>
</html>
