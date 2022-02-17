package org.kaidzen.study.leetcode.june2020;

public class ReverseString {

    public char[] reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            swap(s, start, end);
            start++;
            end--;
        }
        return s;
    }

    private void swap(char[] str, int one, int two) {
        char temp = str[one];
        str[one] = str[two];
        str[two] = temp;
    }

    public static void main(String[] args) {
        ReverseString revers = new ReverseString();
//        Input: ["h","e","l","l","o"]
//        Output: ["o","l","l","e","h"]
        System.out.println(revers.reverseString("hello".toCharArray()));
//        Input: ["H","a","n","n","a","h"]
//        Output: ["h","a","n","n","a","H"]
        System.out.println(revers.reverseString("Hannah".toCharArray()));
    }
}
