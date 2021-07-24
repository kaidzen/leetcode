package org.kaidzen.study.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RomanianLiterals {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Steven XL", "Steven XVI", "David XI", "Mary XV",
                "Mary XII", "Mary XX", "John MCMXC", "John MDCLXVI");

        System.out.println(sortRoman(names));
    }

    public static List<String> sortRoman(List<String> names) {
        // Write your code here
        return names.stream()
                .map(str -> convert(str))
                .sorted()
                .collect(Collectors.toList());
    }

    private static String convert(String romanianName){
        final String space = " ";
        final String[] split = romanianName.split(space);
        return split[0] + space + decode(split[1]);
    }

    private static int decode(String roman) {
        int result = 0;
        String uRoman = roman.toUpperCase();
        for(int i=0; i<uRoman.length()-1; i++) {
            final int first = decodeSymbol(uRoman.charAt(i));
            if (first < decodeSymbol(uRoman.charAt(i+1))) {
                result -= first;
            } else {
                result += first;
            }
        }
        result += decodeSymbol(uRoman.charAt(uRoman.length()-1));
        return result;
    }

    private static int decodeSymbol(char letter) {
        switch(letter) {
            case 'M': return 1000;
            case 'D': return 500;
            case 'C': return 100;
            case 'L': return 50;
            case 'X': return 10;
            case 'V': return 5;
            case 'I': return 1;
            default: return 0;
        }
    }
}
