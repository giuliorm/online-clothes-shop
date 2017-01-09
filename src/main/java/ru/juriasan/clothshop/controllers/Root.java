package ru.juriasan.clothshop.controllers;

import java.io.*;
import java.util.Locale;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by GiulioRM on 12/4/2016.
 */
public class Root extends HttpServlet {

    public void init() throws ServletException
    {
        // Do required initialization
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        request.getRequestDispatcher("resources/jsp/main/main.jsp").forward(request, response);

     //   response.sendRedirect(request.getContextPath() + "/home");
    }

    public void destroy()
    {
        // do nothing.
    }
}
