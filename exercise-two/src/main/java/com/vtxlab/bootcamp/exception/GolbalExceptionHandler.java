package com.vtxlab.bootcamp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
import com.vtxlab.bootcamp.infra.ApiResponse;
import com.vtxlab.bootcamp.infra.Syscode;


@RestControllerAdvice
public class GolbalExceptionHandler {
  

  @ExceptionHandler(RestClientException.class)
  @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
  public ApiResponse handleRestClientException(Exception e){
    e.printStackTrace();
    //return ApiResponse.fail(StringUtils.hasLength(e.getMessage())?e.getMessage():
    //Syscode.EXCEPTION.getMessage());

    return ApiResponse.fail(Syscode.RESTCLIENTEXCEPTION.getMessage());
  }


  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
  public ApiResponse handleException(Exception e){
    e.printStackTrace();
    return ApiResponse.fail(StringUtils.hasLength(e.getMessage())?e.getMessage():Syscode.EXCEPTION.getMessage());
  }
}
