package com.codewars.kyu6;

import java.util.Arrays;

/*
    Given a string of words, you need to find the highest scoring word.

    Each letter of a word scores points according to its position in the alphabet: a = 1, b = 2, c = 3 etc.

    You need to return the highest scoring word as a string.

    If two words score the same, return the word that appears earliest in the original string.

    All letters will be lowercase and all inputs will be valid.
 */
public class HighScoreWord {
    public static String high(String s) {
        return Arrays.stream(s.split(" ")).sorted(
                (s1, s2) ->
                        s1.chars().map(a -> a-96).sum() <= s2.chars().map(a -> a-96).sum() ? 1:-1
        ).findFirst().orElse("");
    }
}