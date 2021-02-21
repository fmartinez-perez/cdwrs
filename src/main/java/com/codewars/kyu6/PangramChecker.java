package com.codewars.kyu6;

import java.util.Arrays;

public class PangramChecker {
    public boolean check(String sentence){
        String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "x", "y", "z"};

        return Arrays.asList(abc).stream().allMatch(ch -> sentence.toLowerCase().contains(ch));
    }
}