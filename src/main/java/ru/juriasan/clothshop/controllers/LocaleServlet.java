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
public class LocaleServlet extends HttpServlet {
    private void setLocale(HttpServletResponse response, Locale locale) {

        response.setLocale(locale);
    }
    public void init() throws ServletException
    {
        // Do required initialization
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        String locale = request.getParameter("locale");
        //
        if (locale != null && !locale.equals("")) {
            String[] locales = locale.split("_");
            setLocale(response, locales.length > 1 ? new Locale(locales[0], locales[1])
                    : new Locale(locale));
            request.getSession().setAttribute("locale", locale);
        }
        response.sendRedirect(request.getContextPath() + "/home");
    }

    public void destroy()
    {
        // do nothing.
    }
}
