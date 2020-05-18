package org.kaidzen.study.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnngramsInString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0){
            return list;
        }
        int[] chars = new int[26];
        for(char ch: p.toCharArray()){
            chars[ch - 'a']++;
        }
        int left = 0;
        int rigth = 0;
        int count = p.length();
        while (rigth < s.length()){
            if (chars[s.charAt(rigth++) - 'a']-- >= 1) {
                count--;
            }
            if (count == 0){
                list.add(left);
            }
            if (rigth - left == p.length() && chars[s.charAt(left++) - 'a']++ >= 0){
                count++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
//        Input:
//        s: "cbaebabacd" p: "abc"
//
//        Output: [0, 6]
        List<Integer> anagrams = new FindAllAnngramsInString().findAnagrams("cbaebabacd", "abc");
        System.out.println(anagrams);
    }
}
