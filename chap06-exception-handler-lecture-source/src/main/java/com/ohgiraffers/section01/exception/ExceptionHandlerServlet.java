package com.ohgiraffers.section01.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/showErrorPage")
public class ExceptionHandlerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> attrNames = req.getAttributeNames();
        while(attrNames.hasMoreElements()) {
            System.out.println(attrNames.nextElement());
        }

        int statusCode = (int)req.getAttribute("jakarta.servlet.error.status_code");
        String message = (String)req.getAttribute("jakarta.servlet.error.message");
        String servletName = (String)req.getAttribute("jakarta.servlet.error.servlet_name");

        StringBuilder errorPage = new StringBuilder();
        errorPage.append("<h1 align=\"center\">")
                .append(statusCode)
                .append("-")
                .append(message)
                .append("<br>\n")
                .append("<p>에러 발생한 서블릿 명: ")
                .append(servletName)
                .append("</p>\n")
                .append("</h1>\n");

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.print(errorPage);
        out.flush();
        out.close();
    }
}
