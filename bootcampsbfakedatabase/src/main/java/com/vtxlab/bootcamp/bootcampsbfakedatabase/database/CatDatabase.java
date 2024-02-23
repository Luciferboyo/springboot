package com.vtxlab.bootcamp.bootcampsbfakedatabase.database;

import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;

public class CatDatabase {
  
  private static Cat[] cats;

  private static final int dbLength = 10;

  static{
    cats = new Cat[10];
    cats[0] = new Cat("John", 2);
    cats[1] = new Cat("Mary", 1);
  }

  public static Cat getCat(int index){
    if (index < 0 || index > dbLength-1) {
      throw new IllegalArgumentException("index must be between 0 and 9");
    }
    return cats[index];
  }

  public static void setCat(int index,Cat cat){
    if (index < 0 || index > dbLength-1) {
      throw new IllegalArgumentException("index must be between 0 and 9");
    }
    cats[index] = cat;
  }

  public static Cat[] geCats(){
    return cats;
  }
}
