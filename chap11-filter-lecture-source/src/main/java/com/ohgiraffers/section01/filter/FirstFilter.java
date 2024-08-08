package com.ohgiraffers.section01.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/first/*")
public class FirstFilter implements Filter {

    public FirstFilter() {
        System.out.println("FirstFilter 인스턴스 생성!!");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FirstFilter init 호출!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FirstFilter doFilter 호출");

        /* 설명.
            1. log
            2. 인코딩
            3. 암호화 */
        /* 설명. FilterChaind에서 제공하는  doFilter를 활용하여 다음 필터 또는 서블릿을 진행시킬 수 있다. */
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("서블릿을 다녀온 후");
    }

    @Override
    public void destroy() {
        System.out.println("FirstFilter destroy 호출");
    }
}
