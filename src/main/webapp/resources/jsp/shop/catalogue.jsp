<%@ page import="ru.juriasan.clothshop.domain.ShopItem" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: GiulioRM
  Date: 12/6/2016
  Time: 3:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/resources/jsp/parts/locales.jsp"%>

<html>
<header>
    <%@ include file="/resources/jsp/parts/header.jsp"%>
</header>
<body>

<div class="row margin text-center">
    <%@ include file="/resources/jsp/main/menu.jsp"%>
</div>
<div class="row margin" >
    <%@ include file="/resources/jsp/parts/locales_div.jsp"%>
</div>

<% //} else {
    List<ShopItem> items = (List<ShopItem>)request.getAttribute("items");
%>

    <div class="row margin panel panel-default">
        <div class="panel-heading"> <fmt:message bundle="${labels}" key="main.catalogue" /></div>

            <%
                int itemsInRow = 3;
                for(int i = 0; i < items.size(); i+=itemsInRow) {
            %>
                <div class="row">
                <%

                    for(int j = 0; j < itemsInRow; j++) {
                        int ind = i + j;
                        if (ind < items.size()) {
                            ShopItem shopItem = items.get(ind);
                %>
                    <div class="col-md-4">
                        <div class="panel panel-default">
                            <div class="panel-heading"> <%= shopItem.getName() %></div>
                            <div class="row">
                                <div class="col-md-4"></div>
                            </div>
                            <table class="table">
                                <tr>
                                    <td><b><fmt:message bundle="${labels}" key="shopitem.description" /></b></td>
                                    <td><b><fmt:message bundle="${labels}" key="shopitem.price" /></b></td>
                                </tr>
                                <tr>
                                    <td><%= shopItem.getDescription() %></td>
                                    <td><%= shopItem.getPrice() %></td>
                                </tr>
                                <tr>
                                    <td>
                                        <form method="post" action="${pageContext.request.contextPath}/catalogue">
                                           <div class="form-group">
                                               <input  class="hidden form-control" type="number" name="shopItemId"
                                                       value="<%= shopItem.getId() %>" />
                                               <button type="submit" class="btn btn-default">
                                                   <fmt:message bundle="${labels}" key="shopitem.addToCart" />
                                               </button>
                                           </div>
                                        </form>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                <%}%>

            <% } %>
            </div>

            <%}%>

    </div>
</body>
</html>

