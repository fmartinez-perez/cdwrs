package com.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTest {
    @Test
    public void test1() {
        assertEquals("YES", Line.tickets(new int[] {25, 25, 50}));
    }
    @Test
    public void test2() {
        assertEquals("NO", Line.tickets(new int []{25, 100}));
    }
    @Test
    public void test3() {
        assertEquals("YES", Line.tickets(new int[] {25, 25, 25, 25, 25, 25, 25, 25, 25, 25}));
    }
    @Test
    public void test4() {
        assertEquals("NO", Line.tickets(new int []{50, 50, 50, 50, 50, 50, 50, 50, 50, 50}));
    }
    @Test
    public void test5() {
        assertEquals("NO", Line.tickets(new int []{100, 100, 100, 100, 100, 100, 100, 100, 100, 100}));
    }
    @Test
    public void test6() {
        assertEquals("YES", Line.tickets(new int []{25, 25, 25, 25, 50, 100, 50}));
    }
    @Test
    public void test7() {
        assertEquals("NO", Line.tickets(new int []{50, 100,100}));
    }
    @Test
    public void test8() {
        assertEquals("NO", Line.tickets(new int []{25, 25, 100}));
    }
    @Test
    public void test9() {
        assertEquals("NO", Line.tickets(new int []{25, 25, 25, 25, 25, 25, 25, 50, 50, 50, 100, 100, 100, 100}));
    }
    @Test
    public void test10() {
        assertEquals("NO", Line.tickets(new int []{25,25,50,50,100}));
    }
    @Test
    public void test11() {
        assertEquals("NO", Line.tickets(new int []{25, 25, 25, 25, 25, 100, 100}));
    }
    @Test
    public void test12() {
        assertEquals("NO", Line.tickets(new int []{100, 50, 25, 25}));
    }
    @Test
    public void test13() {
        assertEquals("NO", Line.tickets(new int []{25, 50, 100, 25, 25, 25, 50}));
    }
    @Test
    public void test14() {
        assertEquals("NO", Line.tickets(new int []{25, 50, 25, 50, 100, 25, 25, 50}));
    }
    @Test
    public void test15() {
        assertEquals("YES", Line.tickets(new int []{25, 25, 25, 100}));
    }
    @Test
    public void test16() {
        assertEquals("YES", Line.tickets(new int[] {25, 25, 50, 100}));
    }
}