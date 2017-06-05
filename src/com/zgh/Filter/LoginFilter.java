package com.zgh.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by feir4 on 2017/6/6.
 */
@WebFilter(
        filterName = "LoginFilter",
        urlPatterns = {"/*"},
        initParams = {@WebInitParam(name="loginPage",value="index.jsp")})
public class LoginFilter implements Filter {
    private FilterConfig config;
    public void destroy() {
        config=null;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String loginPage=config.getInitParameter("loginPage");
        HttpServletRequest hrequest=(HttpServletRequest) req;
        HttpSession session=hrequest.getSession(true);
        String requestPath=hrequest.getServletPath();
        if(session.getAttribute("user")==null
                &&!requestPath.endsWith(loginPage)
                &&!requestPath.endsWith("/IndexServlet")){
            req.setAttribute("message","您还没有登录，请先登录");
            req.getRequestDispatcher(loginPage).forward(req,resp);
        }
        else{
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {
        this.config=config;
    }

}
