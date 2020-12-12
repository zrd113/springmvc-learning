package org.zrd.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author zrd
 * @Date 2020/12/12
 */
@Component
public class MyInterceptor1 implements HandlerInterceptor {

    //该方法在controller之前调用，preHandler会按照生命顺序执行，返回false时，后续的拦截器和controller都不执行，返回true时执行下一个preHandler
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor1:preHandle");
        return true;
    }

    //controller调用后执行，会在DispatcherServlet进行试图返回渲染前调用，所以可以对ModelAndView进行操作。先声明的拦截器postHandler后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor1:postHandle");
    }

    //preHandler返回true该方法才会执行，先声明的拦截器afterCompletion后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor1:afterCompletion");
    }
}
