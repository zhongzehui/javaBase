package com.zehui.javaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {

//        super.doGet(req, resp);
        String name = servletRequest.getParameter("userName");

        if (name!=null){
            servletRequest.getSession().setAttribute("userName",name);
        }
        System.out.println(servletRequest.getSession().getId());
        servletResponse.getWriter().write("hello world!" + name);
        servletResponse.flushBuffer();



    }
}
