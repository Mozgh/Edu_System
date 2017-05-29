package com.zgh.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by feir4 on 2017/5/28.
 */
@WebFilter(
        filterName = "EncodingFilter",
        urlPatterns = {"/*"},
        initParams = {
                @WebInitParam(name="encoding",value="UTF-8")
        })
public class EncodingFilter implements Filter {
    private FilterConfig config;
    public void destroy() {
        config=null;
    }
    //重写getParameter方法，处理get方法提交的表单中文乱码问题
    class MyRequest extends HttpServletRequestWrapper{
        public String encoding=config.getInitParameter("encoding");
        public String getParameter(String param){
            String value=null;
            try {
                super.setCharacterEncoding(encoding);
                value=super.getParameter(param);
                if(super.getMethod().equalsIgnoreCase("GET")){
                    if(value!=null){
                        value=new String(value.getBytes("iso8859-1"),encoding);
                    }
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return value;
        }
        public MyRequest(HttpServletRequest request) {
            super(request);
        }
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String encoding=config.getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        HttpServletRequest hrequest= (HttpServletRequest) req;
        HttpSession session=hrequest.getSession(true);
        chain.doFilter(new MyRequest((HttpServletRequest)req), resp);
    }

    public void init(FilterConfig config) throws ServletException {
        this.config=config;
    }

}
