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
    <% Boolean loggedInUser =(Boolean)session.getAttribute("loggedInUser");
        if (loggedInUser != null && loggedInUser) {

    %>
        <div class="row margin text-center">
            <label>
                <fmt:message bundle="${labels}" key="main.welcome" />
                <%  String firstName = (String)request.getSession().getAttribute("firstName");
                   String secondName =   (String)request.getSession().getAttribute("lastName");
                   String empty = "";
                %>
                 <% if (firstName != null && !firstName.equals(empty) ||
                            secondName != null &&
                            !secondName.equals(empty)) {  %>
                        <%= ", " + firstName + " " + secondName %>
                <% } %>
            </label>
        </div>
        <div class="row margin text-center">
            <div class="btn-group btn-group-justified" role="group">
                <div class="btn-group" role="group">
                    <button type="button" class="btn btn-default">
                        <fmt:message bundle="${labels}" key="main.main" />
                    </button>
                </div>
                <div class="btn-group" role="group">
                    <button type="button" class="btn btn-default">
                        <fmt:message bundle="${labels}" key="main.catalogue" />
                    </button>
                </div>
                <div class="btn-group" role="group">
                    <button type="button" class="btn btn-default">
                        <fmt:message bundle="${labels}" key="main.cart" />
                    </button>
                </div>
                <form class="btn-group" role="group" action="${pageContext.request.contextPath}/logout">
                        <button type="submit" class="btn btn-default">
                            <fmt:message bundle="${labels}" key="main.logout" />
                        </button>
                </form>
            </div>
        </div>
        <div class="row margin" >
            <%@ include file="/resources/jsp/parts/locales_div.jsp"%>
        </div>
    <% } else { %>
        <%@ include file="/resources/jsp/user/login.jsp"%>
    <%
        }
    %>

</body>
</html>
