package com.vtlab.exercisethree.infra;

import lombok.Getter;

@Getter
public enum Syscode {
  OK("000000","OK."),
  EXCEPTION("888888","Operation Failed"),
  ;

  private String code;

  private String message;

  private Syscode(String code,String message){
    this.code = code;
    this.message = message;
  }
}
