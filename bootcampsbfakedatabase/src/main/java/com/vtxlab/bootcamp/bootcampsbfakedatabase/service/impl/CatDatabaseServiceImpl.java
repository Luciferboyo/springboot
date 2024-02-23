package com.vtxlab.bootcamp.bootcampsbfakedatabase.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.database.CatDatabase;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CatDatabaseService;


@Service
public class CatDatabaseServiceImpl implements CatDatabaseService{
  //Objectives of Service
  //1.Data source
  //2.The service you are going to provide
  public Cat getFromStaticMemory(int index){

    return CatDatabase.getCat(index);
  }

  public Cat setCatToStaticMemry(int index, Cat cat){
    CatDatabase.setCat(index, cat);
    return cat;
  }

  @Override
  public Cat deleteCat(int idx) {
    Cat cat = CatDatabase.getCat(idx);
    if (cat == null) {
      return null;
    }
    CatDatabase.setCat(idx, cat);
    return cat; 
  }

  @Override
  public Cat updateCatToStaticMemry(int idx, Cat cat) {
    if (CatDatabase.getCat(idx) != null) {
      CatDatabase.setCat(idx, cat);
      return cat;
    }
    return null;
  }

  @Override
  public Cat patchCatName(int idx, String name) {
    Cat cat = CatDatabase.getCat(idx);
    if (cat == null) {
      return null;
    }
    cat.setName(name);
    CatDatabase.setCat(idx, cat);
    return cat;
  }

  @Override
  public Cat patchCatAge(int idx, int age) {
    Cat cat = CatDatabase.getCat(idx);
    if (cat == null) {
      return null;
    }
    cat.setAge(age);
    CatDatabase.setCat(idx, cat);
    return cat;
  }

  @Override
  public Cat[] geCats() {
    return CatDatabase.geCats();
  }
}
