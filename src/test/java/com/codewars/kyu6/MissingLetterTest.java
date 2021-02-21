package com.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissingLetterTest {
    @Test
    public void exampleTests() {
        assertEquals('e', MissingLetter.findMissingLetter(new char[] { 'a','b','c','d','f' }));
        assertEquals('P', MissingLetter.findMissingLetter(new char[] { 'O','Q','R','S' }));
    }

    @Test
    public void randomTests() {
        for(int r=0;r<30;r++)
        {
            int len = (int)(Math.random() * 7 + 3);
            int missingIdx = (int)(Math.random() * (len - 2) + 1);
            int start = (int)(Math.random() * (90-len-65) + 65);

            if(Math.random() > 0.5)
            {
                start += 32;
            }
            char missing = (char)(start + missingIdx);
            char[] array = new char[len-1];
            int idx = 0;
            for(int i=0;i<len;i++)
            {
                if(i != missingIdx)
                {
                    array[idx] = (char)(start + i);
                    idx++;
                }
            }

            System.out.println("Array: " + Arrays.toString(array));

            assertEquals(missing, MissingLetter.findMissingLetter(array));
        }
    }
}