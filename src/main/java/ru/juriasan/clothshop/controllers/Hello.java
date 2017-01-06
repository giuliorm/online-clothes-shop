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
public class Hello extends HttpServlet {
    private String message;

    public void init() throws ServletException
    {
        // Do required initialization
        message = "Hello World";
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
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
