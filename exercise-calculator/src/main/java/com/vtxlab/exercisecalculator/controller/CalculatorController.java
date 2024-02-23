package com.vtxlab.exercisecalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CalculatorController {
  @GetMapping("/x/{x}/y/{y}/operation/{operation}")
  String calculate(@PathVariable String x,@PathVariable String y,@PathVariable String operation);
}
