<%--
  Created by IntelliJ IDEA.
  User: GiulioRM
  Date: 1/6/2017
  Time: 5:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row margin text-center">
    <div class="btn-group btn-group-justified" role="group">
        <form class="btn-group" role="group" action="${pageContext.request.contextPath}/home">
            <button type="submit" class="btn btn-default">
                <fmt:message bundle="${labels}" key="main.main" />
            </button>
        </form>
        <form class="btn-group" role="group" action="${pageContext.request.contextPath}/catalogue">
            <button type="submit" class="btn btn-default">
                <fmt:message bundle="${labels}" key="main.catalogue" />
            </button>
        </form>
        <form class="btn-group" role="group" action="${pageContext.request.contextPath}/cart">
            <button type="submit" class="btn btn-default">
                <fmt:message bundle="${labels}" key="main.cart" />
            </button>
        </form>
        <form class="btn-group" role="group" action="${pageContext.request.contextPath}/logout">
            <button type="submit" class="btn btn-default">
                <fmt:message bundle="${labels}" key="main.logout" />
            </button>
        </form>
    </div>
</div>
