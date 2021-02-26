package com.codewars.kyu6;

/*
    Write a function

    TripleDouble(long num1, long num2)

    which takes numbers num1 and num2 and returns 1 if there is a straight triple of a number at any place in num1 and also a straight double of the same number in num2.

    If this isn't the case, return 0
    Examples

    TripleDouble(451999277, 41177722899) == 1 // num1 has straight triple 999s and
                                              // num2 has straight double 99s

    TripleDouble(1222345, 12345) == 0 // num1 has straight triple 2s but num2 has only a single 2

    TripleDouble(12345, 12345) == 0

    TripleDouble(666789, 12345667) == 1
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TripleTrouble {

    private TripleTrouble(){}

    public static int tripleDouble(long num1, long num2)
    {
        String triple = findTriple(num1);

        if(triple.length()>0 && String.valueOf(num2).contains(triple.substring(1))){
            return 1;
        }

        return 0;
    }

    private static String findTriple(final long num){
        Pattern pattern = Pattern.compile("(.)\\1{2}");
        Matcher matcher = pattern.matcher(String.valueOf(num));
        if(matcher.find())
            return matcher.group();

        return "";
    }
}