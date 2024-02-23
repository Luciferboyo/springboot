package com.vtxlab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.vtxlab.dto.CatDto;
import com.vtxlab.model.Cat;

public class CatController {
  
  public CatDto getCat(){
    Cat cat  = new CatService().getCat();
    String description = "Cat Name:"+cat.getName();
    CatDto catDto = new CatDto(description, "Apple");
    return catDto;
  }

  public Map<String,Integer> getCats(){
    List<Cat> cats = new CatService().getCats();
    String message = "There are many cats!";
    int number = cats.size();
    Map<String,Integer> map = new HashMap<>();
    map.put(message, number);
    return  map;
  }

  public List<Cat> getCatList(){
    
    return new CatService().getCats();
  }

}
