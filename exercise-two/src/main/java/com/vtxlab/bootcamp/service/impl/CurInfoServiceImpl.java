package com.vtxlab.bootcamp.service.impl;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.dto.gov.VirtualCurrencyDTO;
import com.vtxlab.bootcamp.infra.BcUtil;
import com.vtxlab.bootcamp.infra.Scheme;
import com.vtxlab.bootcamp.mapper.CurInfoMapper;
import com.vtxlab.bootcamp.model.dto.jph.VirtualCurrency;
import com.vtxlab.bootcamp.model.dto.jph.VirtualCurrency.Roi;
import com.vtxlab.bootcamp.service.CurInfoService;


@Service
public class CurInfoServiceImpl implements CurInfoService{
  
  @Autowired
  CurInfoMapper curInfoMapper;

  @Value(value = "${api.jph.domain}")
  private String domain;

  @Value(value = "${api.jph.endpoints}")
  private String userEndpoint;

  @Value(value = "${api.jph.vsCurrency}")
  private String vsCurrency;

  @Value(value = "${api.jph.key}")
  private String key;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<VirtualCurrencyDTO> getCoinByIdAndCur(String id,
      String currency) {
      String currUrl = BcUtil.url(Scheme.HTTPS, domain, userEndpoint,vsCurrency,key);
      VirtualCurrency[] currencies = restTemplate.getForObject(currUrl, VirtualCurrency[].class);

      // for(VirtualCurrency vc:currencies){
      //     if (vc.getId().equals("ethereum")) {
      //       System.out.println();
      //       System.out.println("vc=============================="+vc);
      //     }
      // }
      
      // List<VirtualCurrency> currencies2 = Arrays.stream(currencies)
      //     .filter(e -> {
      //       Roi roi = e.getRoi();
      //       return roi != null && currency.equals(roi.getCurrency());
      //     })
      //     .filter(e -> id == null || id.equals(e.getId()))
      //     .collect(Collectors.toList());

      //     System.out.println("currencies2============================="+currencies2.toString());

      List<VirtualCurrencyDTO> currencyList = Arrays.stream(currencies)
      // .filter(e -> Optional.ofNullable(e.getRoi())
      //         .map(Roi::getCurrency)
      //         .map(currency::equals)
      //         .orElse(false))
      
      .filter(e -> {
        Roi roi = e.getRoi();
        return roi != null && currency.equals(roi.getCurrency()) && (id == null || id.equals(e.getId()));
      })
      .map(e ->curInfoMapper.map(e))
      .collect(Collectors.toList());
      
      System.out.println("currencyList"+currencyList);
      return currencyList;
  }

  @Override
  public List<VirtualCurrencyDTO> getCoinByIdMoreAndCur(List<String> ids,
      String currency) {

      String currUrl = BcUtil.url(Scheme.HTTPS, domain, userEndpoint,vsCurrency,key);
      VirtualCurrency[] currencies = restTemplate.getForObject(currUrl, VirtualCurrency[].class);
      

      List<VirtualCurrencyDTO> currencyList = Arrays.stream(currencies)
              .filter(e -> {
                Roi roi = e.getRoi();
                return roi != null && currency.equals(roi.getCurrency());
              })
              .filter(e -> ids.isEmpty() || ids.contains(e.getId()))
              .map(e -> curInfoMapper.map(e))
              .collect(Collectors.toList());
      return currencyList;
  }
}
