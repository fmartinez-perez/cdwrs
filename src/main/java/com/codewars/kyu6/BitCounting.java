package com.codewars.kyu6;

/*
    Write a function that takes an integer as input, and returns the number of bits that are equal to one in the binary representation of that number. You can guarantee that input is non-negative.

    Example: The binary representation of 1234 is 10011010010, so the function should return 5 in this case
 */
public class BitCounting {

    private BitCounting(){}

    public static int countBits(int n){
        //49 is the value for 1
        return (int)Integer.toBinaryString(n).chars().filter(a -> a==49).count();
    }
}