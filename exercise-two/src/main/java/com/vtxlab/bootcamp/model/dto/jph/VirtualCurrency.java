package com.vtxlab.bootcamp.model.dto.jph;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@ToString
@EqualsAndHashCode
@Builder
@Setter
public class VirtualCurrency {

  @JsonProperty("id")
  String id;

  @JsonProperty("symbol")
  String symbol;

  @JsonProperty("name")
  String name;

  @JsonProperty("image")
  String image;

  @JsonProperty("current_price")
  double currentPrice;

  @JsonProperty("market_cap")
  long marketCap;

  @JsonProperty("market_cap_rank")
  long marketCapRank;
  
  @JsonProperty("fully_diluted_valuation")
  long fullyDilutedValuation;

  @JsonProperty("total_volume")
  long totalVolume;

  @JsonProperty("high_24h")
  double high24h;

  @JsonProperty("low_24h")
  double low24h;

  @JsonProperty("price_change_24h")
  double priceChange24h;

  @JsonProperty("market_cap_change_24h")
  long marketCapChange24h;

  @JsonProperty("price_change_percentage_24h")
  double marketCapChangePercentage24h;

  @JsonProperty("circulating_supply")
  long circulatingSupply;

  @JsonProperty("total_supply")
  long totalSupply;

  @JsonProperty("max_supply")
  long maxSupply;

  @JsonProperty("ath")
  long ath;

  @JsonProperty("ath_change_percentage")
  double athChangePercentage;

  @JsonProperty("ath_date")
  LocalDateTime athDate;

  long atl;

  @JsonProperty("atl_change_percentage")
  double atlChangePercentage;

  @JsonProperty("atl_date")
  LocalDateTime atlDate;

  Roi roi; 

  @JsonProperty("last_updated")
  LocalDateTime lastUpdated;
  

  @Getter
  @ToString
  public static class Roi{

    private double times;

    @NotEmpty
    private String currency;

    private double percentage;
  }
}
