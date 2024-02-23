package com.vtlab.exercisethree.pojo;

import java.net.URL;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Profile {
  
  String country;

  String currency;

  String estimateCurrency;

  String exchange;

  String finnhubIndustry;

  LocalDate ipo;


  String logo;

  double marketCapitalization;

  String name;

  String phone;

  double shareOutstanding;

  String ticker;
  
  String weburl;

}
