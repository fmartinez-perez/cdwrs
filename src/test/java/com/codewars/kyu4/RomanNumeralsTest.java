package com.codewars.kyu4;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class RomanNumeralsTest {
    @Test
    public void testToRoman()  {
        assertThat("1 converts to 'I'", RomanNumerals.toRoman(1), is("I"));
        assertThat("2 converts to 'II'", RomanNumerals.toRoman(2), is("II"));
        assertThat("4 converts to 'IV'", RomanNumerals.toRoman(4), is("IV"));
        assertThat("5 converts to 'V'", RomanNumerals.toRoman(5), is("V"));
        assertThat("6 converts to 'VI'", RomanNumerals.toRoman(6), is("VI"));
        assertThat("9 converts to 'IX'", RomanNumerals.toRoman(9), is("IX"));
        assertThat("10 converts to 'X'", RomanNumerals.toRoman(10), is("X"));
        assertThat("353 converts to 'CCCLIII'", RomanNumerals.toRoman(353), is("CCCLIII"));
        assertThat("549 converts to 'DXLIX'", RomanNumerals.toRoman(549), is("DXLIX"));
        assertThat("951 converts to 'CMLI'", RomanNumerals.toRoman(951), is("CMLI"));
        assertThat("971 converts to 'CMLXXI'", RomanNumerals.toRoman(971), is("CMLXXI"));
    }

    @Test
    public void testFromRoman()  {
        assertThat("'I' converts to 1", RomanNumerals.fromRoman("I"), is(1));
        assertThat("'II' converts to 2", RomanNumerals.fromRoman("II"), is(2));
        assertThat("'IV' converts to 4", RomanNumerals.fromRoman("IV"), is(4));
        assertThat("'V' converts to 5", RomanNumerals.fromRoman("V"), is(5));
        assertThat("'VI' converts to 6", RomanNumerals.fromRoman("VI"), is(6));
        assertThat("'IX' converts to 9", RomanNumerals.fromRoman("IX"), is(9));
        assertThat("'X' converts to 10", RomanNumerals.fromRoman("X"), is(10));
        assertThat("'CCCLIII' converts to 353", RomanNumerals.fromRoman("CCCLIII"), is(353));
        assertThat("'DXLIX' converts to 549", RomanNumerals.fromRoman("DXLIX"), is(549));
        assertThat("'CMLI' converts to 951", RomanNumerals.fromRoman("CMLI"), is(951));
        assertThat("'CMLXXI' converts to 971", RomanNumerals.fromRoman("CMLXXI"), is(971));
    }
}