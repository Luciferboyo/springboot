package com.vtxlab.bootcamp.bootcampsbforum.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User2;

public interface RedisOperation {

  @PostMapping(value = "/user")
  User2 createUser(@RequestParam String key, @RequestBody User2 user2)throws JsonProcessingException;

  @GetMapping(value = "/get")
  User2 getUser2(@RequestParam String key) throws JsonProcessingException;
}
