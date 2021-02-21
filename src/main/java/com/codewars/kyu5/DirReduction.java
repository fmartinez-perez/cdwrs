package com.codewars.kyu5;

import java.util.ArrayList;
import java.util.Arrays;

public class DirReduction {
    private static final String NORTH = "NORTH";
    private static final String SOUTH = "SOUTH";
    private static final String EAST = "EAST";
    private static final String WEST = "WEST";

    public static String[] dirReduc(String[] arr) {
        ArrayList<String> directions = new ArrayList(Arrays.asList(arr));

        int i = 0;
        while(i < directions.size() - 1 && directions.size()>1){
            if(isOpposite(directions.get(i), directions.get(i+1))){
                directions.remove(i+1);
                directions.remove(i);
                i = 0;
            }else{
                i++;
            }
        }

        return directions.toArray(new String[]{});
    }

    private static boolean isOpposite(String dirA, String dirB){
        return NORTH.equalsIgnoreCase(dirA) && SOUTH.equalsIgnoreCase(dirB)
                || SOUTH.equalsIgnoreCase(dirA) && NORTH.equalsIgnoreCase(dirB)
                || EAST.equalsIgnoreCase(dirA) && WEST.equalsIgnoreCase(dirB)
                || WEST.equalsIgnoreCase(dirA) && EAST.equalsIgnoreCase(dirB);
    }
}