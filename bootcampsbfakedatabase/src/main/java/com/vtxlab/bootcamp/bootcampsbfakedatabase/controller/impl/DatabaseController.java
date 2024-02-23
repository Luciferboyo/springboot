package com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.impl;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.DatabaseOperation;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CatDatabaseService;

//@Controller
//@ResponseBody
@RestController
@RequestMapping(value = "/api/v2")
public class DatabaseController implements DatabaseOperation{

  @Autowired//dependency injection 自动装配
  private CatDatabaseService catDatabaseService;
  
  @Override
  public Cat getCat(int index){
    return catDatabaseService.getFromStaticMemory(index);
  }

  @Override
  public void setCat(int index,String name,int age){
    catDatabaseService.setCatToStaticMemry(index, new Cat(name,age));
  }

  @Override
  public Cat creatCat(int idx, Cat cat) {
    return catDatabaseService.setCatToStaticMemry(idx, cat);
  }

  @Override
  public Boolean deleteCat(int idx) {
    return catDatabaseService.deleteCat(idx) != null;
  }

  @Override
  public Cat updateCat(int idx, Cat cat) {
    if (idx < 0 || idx >= 10) {
      throw new IllegalArgumentException("idx must be between 0 and 9");
    }
    return catDatabaseService.updateCatToStaticMemry(idx, cat);
  }

  @Override
  public Cat patchCatAge(int idx, int age) {
    
    return catDatabaseService.patchCatAge(idx, age);
  }

  @Override
  public Cat patchCatName(int idx, String name) {

    return catDatabaseService.patchCatName(idx,name);
  }

  @Override
  public List<Cat> geCats() {
    // TODO Auto-generated method stub
    return Arrays.stream(catDatabaseService.geCats()).collect(Collectors.toList());
  }
}
