package com.abdellah.colivraison.app.prod.common.validation.helper;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    private static Validator<String> validator;
    @BeforeAll
    static void setUp() {
        validator = new Validator<>();
    }


    @Test
    void isBooleanTester() {
        assertTrue(validator.isBoolean("true"));
        assertTrue(validator.isBoolean("false"));
        assertTrue(validator.isBoolean("1"));
        assertTrue(validator.isBoolean("0"));
        assertFalse(validator.isBoolean("True"));
        assertFalse(validator.isBoolean("False"));
        assertFalse(validator.isBoolean("TRUE"));
        assertFalse(validator.isBoolean("FALSE"));
        assertFalse(validator.isBoolean("tRue"));
        assertFalse(validator.isBoolean("fAlse"));
        assertFalse(validator.isBoolean("fjjid"));
        assertFalse(validator.isBoolean("12"));
        assertFalse(validator.isBoolean("-1"));

    }

    @Test
    void isNumber() {
        assertTrue(validator.isNumber("123"));
        assertTrue(validator.isNumber("0"));
        assertTrue(validator.isNumber("-123"));
        assertTrue(validator.isNumber("3.14"));
        assertTrue(validator.isNumber("-3.14"));
        assertTrue(validator.isNumber("123.456"));
        assertTrue(validator.isNumber("-123.456"));
        assertFalse(validator.isNumber("abc"));
        assertFalse(validator.isNumber("12a"));
        assertFalse(validator.isNumber("1.2.3"));
        assertFalse(validator.isNumber("12-3"));
        assertFalse(validator.isNumber("12+3"));
    }

}