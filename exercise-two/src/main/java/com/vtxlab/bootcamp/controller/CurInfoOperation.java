package com.vtxlab.bootcamp.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.bootcamp.dto.gov.VirtualCurrencyDTO;
import com.vtxlab.bootcamp.infra.ApiResponse;

public interface CurInfoOperation {
  
  @GetMapping(value = "/get/coin")
  ApiResponse<List<VirtualCurrencyDTO>> getCoinByIdAndCur(@RequestParam(value = "ids")String id,String currency);
  

  @GetMapping(value = "/get/coins")
  ApiResponse<List<VirtualCurrencyDTO>> getCoinByIdMoreAndCur(@RequestParam List<String> ids,String currency);
  
}
