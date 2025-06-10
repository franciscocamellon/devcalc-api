package com.camelloncase.devcalc_api.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService calculator;

    @BeforeEach
    public void setUp() {
        calculator = new CalculatorService();
    }

    @Test
    public void testSum() {
        double result = calculator.sum(5.0, 3.0);
        assertEquals(8.0, result, 0.0001);
    }

    @Test
    public void testSubtraction() {
        double result = calculator.subtraction(10.0, 4.0);
        assertEquals(6.0, result, 0.0001);
    }

    @Test
    public void testMultiplication() {
        double result = calculator.multiplication(2.0, 7.0);
        assertEquals(14.0, result, 0.0001);
    }

    @Test
    public void testDivision() {
        double result = calculator.division(20.0, 5.0);
        assertEquals(4.0, result, 0.0001);
    }

    @Test
    public void testDivisionByZero() {
        double result = calculator.division(10.0, 0.0);
        assertTrue(Double.isInfinite(result));
    }

    @Test
    public void testSqrt() {
        double result = calculator.sqrt(16);
        assertEquals(4.0, result, 0.0001);
    }

    @Test
    public void testNegativeSqrt() {
        double result = calculator.sqrt(-1);
        assertTrue(Double.isNaN(result));
    }
}