package com.vtxlab.bootcamp.infra;

import lombok.Getter;

@Getter
public enum Syscode {
  OK("000000","OK."),
  NOTFOUND("100000","Not Found."),
  JPH_NOT_AVAILABLE("100001","JsonPlaceHolder API is unavailable"),
  EXCEPTION("888888","Operation Failed"),
  RESTCLIENTEXCEPTION("503","RestClientException - Coingecko Service is unavailable"),
  ;

  private String code;

  private String message;

  private Syscode(String code,String message){
    this.code = code;
    this.message = message;
  }
}
