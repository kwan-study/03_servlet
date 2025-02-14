package com.ohgiraffers.section02.sessionlistener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    public SessionListener() {
        System.out.println("session listener 인스턴스 생성!");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session created!");
        System.out.println("생성 session id: " + se.getSession().getId());
        System.out.println("session 객체 타입: " + se.getSession().getClass().getName());   // class라는 타입이 있대...
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("session attribute added!");
        System.out.println("session 추가된 attr: " + event.getName() + ", " + event.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("session attribute replaced!");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("session attribute removed!");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session destroyed!");
    }
}
