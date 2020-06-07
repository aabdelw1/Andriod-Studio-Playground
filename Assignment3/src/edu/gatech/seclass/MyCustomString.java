package edu.gatech.seclass;


import java.util.HashMap;
import java.util.Map;

public class MyCustomString implements MyCustomStringInterface {

    private String string;

    private static final Map<String, String> textToNum = new HashMap<>();

    static {
        textToNum.put("ONE", "1");
        textToNum.put("TWO", "2");
        textToNum.put("THREE", "3");
        textToNum.put("FOUR", "4");
        textToNum.put("FIVE", "5");
        textToNum.put("SIX", "6");
        textToNum.put("SEVEN", "7");
        textToNum.put("EIGHT", "8");
        textToNum.put("NINE", "9");
    }


    public void setString(String string) {
        this.string = string;
    }
    public String getString() {
        return string;
    }

    @Override
    public int countNumbers() {
//        System.out.println(string);
//        String noPeriods = string.replaceAll("\\.", " ");
//        String newString = noPeriods.replaceAll("\\p{Punct}", " ");
//        System.out.println(newString);
//
//        String[] splitString = newString.split(" ");
//        int counter = 0;
//        for (String i : splitString) {
//            try {
//                Integer.parseInt(i);
//            } catch (NumberFormatException e) {
//                counter++;
//            }
//        }
//        return splitString.length - counter;
        int counter = 0;
        boolean check = false;

        for (int j = 0; j < string.length(); j++) {
            if (Character.isDigit(string.charAt(j))) {
                if (!check) {
                    counter++;
                    check = true;
                }
            } else {
                check = false;
            }
        }
        return counter;
    }

    @Override
    public String addNumber(int n, boolean reverse) {

        System.out.println(string);
        if (n < 0) {
            throw new IllegalArgumentException("Negative illegal argument");
        }
//        String newString = string.replaceAll("\\p{Punct}", "");
        String[] splitString = string.split(" ");
        String[] newArray = new String[splitString.length];
        for (int i = 0; i < splitString.length; i++) {
            String str = splitString[i];
            try {
                boolean addPunct = false;
                char punct = 'c';

                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) == '!' || str.charAt(j) == ',' || str.charAt(j) == ';' || str.charAt(j) == '.' || str.charAt(j) == '?' || str.charAt(j) == '-' ||
                            str.charAt(j) == '\'' || str.charAt(j) == '\"' || str.charAt(j) == ':') {
                        punct = str.charAt(j);
                        addPunct = true;
                    }
                }

                int number = Integer.parseInt(str.replaceAll("[\\D]", ""));
                int newNumber = number + n;

                String strnum = Integer.toString(newNumber);
                if (reverse) {
                    strnum = new StringBuilder(strnum).reverse().toString();
                }
                if (addPunct) {
                    strnum = strnum + punct;
                }
                newArray[i] = strnum;
            } catch (NumberFormatException e) {
                newArray[i] = str;
            }
        }
//        System.out.println(Arrays.toString(newArray));
        return String.join(" ", newArray);
    }

    @Override
    public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) throws MyIndexOutOfBoundsException,
            IllegalArgumentException, StringIndexOutOfBoundsException {

        if( string.isEmpty()) {
            throw new IllegalArgumentException("String is undefined or empty");
        }
        if (startPosition < 1 || endPosition < 1) {
            throw new IllegalArgumentException("Start and end postion must be greater than 1");
        }
        if (startPosition > string.length()) {
            throw new IllegalArgumentException("positions cannot exceed length of string");
        }
        if (startPosition >= 1 && startPosition <= endPosition && string != null && endPosition > string.length()){
            throw new MyIndexOutOfBoundsException("End Position must be less than string size");

        }
//        if(endPosition > string.length()) {
//            throw new StringIndexOutOfBoundsException("End Position exceeds final position in string");
//        }
        if (startPosition > endPosition) {
            throw new MyIndexOutOfBoundsException("End Position must be greater than start");
        }

        String subStringy = string.substring(startPosition - 1, endPosition);

        subStringy = subStringy.replaceAll("0", "ZERO");
        subStringy = subStringy.replaceAll("1", "ONE");
        subStringy = subStringy.replaceAll("2", "TWO");
        subStringy = subStringy.replaceAll("3", "THREE");
        subStringy = subStringy.replaceAll("4", "FOUR");
        subStringy = subStringy.replaceAll("5", "FIVE");
        subStringy = subStringy.replaceAll("6", "SIX");
        subStringy = subStringy.replaceAll("7", "SEVEN");
        subStringy = subStringy.replaceAll("8", "EIGHT");
        subStringy = subStringy.replaceAll("9", "NINE");
        subStringy = subStringy.replaceAll("10", "TEN");


        string = string.substring(0, startPosition - 1) + subStringy
                + string.substring(endPosition);

    }
}
