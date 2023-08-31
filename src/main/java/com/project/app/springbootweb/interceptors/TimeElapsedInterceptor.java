package com.project.app.springbootweb.interceptors;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TimeElapsedInterceptor implements HandlerInterceptor {
  private static final Logger logger = LoggerFactory.getLogger(TimeElapsedInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    logger.info("TimeElapsedInterceptor: preHandle()");
    Long startTime = System.currentTimeMillis();
    request.setAttribute("startTime", startTime);
    // Simulating a delay
    Random random = new Random();
    Integer delay = random.nextInt(500);
    Thread.sleep(delay);
    // Return
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      @Nullable ModelAndView modelAndView) throws Exception {
    Long endTime = System.currentTimeMillis();
    Long startTime = (Long) request.getAttribute("startTime");
    Long timeElapsed = endTime - startTime;
    // This validation is important to avoid errors while loading other
    // resources (such as CSS, JS and others)
    if (handler instanceof HandlerMethod && modelAndView != null) {
      // Pass value to the view
      modelAndView.addObject("timeElapsed", timeElapsed);
    }
    logger.info("TimeElapsedInterceptor: postHandle()");
  }
}
