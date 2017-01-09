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
    private void mainRedirect(String contextPath, HttpServletResponse response)
            throws IOException {
        response.sendRedirect(contextPath + "/home"); //&language=en-US");
    }

    private void setFalseLoginAttribute(HttpServletRequest request) {
        request.getSession().setAttribute("loggedInUser", false);
    }

    private void setTrueLoginAttribute(HttpServletRequest request, User user) {
        request.getSession().setAttribute("user", user);
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
                    setTrueLoginAttribute(request, user);
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
                    setTrueLoginAttribute(request, user);
                } else setFalseLoginAttribute(request);
            }

        } else
            setFalseLoginAttribute(request);

        mainRedirect(request.getContextPath(),response);
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
    }

    public void destroy()
    {
        // do nothing.
    }
}
