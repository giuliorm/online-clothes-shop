package ru.juriasan.clothshop.controllers;

import ru.juriasan.clothshop.domain.User;
import ru.juriasan.clothshop.services.ServiceContextHolder;
import ru.juriasan.clothshop.services.UserService;
import ru.juriasan.clothshop.services.UserServiceImpl;

import java.io.*;
import java.util.Locale;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by GiulioRM on 12/4/2016.
 */
public class Login extends HttpServlet {

    UserService service;

    public void init() throws ServletException
    {
        service = ServiceContextHolder.getUserService();
        // Do required initialization
    }
    private void setLocale(HttpServletResponse response, Locale locale) {
        response.setLocale(locale);
    }
    private void mainRedirect(HttpServletResponse response)
            throws IOException {
        setLocale(response, Locale.US);
        response.sendRedirect("/home"); //&language=en-US");
    }

    private void setFalseLoginAttribute(HttpServletRequest request) {
        request.getSession().setAttribute("loggedInUser", false);
    }

    private void setTrueLoginAttribute(HttpServletRequest request, String firstName, String lastName) {
        String empty = "";
        request.getSession().setAttribute("loggedInUser", true);
        request.getSession().setAttribute("firstName", firstName != null ? firstName : empty);
        request.getSession().setAttribute("lastName", lastName != null ? lastName : empty);
    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        String empty = "";
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        response.setContentType("text/html");


        if (email != null && pass != null) {
            User user = service.get(email);
            if (user != null) {
                if (user.getPassword().equals(pass)) {
                    setTrueLoginAttribute(request, user.getFirstName(), user.getLastName());
                } else setFalseLoginAttribute(request);
            }
             else {
                if (firstName != null &&
                        !firstName.equals(empty) && lastName != null
                        && !lastName.equals(empty)) {
                    user = new User(email, pass);
                    user.setRole('U');
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    service.create(user);
                    setTrueLoginAttribute(request, firstName, lastName);
                } else setFalseLoginAttribute(request);
            }

        } else
            setFalseLoginAttribute(request);

        mainRedirect(response);
    }

    @Override
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
