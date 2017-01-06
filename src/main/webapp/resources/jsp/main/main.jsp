<%@ page import="ru.juriasan.clothshop.domain.User" %><%--
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
    <% User user = (User) request.getSession().getAttribute("user");
        if (user != null) {

    %>
        <div class="row margin text-center">
            <label>
                <fmt:message bundle="${labels}" key="main.welcome" />
                <%

                   String empty = "";
                %>
                 <% if (user != null && ( user.getFirstName() != null && !user.getFirstName().equals(empty) ||
                         user.getLastName() != null &&
                            ! user.getLastName().equals(empty))) {  %>
                        <%= ", " + user.getFirstName() + " " + user.getLastName() %>
                <% } %>
            </label>
        </div>
        <div class="row margin text-center">
            <%@ include file="/resources/jsp/main/menu.jsp"%>
        </div>
        <div class="row margin" >
            <%@ include file="/resources/jsp/parts/locales_div.jsp"%>
        </div>
        <div class="row margin">
            <fmt:message bundle="${labels}" key="main.message" />
        </div>
    <% } else { %>
        <%@ include file="/resources/jsp/user/login.jsp"%>
    <%
        }
    %>

</body>
</html>
