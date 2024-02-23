package com.vtlab.exercisethree.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AipResonpse<T> {
  
  private String code;

  private String message;

  private T data;

  public static <E> AipResonpse<E> success(E data){
    return new AipResonpse<E>(Syscode.OK.getCode(),Syscode.OK.getMessage(),data);
  }

  public static<E> AipResonpse<E> fail(String exceptionIntro){
    return new AipResonpse<E>(Syscode.EXCEPTION.getCode(), exceptionIntro, null);
  }

}
