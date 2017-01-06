package ru.juriasan.clothshop.controllers;

import ru.juriasan.clothshop.domain.User;
import ru.juriasan.clothshop.services.UserService;

import java.io.*;
import java.util.Locale;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by GiulioRM on 12/4/2016.
 */
public class Logout extends HttpServlet {

    UserService service;

    public void init() throws ServletException
    {
        // Do required initialization
    }
    private void mainRedirect(HttpServletResponse response)
            throws IOException {
        response.sendRedirect("/home"); //&language=en-US");
    }
    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

            //   service.create();
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");

        request.getSession().removeAttribute("user");
        mainRedirect(response);
        // Set response content type
        //    response.setContentType("text/html");
        // response.sendRedirect("src/main/webapp/index.jsp");
        // Actual logic goes here.
        //  PrintWriter out = response.getWriter();
        ///  out.println("<h1>" + message + "</h1>");
    }

    public void destroy()
    {
        // do nothing.
    }
}
