package com.vtxlab.bootcamp.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vtxlab.bootcamp.dto.gov.VirtualCurrencyDTO;
import com.vtxlab.bootcamp.model.dto.jph.VirtualCurrency;

@Component
public class CurInfoMapper {
  
  @Autowired
  private ModelMapper modelMapper;

  public VirtualCurrencyDTO map(VirtualCurrency currency){
  
    return this.modelMapper.map(currency, VirtualCurrencyDTO.class);
  }

}
