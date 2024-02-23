package com.vtxlab.exercisecalculator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.vtxlab.exercisecalculator.interceptors.IntoInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
  
  @Autowired
  IntoInterceptor intoInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(intoInterceptor);
  }
}
