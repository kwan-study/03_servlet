package com.ohgiraffers.section01.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>한글servlet response</h1>\n")
                .append("</body>\n")
                .append("</html>");

        /* 설명. tomcat 10버전 이후 MIME 생략 가능 */
//        resp.setContentType("text/plain");        // 지금 내보내는 문자열이 단순한 텍스트라는 MIME

        /* 설명. 1. tomcat 버전과 상관 없이 내보내는 데이터의 종류와 인코딩을 명시할 시 */
//        resp.setContentType("text/html");           // MIME는 생략해도 되지만 생략했을 시 한글은 깨진다....
//        resp.setCharacterEncoding("UTF-8");

        /* 설명. 1-1. 한 줄 가능 */
//        resp.setContentType("text/html; charset=UTF-8");

        /* 설명. 2. tomcat 10버전부터는 최소 MIME 타입이라도 알려주자. */
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.print(responseBuilder);     // StringBuilder 넣어도 그대로 출력해줌
        out.flush();                    // 왠만하면 출력 시에는 flush를 명시하자.
        out.close();
    }
}
