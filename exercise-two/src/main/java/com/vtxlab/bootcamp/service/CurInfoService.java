package com.vtxlab.bootcamp.service;

import java.util.List;
import com.vtxlab.bootcamp.dto.gov.VirtualCurrencyDTO;

public interface CurInfoService {
  
  List<VirtualCurrencyDTO> getCoinByIdAndCur(String id,String currency);
  
  List<VirtualCurrencyDTO> getCoinByIdMoreAndCur(List<String> ids,String currency);
}
