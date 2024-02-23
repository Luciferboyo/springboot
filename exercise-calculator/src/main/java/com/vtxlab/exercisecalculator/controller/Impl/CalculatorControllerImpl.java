package com.vtxlab.exercisecalculator.controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.exercisecalculator.service.CalculatorService;

@RestController
@RequestMapping(value = "/api/v2")
public class CalculatorControllerImpl implements CalculatorService{
  
  @Autowired
  CalculatorService calculatorService;
  
  @Override
  public String calculate(String x, String y, String operation) {
    return calculatorService.calculate(x, y, operation);
  }
}
