package com.vtxlab;

import java.util.ArrayList;
import java.util.List;
import com.vtxlab.model.Cat;

public class CatService {
  
  public Cat getCat(){
    //call api,read database
    return new Cat("John", 1);
  }

  public List<Cat> getCats(){
    List<Cat> cats = new ArrayList<>();
    cats.add(new Cat("Peter", 1));
    cats.add(new Cat("John", 1));
    return cats;
  }
}
