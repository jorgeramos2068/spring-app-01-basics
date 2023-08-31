package com.project.app.springbootweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.project.app.springbootweb.interceptors.TimeElapsedInterceptor;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
  @Autowired
  private TimeElapsedInterceptor timeElapsedInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(timeElapsedInterceptor).addPathPatterns("/app/**");
    // registry.addInterceptor(timeElapsedInterceptor).addPathPatterns("/app/**");
  }
}
