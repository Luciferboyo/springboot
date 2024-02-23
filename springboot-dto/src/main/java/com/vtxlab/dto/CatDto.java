package com.vtxlab.dto;


public class CatDto {

  private String description;//cat name:John,cat age:1

  private String logo;

  public CatDto(String description,String logo){
    this.description = description;
    this.logo = logo;
    
  }
}