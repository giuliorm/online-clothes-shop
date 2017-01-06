<%--
  Created by IntelliJ IDEA.
  User: GiulioRM
  Date: 12/6/2016
  Time: 2:56 AM
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
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-4 margin well text-center">
            <form action="${pageContext.request.contextPath}/login" method="post">
                <div class="form-group row">
                    <h2 class="col-form-label">
                        <fmt:message bundle="${labels}" key="login.login" />
                    </h2>
                </div>

                <div class="form-group row">
                    <label class="col-form-label">
                        <fmt:message bundle="${labels}"key="login.email" /></label>
                </div>
                <div class="form-group row">
                    <input name="email" class="form-control" type="text" />
                </div>
                <div class="row">
                    <label class="col-form-label">
                        <fmt:message bundle="${labels}" key="login.password" /></label>
                </div>
                <div class="form-group row">
                    <input name="password" class="form-control" type="password"/>
                </div>
                <div class="form-group row">
                    <button type="submit" class="btn btn-primary">
                        <fmt:message bundle="${labels}" key="login.login" />
                    </button>
                </div>
            </form>
        </div>
        <div class="col-md-4 margin well text-center">
            <form action="${pageContext.request.contextPath}/register" method="post">
                <div class="form-group row">
                    <h2 class="col-form-label">
                        <fmt:message bundle="${labels}" key="login.register" /></h2>
                </div>
                <div class="form-group row">
                    <label class="col-form-label">
                        <fmt:message bundle="${labels}" key="login.firstName" /></label>
                </div>
                <div class="form-group row">
                    <input name="firstName" class="form-control" type="text"/>
                </div>
                <div class="form-group row">
                    <label class="col-form-label">
                        <fmt:message bundle="${labels}" key="login.lastName" /></label>
                </div>
                <div class="form-group row">
                    <input name="lastName" class="form-control" type="text"/>
                </div>
                <div class="form-group row">
                    <label class="col-form-label">
                        <fmt:message bundle="${labels}" key="login.email" /></label>
                </div>
                <div class="form-group row">
                    <input name="email" class="form-control" type="text"/>
                </div>
                <div class="form-group row">
                    <label class="col-form-label">
                        <fmt:message bundle="${labels}" key="login.password" /></label>
                </div>
                <div class="form-group row">
                    <input name="password" class="form-control" type="password"/>
                </div>
                <div class="form-group row">
                    <button type="submit" class="btn btn-primary">
                        <fmt:message bundle="${labels}" key="login.register" />
                    </button>
                </div>
            </form>
        </div>
        <div class="col-md-2"></div>
    </div>
</body>
</html>
