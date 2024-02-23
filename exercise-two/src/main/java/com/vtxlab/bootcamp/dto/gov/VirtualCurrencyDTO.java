package com.vtxlab.bootcamp.dto.gov;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VirtualCurrencyDTO {
  @JsonProperty("ids")
  String id;
  String symbol;
  String name;
  @JsonProperty("high_24h")
  double high24h;
  @JsonProperty("low_24h")
  double low24h;

}
