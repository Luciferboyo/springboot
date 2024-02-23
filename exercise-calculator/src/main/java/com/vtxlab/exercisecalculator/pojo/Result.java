package com.vtxlab.exercisecalculator.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result {
  
  private Integer code;

  private String message;

  //private T data;

  public static Result success(String message){
    return new Result(0,message);
  }

  public static Result error(String message){
    return new Result(9,message);
  }
}
