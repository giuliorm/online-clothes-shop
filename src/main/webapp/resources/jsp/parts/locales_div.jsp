<%--
  Created by IntelliJ IDEA.
  User: GiulioRM
  Date: 1/6/2017
  Time: 12:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row margin text-center">
    <label><fmt:message bundle="${labels}" key="main.changeLocale" />:</label>
</div>
<div class="row margin text-center">
    <div class="btn-group" role="group">
        <!--<form class="btn-group" role="group" action="${pageContext.request.contextPath}/locale">
            <input name="locale" value="ru_RU" class="form-control" type="hidden"/>
            <button type="submit" class="btn btn-default"><img src="/resources/img/ru.png" /></button>
        </form> -->

        <form class="btn-group" role="group" action="${pageContext.request.contextPath}/locale">
            <input name="locale" value="en_US" class="form-control" type="hidden"/>
            <button type="submit" class="btn btn-default"><img src="/resources/img/en.png" /></button>
        </form>

        <form class="btn-group" role="group" action="${pageContext.request.contextPath}/locale">
            <input name="locale" value="de_DE" class="form-control" type="hidden"/>
            <button type="submit" class="btn btn-default"><img src="/resources/img/de.png" /></button>
        </form>
    </div>
</div>
