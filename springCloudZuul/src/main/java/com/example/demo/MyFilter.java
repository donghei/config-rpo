package com.example.demo;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/7/13/013.
 *
 * 用来过滤url请求地址
 */
@Component
public class MyFilter  extends ZuulFilter {

    private  static Logger log = Logger.getLogger(MyFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest req = rc.getRequest();
        log.info(String.format("%s >>> %s", req.getMethod(), req.getRequestURI().toString()));
        Object acctoken = req.getParameter("token");
        if (acctoken == null) {
            log.warn("token is emtry");
            rc.setSendZuulResponse(false);
            rc.setResponseStatusCode(401);
            try {
                rc.getResponse().getWriter().write("token is emtry");
            } catch (Exception e) {

            }
            return null;
        }
        log.info("ok");
        return null;
    }
}
