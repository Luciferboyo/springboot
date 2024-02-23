package com.vtxlab.exercisecalculator.service.Impl;

import org.springframework.stereotype.Service;
import com.vtxlab.exercisecalculator.pojo.Result;
import com.vtxlab.exercisecalculator.service.CalculatorService;
import com.vtxlab.exercisecalculator.util.CaUtil;

@Service
public class CalculatorServiceImpl implements CalculatorService{
  
  @Override
  public String calculate(String x, String y, String operation) {
    double temp = 0.0;

    if (x == null || y == null || operation == null) {
        throw new IllegalArgumentException("Input parameters cannot be null");
    }

    operation = operation.toLowerCase();

    switch (operation) {
        case "add":
            temp = CaUtil.add(x, y);
            break;
        case "mul":
            temp  = CaUtil.mul(x, y);
            break;
        case "div":
            temp = CaUtil.div(x, y);
            break;
        case "sub":
            temp = CaUtil.sub(x, y);
            break;
        default:
            Result.error("Invalid operation");
            throw new IllegalArgumentException("Invalid operation: " + operation);
    }

    return String.valueOf(temp);
  }
}
