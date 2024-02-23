package com.vtxlab.bootcamp.bootcampsbforum.controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bootcampsbforum.controller.RedisOperation;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User2;
import com.vtxlab.bootcamp.bootcampsbforum.service.RedisService;

@RestController
@RequestMapping(value = "/redis")
public class RedisController implements RedisOperation{
  

  @Autowired
  private RedisService redisService;
  
  @Override
  public User2 createUser(String key ,User2 user2) throws JsonProcessingException{
    
    return redisService.createUser(key, user2);
  }

  @Override
  public User2 getUser2(String key) throws JsonProcessingException{
    return redisService.getUser2(key);
  }
}
