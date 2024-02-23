package com.vtxlab.bootcamp.bootcampsbfakedatabase.service;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;

public interface CatDatabaseService {
  
  
  Cat getFromStaticMemory(int index);

  Cat setCatToStaticMemry(int index,Cat cat);

  Cat deleteCat(int idx);

  Cat updateCatToStaticMemry(int idx,Cat cat);

  Cat patchCatName(int idx, String name);

  Cat patchCatAge(int idx, int age);

  Cat[] geCats();
}
