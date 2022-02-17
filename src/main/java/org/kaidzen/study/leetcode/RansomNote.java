package org.kaidzen.study.leetcode;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[256];
        for (char ch : magazine.toCharArray()) {
            chars[ch]++;
        }
        int noteLength = ransomNote.length();
        for (char ch : ransomNote.toCharArray()) {
            if (chars[ch] > 0) {
                noteLength--;
                chars[ch]--;
            }
        }
        return noteLength == 0;
    }

    public static void main(String[] args) {
        RansomNote note = new RansomNote();
        System.out.println(note.canConstruct("a", "b")); // false
        System.out.println(note.canConstruct("aa", "ab")); // false
        System.out.println(note.canConstruct("aa", "aab")); // true
    }
}
