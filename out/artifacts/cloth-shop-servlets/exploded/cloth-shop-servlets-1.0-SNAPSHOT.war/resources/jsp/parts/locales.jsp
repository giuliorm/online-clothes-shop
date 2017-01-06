<%--
  Created by IntelliJ IDEA.
  User: GiulioRM
  Date: 12/9/2016
  Time: 5:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language :
    not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" scope="application" />
<fmt:setBundle basename="locales.labels" var="labels" />
<fmt:message bundle="${labels}" key="main.welcome" />
