package com.vtlab.exercisethree.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtlab.exercisethree.controller.GetInforController;
import com.vtlab.exercisethree.infra.AipResonpse;
import com.vtlab.exercisethree.pojo.Profile;
import com.vtlab.exercisethree.pojo.Quote;
import com.vtlab.exercisethree.service.GetInforService;


@RestController
@RequestMapping(value = "/stock/finnhub/api/v1")
public class GetInforControllerImpl implements GetInforController{
  
  @Autowired
  GetInforService getInforService;

  @Override
  public AipResonpse<Quote> getQuote(String symbol) {

    Quote quote = getInforService.getQuote(symbol);
    return AipResonpse.success(quote);
  }

  @Override
  public AipResonpse<Profile> getConPro(String symbol) {
    
    Profile profile = getInforService.getConPro(symbol);
    return AipResonpse.success(profile);
  }
}
