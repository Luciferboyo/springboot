package com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.CalculatorOperation;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CalculatorService;


@RestController
@RequestMapping(value = "/api/v2")
public class CalculatorController implements CalculatorOperation{

  @Autowired
  CalculatorService calculatorService;
  
  @Override
  public double calculate(String x, String y, String operation) {
    return calculatorService.calculate(x, y, operation);
  }
}
