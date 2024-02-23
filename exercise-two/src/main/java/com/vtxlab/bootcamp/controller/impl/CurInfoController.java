package com.vtxlab.bootcamp.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.controller.CurInfoOperation;
import com.vtxlab.bootcamp.dto.gov.VirtualCurrencyDTO;
import com.vtxlab.bootcamp.infra.ApiResponse;
import com.vtxlab.bootcamp.service.CurInfoService;

@RestController
@RequestMapping(value = "/api/v1")
public class CurInfoController implements CurInfoOperation{

  @Autowired
  CurInfoService curInfoService;
  
  @Override
  public ApiResponse<List<VirtualCurrencyDTO>> getCoinByIdAndCur(@RequestParam(value = "ids", required = false)String id,
   @Validated String currency) {
    List<VirtualCurrencyDTO> virtualCurrencyDTOs = curInfoService.getCoinByIdAndCur(id, currency);

    return ApiResponse.success(virtualCurrencyDTOs);
  }

  @Override
  public ApiResponse<List<VirtualCurrencyDTO>> getCoinByIdMoreAndCur(
      List<String> ids, String currency) {
      List<VirtualCurrencyDTO> virtualCurrencyDTOs = curInfoService.getCoinByIdMoreAndCur(ids, currency);
      return ApiResponse.success(virtualCurrencyDTOs);
  }
}
