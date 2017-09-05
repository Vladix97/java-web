package com.filters.interceptors;

import com.filters.entities.Log;
import com.filters.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class LogInterceptor extends HandlerInterceptorAdapter {

    private final LogService logService;

    @Autowired
    public LogInterceptor(LogService logService) {
        this.logService = logService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("preHandleTime", System.currentTimeMillis());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        request.setAttribute("postHandle", System.currentTimeMillis());
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long current = System.currentTimeMillis();
        long actionTime = current - (long) request.getAttribute("postHandle");
        long overallTime = current - (long) request.getAttribute("preHandleTime");

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        String message = String.format("[%s - %s] Action Execute Time: %d ms, Overall Execute Time: %d ms", handlerMethod.getBean().getClass(),
                handlerMethod.getMethod().getName(),
                actionTime, overallTime);

        Log log = new Log(message, new Date());
        this.logService.create(log);
    }
}
