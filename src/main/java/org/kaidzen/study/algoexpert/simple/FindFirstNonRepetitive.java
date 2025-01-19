package org.kaidzen.study.algoexpert.simple;

public class FindFirstNonRepetitive {

    public static void main(String[] args) {
        FindFirstNonRepetitive find = new FindFirstNonRepetitive();

        String str = "abcdcaf";
        System.out.println(find.firstNonRepeatingCharacter(str));
    }

    public int firstNonRepeatingCharacter(String string) {
        int[] counts = new int[26];

        for (char ch : string.toCharArray()) {
            counts[ch - 'a']++;
        }

        for (int i = 0; i < string.length(); i++) {
            if (counts[string.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
