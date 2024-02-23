package com.vtlab.exercisethree.exception;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.vtlab.exercisethree.infra.AipResonpse;
import com.vtlab.exercisethree.infra.Syscode;

@RestControllerAdvice
public class GolbalExceptionHandler {
  

  @ExceptionHandler(Exception.class)
  public AipResonpse handlRestClientException(Exception e){
    e.printStackTrace();
    return AipResonpse.fail(StringUtils.hasLength(e.getMessage())?e.getMessage():Syscode.EXCEPTION.getMessage());
  }
}
