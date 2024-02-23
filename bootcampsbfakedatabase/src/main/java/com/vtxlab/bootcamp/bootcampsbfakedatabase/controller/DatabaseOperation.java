package com.vtxlab.bootcamp.bootcampsbfakedatabase.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;

public interface DatabaseOperation {
  
  @GetMapping(value = "/cat/{idx}")
  Cat getCat(@PathVariable(name = "idx")int index);

  @GetMapping(value = "/cats")
  List<Cat> geCats();

  @GetMapping(value = "/cat/index/{index}/name/{name}/age/{age}")
  void setCat(@PathVariable int index,@PathVariable String name, @PathVariable int age);

  //
  @PostMapping(value = "/cat/{idx}")
  Cat creatCat(@PathVariable int idx,@RequestBody Cat cat);

  @DeleteMapping(value = "/cat/{idx}")
  Boolean deleteCat(@PathVariable int idx);

  @PutMapping(value = "/cat/{idx}")
  Cat updateCat(@PathVariable int idx, @RequestBody Cat cat);

  @PatchMapping(value = "/cat/{idx}/name/{name}")
  Cat patchCatName(@PathVariable int idx, @PathVariable String name);

  @PatchMapping(value = "/cat/{idx}/age/{age}")
  Cat patchCatAge(@PathVariable int idx, @PathVariable int age);
}
