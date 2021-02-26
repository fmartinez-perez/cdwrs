package com.codewars.kyu4;

/*
    Task

    Create a RomanNumerals class that can convert a roman numeral to and from an integer value.
    It should follow the API demonstrated in the examples below.
    Multiple roman numeral values will be tested for each helper method.

    Modern Roman numerals are written by expressing each digit separately starting with the left most digit and skipping any digit with a value of zero.
    In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC.
    2008 is written as 2000=MM, 8=VIII; or MMVIII.
    1666 uses each Roman symbol in descending order: MDCLXVI.
    Examples

    RomanNumerals.toRoman(1000) // should return 'M'
    RomanNumerals.fromRoman("M") // should return 1000

    Help

    | Symbol | Value |
    |----------------|
    | I      |  1    |
    | V      |  5    |
    | X      |  10   |
    | L      |  50   |
    | C      |  100  |
    | D      |  500  |
    | M      |  1000 |
 */

public class RomanNumerals {

    private RomanNumerals(){}

    public static String toRoman(int n) {
        StringBuilder romanNumber = new StringBuilder();

        romanNumber.append(convertArabicThousandsToRoman(n))
                .append(convertArabicHundredsToRoman(n))
                .append(convertArabicTentsToRoman(n))
                .append(convertArabicUnitsToRoman(n));

        return romanNumber.toString();

    }

    public static int fromRoman(String romanNumeral) {
        int arabicNumber = 0;

        int actual = 0;
        while(actual < romanNumeral.length()){
            int next = actual+1;
            if(next < romanNumeral.length() && isMinor(romanNumeral.charAt(actual), romanNumeral.charAt(next))){
                arabicNumber = arabicNumber  + convertRomanComposeToArabic(romanNumeral.charAt(actual), romanNumeral.charAt(next));
                actual = next;
            }else{
                arabicNumber = arabicNumber + convertRomanToArabic(romanNumeral.charAt(actual));
            }
            actual++;
        }

        return arabicNumber;
    }

    private static String convertArabicThousandsToRoman(int n){
        return convertArabicToRoman(
                getArabicThousands(n),
                RomanArabic.M.getRomanNumber(),
                "",
                ""
        );
    }

    private static String convertArabicHundredsToRoman(int n){
        return convertArabicToRoman(
                getArabicHundreds(n),
                RomanArabic.C.getRomanNumber(),
                RomanArabic.D.getRomanNumber(),
                RomanArabic.M.getRomanNumber()
        );
    }

    private static String convertArabicTentsToRoman(int n){
        return convertArabicToRoman(
                getArabicTents(n),
                RomanArabic.X.getRomanNumber(),
                RomanArabic.L.getRomanNumber(),
                RomanArabic.C.getRomanNumber()
        );
    }

    private static String convertArabicUnitsToRoman(int n){
        return convertArabicToRoman(
                getArabicUnits(n),
                RomanArabic.I.getRomanNumber(),
                RomanArabic.V.getRomanNumber(),
                RomanArabic.X.getRomanNumber()
        );
    }

    private static String convertArabicToRoman(final int number, final String minRoman,
                                               final String middleRoman, final String maxRoman){
        int units = number;

        if(isNineUnit(units) && !maxRoman.isBlank()){
            return minRoman.concat(maxRoman);
        }

        if(isFourUnit(units) && !minRoman.isBlank()){
            return minRoman.concat(middleRoman);
        }

        StringBuilder romanNumber = new StringBuilder();

        if(isEqualsOrBiggerThanFive(units)){
            romanNumber.append(middleRoman);
            units = units-5;
        }

        romanNumber.append(minRoman.repeat(units));

        return romanNumber.toString();
    }

    private static int getArabicThousands(int n){
        return n / 1000;
    }

    private static int getArabicHundreds(int n){
        return (n%1000)/100;
    }

    private static int getArabicTents(int n){
        return ((n%1000)%100)/10;
    }

    private static int getArabicUnits(int n){
        return ((n%1000)%100)%10;
    }

    private static boolean isFourUnit(final int unit){
        return unit == 4;
    }

    private static boolean isNineUnit(final int unit){
        return unit == 9;
    }

    private static boolean isEqualsOrBiggerThanFive(final int unit){
        return unit >= 5;
    }




    private static boolean isMinor(final char firstChar, final char nextChar){
        return RomanArabic.valueOf(String.valueOf(firstChar)).getArabicNumber() < RomanArabic.valueOf(String.valueOf(nextChar)).getArabicNumber();
    }

    private static Integer convertRomanToArabic(final char roman){
        return RomanArabic.valueOf(String.valueOf(roman)).getArabicNumber();
    }

    private static Integer convertRomanComposeToArabic(final char firstChar, final char nextChar){
        return convertRomanToArabic(nextChar) - convertRomanToArabic(firstChar);
    }

}

enum RomanArabic{
    I(1, "I"),
    V(5, "V"),
    X(10, "X"),
    L(50, "L"),
    C(100, "C"),
    D(500, "D"),
    M(1000, "M");

    private final int arabicNumber;
    private final String romanNumber;

    RomanArabic(final int arabicNumber, final String romanNumber){
        this.arabicNumber = arabicNumber;
        this.romanNumber = romanNumber;
    }

    public int getArabicNumber() {
        return arabicNumber;
    }

    public String getRomanNumber() {
        return romanNumber;
    }
}