package com.codewars.kyu4;

/*
    In this kata we want to convert a string into an integer. The strings simply represent the numbers in words.

    Examples:

        "one" => 1
        "twenty" => 20
        "two hundred forty-six" => 246
        "seven hundred eighty-three thousand nine hundred and nineteen" => 783919

    Additional Notes:

        The minimum number is "zero" (inclusively)
        The maximum number, which must be supported is 1 million (inclusively)
        The "and" in e.g. "one hundred and twenty-four" is optional, in some cases it's present and in others it's not
        All tested numbers are valid, you don't need to validate them
 */

public class Parser {

    public static int parseInt(String numStr) {
        final String[] numberParts = obtainSeparatelyRemovingAnd(numStr);

        int actualNumber = 0;
        int previousNumber =0;
        int finalNumber = 0;

        for(String part:numberParts){
            actualNumber = obtainNumber(part);
            finalNumber = buildNumber(previousNumber, actualNumber, finalNumber);
            previousNumber = actualNumber;
        }

        return finalNumber;
    }

    private static String[] obtainSeparatelyRemovingAnd(final String numStr){
        return numStr.toUpperCase().replace(" AND", "").split(" ");
    }

    private static int obtainNumber(final String numberLiteral) {
        if (isComposeNumber(numberLiteral)) {
            return NumericLiteral.valueOf(separateComposeNumber(numberLiteral)[0]).getNumeric()
                    + NumericLiteral.valueOf(separateComposeNumber(numberLiteral)[1]).getNumeric();
        }

        return NumericLiteral.valueOf(numberLiteral).getNumeric();
    }

    private static int buildNumber(final int previousNumber, final int actualNumber, final int finalNumber){
        if(isHundred(actualNumber)){
            return finalNumber - previousNumber + previousNumber * actualNumber;
        }else if(isThousand(actualNumber) || isMillion(actualNumber)){
            return finalNumber  * actualNumber;
        }

        return finalNumber + actualNumber;
    }

    private static boolean isComposeNumber(final String possibleComposeNumber){
        return possibleComposeNumber.contains("-");
    }

    private static boolean isHundred(final int number) {
        return number == NumericLiteral.HUNDRED.getNumeric();
    }

    private  static boolean isThousand(final int number){
        return number == NumericLiteral.THOUSAND.getNumeric();
    }

    private  static boolean isMillion(final int number){
        return number == NumericLiteral.MILLION.getNumeric();
    }

    private static String[] separateComposeNumber(final String composeNumber){
        return composeNumber.split("-");
    }

    enum NumericLiteral{

        ZERO("ZERO", 0),
        A("A", 1),
        ONE("ONE", 1),
        TWO("TWO", 2),
        THREE("THREE", 3),
        FOUR("FOUR", 4),
        FIVE("FIVE", 5),
        SIX("SIX", 6),
        SEVEN("SEVEN", 7),
        EIGHT("EIGHT", 8),
        NINE("NINE", 9),
        TEN("TEN", 10),
        ELEVEN("ELEVEN", 11),
        TWELVE("TWELVE", 12),
        THIRTEEN("THIRTEEN", 13),
        FOURTEEN("FOURTEEN", 14),
        FIFTEEN("FIFTEEN", 15),
        SIXTEEN("SIXTEEN", 16),
        SEVENTEEN("SEVENTEEN", 17),
        EIGHTEEN("EIGHTEEN", 18),
        NINETEEN("NINETEEN", 19),
        TWENTY("TWENTY", 20),
        THIRTY("THIRTY", 30),
        FORTY("FORTY", 40),
        FIFTY("FIFTY", 50),
        SIXTY("SIXTY", 60),
        SEVENTY("SEVENTY", 70),
        EIGHTY("EIGHTY", 80),
        NINETY("NINETY", 90),
        HUNDRED("HUNDRED", 100),
        THOUSAND("THOUSAND", 1000),
        MILLION("MILLION", 1000000);

        private final String literal;
        private final int numeric;

        NumericLiteral (final String literal, final int numeric){
            this.literal = literal;
            this.numeric = numeric;
        }

        public int getNumeric() {
            return numeric;
        }

        public String getLiteral() {
            return literal;
        }
    }
}