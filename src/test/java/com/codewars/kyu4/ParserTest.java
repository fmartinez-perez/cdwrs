package com.codewars.kyu4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    @Test
    public void fixedTests() {
        assertEquals(246 , Parser.parseInt("two hundred forty-six"));
        assertEquals(1 , Parser.parseInt("one"));
        assertEquals(20 , Parser.parseInt("twenty"));
        assertEquals(123456 , Parser.parseInt("one hundred twenty-three thousand four hundred fifty-six"));
        assertEquals(1000000 , Parser.parseInt("one million"));

    }
}