package com.xlibaba.travel.web.filter;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

/**
 * @author ChenWang
 * @className DefaultFilter
 * @date 2020/10/22 11:20
 * @since JDK 1.8
 */
public abstract class DefaultFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
