package com.vtxlab.bootcamp.infra;


public enum Scheme {
  HTTPS,HTTP,;

  public String lowercaseName(){
    return this.name().toLowerCase();
  }
}
