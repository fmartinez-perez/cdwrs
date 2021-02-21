package com.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighScoreWordTest {
    // Reference implmenetation for random tests
    private static String _high(String s) {
        return Stream.of(s.split(" "))
                .sorted(Comparator.comparing((String a) -> a.chars().map(b -> b - 96).sum()).reversed())
                .findFirst().get();
    }

    @Test
    public void sampleTests() {
        assertEquals("taxi", HighScoreWord.high("man i need a taxi up to ubud"));
        assertEquals("volcano", HighScoreWord.high("what time are we climbing up to the volcano"));
        assertEquals("semynak", HighScoreWord.high("take me to semynak"));
    }

    @Test
    public void randomTests() {
        String chars = "      abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();

        for (int i = 0; i < 100; ++i) {
            String test = IntStream.range(10, random.nextInt(201))
                    .mapToObj(x -> Character.toString(chars.charAt(random.nextInt(chars.length()))))
                    .collect(Collectors.joining()).trim().replaceAll("\\s+", " ");

            String expected = _high(test);
            String actual = HighScoreWord.high(test);

            assertEquals(expected, actual);
        }
    }
}