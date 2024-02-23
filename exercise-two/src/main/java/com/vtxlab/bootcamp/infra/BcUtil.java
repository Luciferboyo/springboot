package com.vtxlab.bootcamp.infra;

import org.springframework.web.util.UriComponentsBuilder;

public class BcUtil {
  
  public static String url(Scheme scheme,String domain,String endpoint,String vsCurrency,String key){
    return UriComponentsBuilder.newInstance()
      .scheme(scheme.lowercaseName())
      .host(domain)
      .path(endpoint)
      .queryParam("vs_currency", vsCurrency)
      .queryParam("x_cg_demo_api_key", key)
      .toUriString();
  }
}
