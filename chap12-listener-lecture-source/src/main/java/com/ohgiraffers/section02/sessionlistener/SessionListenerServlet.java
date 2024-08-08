package com.ohgiraffers.section02.sessionlistener;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionListenerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println("서블릿에서 session 출력: " + session.getClass().getName());

        // 삽입
        session.setAttribute("userName", "gildong hong");
        session.setAttribute("age", 21);
        session.setAttribute("gender", "M");

        // 수정
        session.setAttribute("userName", "hong");
        session.setAttribute("user", new UserDTO("gildong hong", 20));

        // 삭제
        session.removeAttribute("user");

        session.invalidate();
    }
}
