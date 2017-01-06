package ru.juriasan.clothshop.controllers;

import ru.juriasan.clothshop.database.repository.ShopItemRepository;
import ru.juriasan.clothshop.domain.Cart;
import ru.juriasan.clothshop.domain.ShopItem;
import ru.juriasan.clothshop.domain.User;
import ru.juriasan.clothshop.services.CartService;
import ru.juriasan.clothshop.services.ServiceContextHolder;
import ru.juriasan.clothshop.services.ShopService;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by GiulioRM on 12/4/2016.
 */
public class Catalogue extends HttpServlet {

    private int count = 10;
    private ShopService shopService;
    private CartService cartService;

    public void init() throws ServletException
    {
        shopService = ServiceContextHolder.getShopService();
        cartService = ServiceContextHolder.getCartService();
        // Do required initialization
    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        String idString = request.getParameter("shopItemId");
        if (idString != null) {
            Long id = Long.parseLong(idString);
            Cart cart = new Cart();
            cart.setShopItem(shopService.get(id));
            cart.setUser((User) request.getSession().getAttribute("user"));
            cartService.create(cart);
            request.setAttribute("items", shopService.getAll());
            request.getRequestDispatcher("resources/jsp/shop/catalogue.jsp").forward(request, response);
        }
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        List<ShopItem> items = shopService.getAll();
        request.setAttribute("items", items);

        request.getRequestDispatcher("resources/jsp/shop/catalogue.jsp").forward(request, response);
    }

    public void destroy()
    {
        // do nothing.
    }
}
