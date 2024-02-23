package com.vtxlab.bootcamp.bootcampsbfakedatabase.util;

public class Calculate {
  
  public static double add(String x,String y){
    
    return Double.valueOf(y) + Double.valueOf(x);
  }


  public static double subtraction(String x,String y){
    
    return Double.valueOf(x) + Double.valueOf(y);
  }

  public static double multiplication(String x,String y){
    
    return Double.valueOf(x) * Double.valueOf(y);
  }

  public static double division(String x,String y){
    
    return Double.valueOf(x) / Double.valueOf(y);
  }
}
