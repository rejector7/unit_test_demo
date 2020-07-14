package com.example.unit_test_demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CalculatorTest {
    private Calculator calculator = new Calculator();

    @BeforeEach
    void setUp() {
        System.out.println("Begin test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("End test");
    }

    @Test
    void add() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void sub() {
        assertEquals(5, calculator.sub(7, 2));
    }
}