package com.vtlab.exercisethree.infra;

public enum Scheme {
  
  HTTP,HTTPS,;

  public String lowercaseName(){
    return this.name().toLowerCase();
  }
}
