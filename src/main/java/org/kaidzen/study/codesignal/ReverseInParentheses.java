package org.kaidzen.study.codesignal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReverseInParentheses {

    public static void main(String[] args) {

        ReverseInParentheses reverse = new ReverseInParentheses();

        String s1 = "foo(bar(baz))blim";
        System.out.println(reverse.solution(s1));
        System.out.println(reverse.solution2(s1));

    }

    String solution(String inputString) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<inputString.length(); i++) {
            String symbol = String.valueOf(inputString.charAt(i));
            char close = ')';
            if (!symbol.equals("(")) {
                sb.append(symbol);
            } else if (symbol.equals("(")) {
                int start = i + 1;
                StringBuilder toReverse = new StringBuilder();
                while (close != inputString.charAt(start)) {
                    toReverse.append(inputString.charAt(start));
                    start++;
                }
                sb.append(toReverse.reverse());
                i = start;
            }
        }
        return sb.toString();
    }

    String solution2(String inputString) {
        int firstIdx = getFirstIdx(inputString);
        int lastIdx = getLastIdx(inputString, firstIdx);
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        list.sort(Comparator.naturalOrder());
        while (firstIdx != -1) {
            String reversedString = new StringBuilder(inputString.substring(firstIdx + 1, lastIdx)).reverse().toString();
            String firstPart = inputString.substring(0, firstIdx);
            String secondPart = inputString.substring(lastIdx+1);
            inputString = firstPart + reversedString + secondPart;
            firstIdx = getFirstIdx(inputString);
            lastIdx = getLastIdx(inputString, firstIdx);
        }
        return inputString;
    }

    private static int getLastIdx(String inputString, int firstIdx) {
        return inputString.indexOf(")", firstIdx);
    }

    private static int getFirstIdx(String inputString) {
        return inputString.lastIndexOf("(");
    }
}
