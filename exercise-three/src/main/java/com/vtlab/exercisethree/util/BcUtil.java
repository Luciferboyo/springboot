package com.vtlab.exercisethree.util;

import org.springframework.web.util.UriComponentsBuilder;
import com.vtlab.exercisethree.infra.Scheme;

public class BcUtil {
  
  public static String url(Scheme scheme,String domain,String endpoint,String symbol,String token){
    return UriComponentsBuilder.newInstance()
    .scheme(scheme.lowercaseName())
    .host(domain)
    .path(endpoint)
    .queryParam("symbol",symbol)
    .queryParam("token", token)
    .toUriString();
    // symbol=MSFT&token=cna25cpr01qjv5ip3m4gcna25cpr01qjv5ip3m50
  }
}
