package com.zehui.javaweb.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class HelloFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("HelloFilter 执行了init 方法");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            System.out.println("done");
            HttpServletRequest trueRequest = (HttpServletRequest) request;
            String username1 = request.getParameter("userName");
            Object username = trueRequest.getSession().getAttribute("userName");
            System.out.println(username);
            if(username1==null){
                if (username==null){
                    //提示重新登录吗？
                    return ;
                }
            }


        }
        chain.doFilter(request, response);

        System.out.println("这里执行一些请求完成的操作");
    }

    @Override
    public void destroy() {
        System.out.println("HelloFilter 执行了destroy方法");

    }
}
