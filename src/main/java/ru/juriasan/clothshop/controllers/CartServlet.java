package ru.juriasan.clothshop.controllers;

import ru.juriasan.clothshop.domain.Cart;
import ru.juriasan.clothshop.domain.User;
import ru.juriasan.clothshop.services.CartService;
import ru.juriasan.clothshop.services.ServiceContextHolder;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by GiulioRM on 12/4/2016.
 */
public class CartServlet extends HttpServlet {

    CartService cartService;
    public void init() throws ServletException
    {
        cartService = ServiceContextHolder.getCartService();
        // Do required initialization
    }

    private void setParameters(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        request.setAttribute("user", user);
        request.setAttribute("cartItems", cartService.getAllForUser(user));
    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        String idString = request.getParameter("id");
        if (idString != null) {
            Long id = Long.parseLong(idString);
            cartService.remove(id);
            setParameters(request);
        }
        request.getRequestDispatcher("resources/jsp/shop/cart.jsp").forward(request, response);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
            setParameters(request);
            request.getRequestDispatcher("resources/jsp/shop/cart.jsp").forward(request, response);
            //   response.sendRedirect(request.getContextPath() + "/home");

    }

    public void destroy()
    {
        // do nothing.
    }
}
