package com.camelloncase.devcalc_api.services;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public CalculatorService() {}

    public double sum(double a, double b) {
        return a + b;
    }

    public double subtraction(double a, double b) {
        return a - b;
    }

    public double division(double a, double b) {
        return a / b;
    }

    public double multiplication(double a, double b) {
        return a * b;
    }

    public double sqrt(double a) {
        return Math.sqrt(a);
    }
}
