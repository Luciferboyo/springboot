package com.vtxlab.bootcamp.bootcampsbfakedatabase.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface CalculatorOperation {
  @PostMapping("/x/{x}/y/{y}/operation/{operation}")
  double calculate(@PathVariable String x,@PathVariable String y,@PathVariable String operation);
}
