package com.vtlab.exercisethree.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtlab.exercisethree.infra.AipResonpse;
import com.vtlab.exercisethree.pojo.Profile;
import com.vtlab.exercisethree.pojo.Quote;

public interface GetInforController {
  
  @GetMapping(value = "/quote")
  AipResonpse<Quote> getQuote(@RequestParam String symbol);
  
  @GetMapping(value = "/profile2")
  AipResonpse<Profile> getConPro(@RequestParam String symbol);
}
