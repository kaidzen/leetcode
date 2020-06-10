package org.kaidzen.study.leetcode.june2020;

public class Substring {

    public boolean isSubsequence3(String s, String t) {
        if (s.length() == 0) return true;
        int sIdx = 0;
        for (int tIdx = 0; tIdx<t.length(); tIdx++){
            if (t.charAt(tIdx) == s.charAt(sIdx)){
                sIdx++;
            }
            //to stop before end of t, if already found
            if (sIdx == s.length()) return true;
        }
        return sIdx == s.length();
    }

    public boolean isSubsequence2(String s, String t) {
        if (s.length() == 0){ return true;}
        if (t.length() == 0){ return false;}
        if (s.charAt(0) == t.charAt(0)){
            return isSubsequence2(s.substring(1), t.substring(1));
        }else {
            return isSubsequence2(s, t.substring(1));
        }
    }

    //Only for free-ordered characters, just contains in
    public boolean isSubsequence1(String s, String t) {
        char[] alphabet = new char[26];
        for (char ch: t.toCharArray()){
            alphabet[ch - 'a']++;
        }
        int counter = 0;
        for (char ch: s.toCharArray()){
            if (alphabet[ch - 'a'] > 0){
                counter++;
                alphabet[ch - 'a']--;
            }
        }
        return counter == s.length();
    }

    public static void main(String[] args) {
        Substring substrring = new Substring();
//        Input: s = "abc", t = "ahbgdc"
//        Output: true
        System.out.println(substrring.isSubsequence3("abc", "ahbgdc"));
//        Input: s = "axc", t = "ahbgdc"
//        Output: false
        System.out.println(substrring.isSubsequence3("axc", "ahbgdc"));
    }
}
