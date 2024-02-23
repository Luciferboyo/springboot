package com.vtxlab.exercisecalculator.util;

public class CaUtil {

  public static double add(String x,String y){
    
    return Double.valueOf(y) + Double.valueOf(x);
  }


  public static double sub(String x,String y){
    
    return Double.valueOf(x) + Double.valueOf(y);
  }

  public static double mul(String x,String y){
    
    return Double.valueOf(x) * Double.valueOf(y);
  }

  public static double div(String x,String y){
    
    return Double.valueOf(x) / Double.valueOf(y);
  }
}
