package com.example.galadarbs

import org.junit.Test

import org.junit.Assert.*

class CalculatorUnitTest {
    private val calculator = Calculator()

    @Test
    fun empty() {
        val string = ""
        val expectedResult = emptyList<String>()
        val result = calculator.calculateCharFrequency(string)
        assertEquals(result,expectedResult)
    }

    @Test
    fun notEmpty() {
        val string = "a"
        val expectedResult = emptyList<String>()
        val result = calculator.calculateCharFrequency(string)
        assertNotEquals(result,expectedResult)
    }

    @Test
    fun one() {
        val string = "a"
        val expectedResult = arrayOf("a - 100.0%").toList();
        val result = calculator.calculateCharFrequency(string)
        assertEquals(result,expectedResult)
    }

    @Test
    fun foreignChar() {
        val string = "자"
        val expectedResult = arrayOf("자 - 100.0%").toList();
        val result = calculator.calculateCharFrequency(string)
        assertEquals(result,expectedResult)
    }

    @Test
    fun multiple_simple() {
        val string = "aabbb"
        val expectedResult = arrayOf("a - 40.0%","b - 60.0%").toList();
        val result = calculator.calculateCharFrequency(string)
        assertEquals(result,expectedResult)
    }

    @Test
    fun multiple_complex() {
        val string = "aabbbc"
        val expectedResult = arrayOf("a - 33.33%","b - 50.0%","c - 16.67%").toList();
        val result = calculator.calculateCharFrequency(string)
        assertEquals(result,expectedResult)
    }
}