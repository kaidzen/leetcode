package org.kaidzen.study.leetcode.y2023_2024.two_pointers;

public class ValidPalindrome2 {

    private char[] chars;

    public static void main(String[] args) {
        ValidPalindrome2 palindrome2 = new ValidPalindrome2();

        String str = "aba";
        String str2 = "abca";
        String str3 = "deeee";
        String str4 = "eccer";
        System.out.println(palindrome2.validPalindrome(str));
        System.out.println(palindrome2.validPalindrome(str2));
        System.out.println(palindrome2.validPalindrome(str3));
        System.out.println(palindrome2.validPalindrome(str4));

    }

    public boolean validPalindrome(String s) {
        final int length = s.length();
        int l = 0;
        int r = length-1;
        this.chars = s.toCharArray();

        if (isPalindrome(chars, l, r)){
            return true;
        } else {
            return isPalindrome(chars, l+1, r) || isPalindrome(chars, l, r-1);
        }
    }

    private boolean isPalindrome(char[] str, int left, int right){
        if (left > right) return false;
        while (left <= right){
            if (str[left] == str[right]){
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
