package com.vtxlab.exercisecalculator.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class IntoInterceptor implements HandlerInterceptor{
  
  @Override
  public boolean preHandle(HttpServletRequest request,
      HttpServletResponse response, Object handler) throws Exception {
      
        String x = request.getParameter("x");
        String y = request.getParameter("y");

        try{
          Double.parseDouble(x);
          Double.parseDouble(y);
          return true;
        }catch(NumberFormatException e){
          response.setStatus(400);
          return false;
        }
  }
}
