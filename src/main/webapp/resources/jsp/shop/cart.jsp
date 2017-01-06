<%--
  Created by IntelliJ IDEA.
  User: GiulioRM
  Date: 12/6/2016
  Time: 3:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.juriasan.clothshop.domain.ShopItem" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.juriasan.clothshop.domain.User" %>
<%@ page import="ru.juriasan.clothshop.domain.Cart" %><%--
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
        <div class="row margin">
            <% User user = (User)request.getSession().getAttribute("user");%>
            <h2><fmt:message bundle="${labels}" key="cart.user" />:
                <% if (user != null) { %>
                <%= user.getFirstName() + " " + user.getLastName()%>
                <% } %>
            </h2>
        </div>
        <div class="panel panel-default" style ="word-break:break-all;">
            <div class="panel-heading">
               <h3><fmt:message bundle="${labels}" key="main.cart" /></h3>
            </div>
                <%  List<Cart> cartItems = (List<Cart>)request.getAttribute("cartItems");
                    for(Cart item : cartItems) {
                %>
                    <div class="row margin">
                        <div class="col-md-8">
                            <div class="panel panel-default">
                                <div class="row margin">
                                    <div class="col-md-8"> <%= item.getShopItem().getDescription() %></div>
                                    <div class="col-md-4"> <%= item.getShopItem().getPrice() %></div>
                                </div>
                                <div class="row margin">
                                    <form method="post" action="${pageContext.request.contextPath}/cart">
                                        <input type="hidden" name="id" value="<%=item.getId()%>" />
                                        <button type="submit" class="btn btn-default" >
                                            <fmt:message bundle="${labels}" key="cart.remove" />
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">

                        </div>
                    </div>

                <% }%>

        </div>
    </body>
</html>
