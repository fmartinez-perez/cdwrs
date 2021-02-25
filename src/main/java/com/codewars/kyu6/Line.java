package com.codewars.kyu6;

/*
    The new "Avengers" movie has just been released! There are a lot of people at the cinema box office standing in a huge line. Each of them has a single 100, 50 or 25 dollar bill. An "Avengers" ticket costs 25 dollars.

    Vasya is currently working as a clerk. He wants to sell a ticket to every single person in this line.

    Can Vasya sell a ticket to every person and give change if he initially has no money and sells the tickets strictly in the order people queue?

    Return YES, if Vasya can sell a ticket to every person and give change with the bills he has at hand at that moment. Otherwise return NO.
    Examples:

    Line.Tickets(new int[] {25, 25, 50}) // => YES
    Line.Tickets(new int[] {25, 100}) // => NO. Vasya will not have enough money to give change to 100 dollars
    Line.Tickets(new int[] {25, 25, 50, 50, 100}) // => NO. Vasya will not have the right bills to give 75 dollars of change ((you can't make two bills of 25 from one of 50)
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Line {
    private static final int PRICE = 25;

    private static ArrayList<Integer> changes;

    public static String Tickets(int[] peopleInLine){
        changes = new ArrayList<>();

        for(int paid:peopleInLine){
            if(PRICE == paid){
                addChange(paid);
            }else{
                int changeDebt = paid - PRICE;
                if(!returnChange(changeDebt)){
                    return "NO";
                }else{
                    addChange(paid);
                }
            }
        }

        return "YES";
    }

    private static void addChange(final int money){
        changes.add(money);
        Collections.sort(changes, Comparator.reverseOrder());
    }

    private static boolean returnChange(final int debt){
        int partialDebt = debt;
        while(partialDebt > 0){
            if(!exactChangePosible(partialDebt)){
                partialDebt = partialDebt - PRICE;
                if(exactChangePosible(PRICE)){
                    changes.remove(changes.indexOf(PRICE));
                }else{
                    return false;
                }

                if(exactChangePosible(partialDebt)){
                    changes.remove(changes.indexOf(partialDebt));
                    partialDebt = 0;
                }
            }else{
                changes.remove(changes.indexOf(partialDebt));
                partialDebt = 0;
            }
        }

        return true;
    }

    private static boolean exactChangePosible(final int debt){
        return changes.contains(debt);
    }
}