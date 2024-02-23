package com.vtlab.exercisethree.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtlab.exercisethree.infra.Scheme;
import com.vtlab.exercisethree.pojo.Profile;
import com.vtlab.exercisethree.pojo.Quote;
import com.vtlab.exercisethree.service.GetInforService;
import com.vtlab.exercisethree.util.BcUtil;

@Service
public class GetInforServiceImpl implements GetInforService{

  @Value(value = "${api.jph.domain}")
  private String domain;

  @Value(value = "${api.jph.endpointQuote}")
  private String endpointQuote;

  @Value(value = "${api.jph.token}")
  private String token;

  @Value(value = "${api.jph.endpointProfile}")
  private String endpointProfile;

  @Autowired
  RestTemplate restTemplate;

  @Override
  public Quote getQuote(String symbol) {
    String quoteUrl = BcUtil.url(Scheme.HTTPS,domain,endpointQuote,symbol,token);
    Quote quote = restTemplate.getForObject(quoteUrl, Quote.class);
    return quote;
  }

  @Override
  public Profile getConPro(String symbol) {
    String profileUrl = BcUtil.url(Scheme.HTTPS,domain,endpointProfile,symbol,token);
    Profile profile = restTemplate.getForObject(profileUrl, Profile.class);
    return profile;
  }
}
