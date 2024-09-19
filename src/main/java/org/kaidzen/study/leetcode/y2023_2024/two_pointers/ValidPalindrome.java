package org.kaidzen.study.leetcode.y2023_2024.two_pointers;

import java.util.stream.IntStream;

public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome valid = new ValidPalindrome();

        String str = "A man, a plan, a canal: Panama";
        System.out.println(valid.isPalindrome(str));
        System.out.println(valid.isPalindrome2(str));
        System.out.println(valid.isAlphaNumeric('$'));

    }

    public boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length()-1;
        String checked = str.toLowerCase();
        while (left < right){
            while (left<right && !isAlphaNumeric(checked.charAt(left))){
                left++;
            }
            while (right>left && !isAlphaNumeric(checked.charAt(right))){
                right--;
            }
            if (checked.charAt(left) != checked.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        String checked = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0;
        int right = checked.length()-1;
        while (left <= right){
            if (checked.charAt(left) != checked.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    private boolean isAlphaNumeric(char ch) {
        final IntStream capitalChars = IntStream.rangeClosed(Character.getNumericValue('A'), Character.getNumericValue('Z'));
        final IntStream smallChars = IntStream.rangeClosed(Character.getNumericValue('a'), Character.getNumericValue('z'));
        IntStream alphaChars = IntStream.concat(capitalChars, smallChars);
        final IntStream digitChars = IntStream.rangeClosed(Character.getNumericValue('0'), Character.getNumericValue('9'));
        IntStream allAlphaNumChars = IntStream.concat(alphaChars, digitChars);

        return allAlphaNumChars.anyMatch(value -> value == Character.getNumericValue(ch));
    }
}
