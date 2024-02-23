package com.vtlab.exercisethree.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Quote {
  
  double c;

  double d;

  double dp;

  double h;
  
  double l;

  double o;

  double pc;

  double t;

}
