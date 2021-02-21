package com.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrimeTest {
    @Test
    public void testBasic() {
        assertFalse(Prime.isPrime(0), "0  is not prime");
        assertFalse(Prime.isPrime(1), "1  is not prime");
        assertTrue (Prime.isPrime(2), "2  is prime");
        assertTrue (Prime.isPrime(73), "73 is prime");
        assertFalse(Prime.isPrime(75), "75 is not prime");
        assertFalse(Prime.isPrime(-1), "-1 is not prime");
    }

    @Test
    public void testPrime() {
        assertTrue(Prime.isPrime(3),"3 is prime");
        assertTrue(Prime.isPrime(5), "5 is prime");
        assertTrue(Prime.isPrime(7), "7 is prime");
        assertTrue(Prime.isPrime(41), "41 is prime");
        assertTrue(Prime.isPrime(5099), "5099 is prime");
    }

    @Test
    public void testNotPrime() {
        assertFalse(Prime.isPrime(4), "4 is not prime");
        assertFalse(Prime.isPrime(6), "6 is not prime");
        assertFalse(Prime.isPrime(8), "8 is not prime");
        assertFalse(Prime.isPrime(9), "9 is not prime");
        assertFalse(Prime.isPrime(45), "45 is not prime");
        assertFalse(Prime.isPrime(-5), "-5 is not prime");
        assertFalse(Prime.isPrime(-8), "-8 is not prime");
        assertFalse(Prime.isPrime(-41), "-41 is not prime");
    }

    private static final Random rnd = new Random();
    private static final int MAX = 2_000_000_000;

    @Test
    public void testRandom() {

        List<TestCaseSpec> testCases = new ArrayList<>();

        try {

            //prime numbers
            for(int i=0; i<500; ++i) {
                int num = BigInteger.valueOf(rnd.nextInt(MAX)).nextProbablePrime().intValueExact();
                testCases.add(TestCaseSpec.make(num, true));
            }

            //composite numers (odd and even)
            for(int i=0; i<450; ++i) {
                int p1 = BigInteger.valueOf(rnd.nextInt(MAX)).nextProbablePrime().intValueExact();
                int p2 = BigInteger.valueOf(p1).nextProbablePrime().intValueExact();
                int num = rnd.nextInt(p2-p1-1) + p1 + 1;
                testCases.add(TestCaseSpec.make(num, false));
            }

            //squares of a prime
            final int ms = (int)Math.sqrt(MAX) - 1000;
            for(int i=0; i<40; ++i) {
                int p1 = BigInteger.valueOf(rnd.nextInt(ms)).nextProbablePrime().intValueExact();
                int num = p1*p1;
                testCases.add(TestCaseSpec.make(num, false));
            }

            //negative numbers
            for(int i=0; i<10; ++i) {
                int p1 = BigInteger.valueOf(rnd.nextInt(ms)).nextProbablePrime().intValueExact();
                int num = -p1;
                testCases.add(TestCaseSpec.make(num, false));
            }

        } catch(ArithmeticException ex) {
            throw new RuntimeException("Error occured when generating a test case. Please retry or raise the kata issue and paste the stack trace.", ex);
        }

        Collections.shuffle(testCases);
        for(TestCaseSpec testCase : testCases) {

            boolean expected = testCase.isPrime;
            boolean actual = Prime.isPrime(testCase.num);

            if(expected) {
                assertTrue(actual, testCase.num + " is prime");
            } else {
                assertFalse(actual, testCase.num + " is not prime");
            }
        }
    }

    private static class TestCaseSpec {
        int num;
        boolean isPrime;

        public static TestCaseSpec make(int num, boolean isPrime) {
            TestCaseSpec testCase = new TestCaseSpec();
            testCase.isPrime = isPrime;
            testCase.num = num;
            return testCase;
        }
    }
}