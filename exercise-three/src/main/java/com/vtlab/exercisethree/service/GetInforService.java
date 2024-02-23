package com.vtlab.exercisethree.service;

import com.vtlab.exercisethree.pojo.Profile;
import com.vtlab.exercisethree.pojo.Quote;

public interface GetInforService {
  
  Quote getQuote(String symbol);

  Profile getConPro(String symbol);
}
