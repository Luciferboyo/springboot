package com.vtxlab.bootcamp.bootcampsbfakedatabase.service.impl;

import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CalculatorService;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.util.Calculate;

@Service
public class CalculatorServiceImpl implements CalculatorService{

  
  @Override
  public double calculate(String x, String y, String operation) {
    double result = 0.0;

    if (x == null || y == null || operation == null) {
        throw new IllegalArgumentException("Input parameters cannot be null");
    }

    operation = operation.toLowerCase();

    switch (operation) {
        case "add":
            result = Calculate.add(x, y);
            break;
        case "multiplication":
            result = Calculate.multiplication(x, y);
            break;
        case "division":
            result = Calculate.division(x, y);
            break;
        case "subtraction":
            result = Calculate.subtraction(x, y);
            break;
        default:
            throw new IllegalArgumentException("Invalid operation: " + operation);
    }

    return result;
  }
}
