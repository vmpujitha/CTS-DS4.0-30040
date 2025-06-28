package com.cts.testing.service;

import com.cts.demo.service.CalculatorService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    private final CalculatorService calculator = new CalculatorService();

    @Test
    void add_shouldReturnCorrectSum() {
        assertEquals(5, calculator.add(2, 3));
    }
}