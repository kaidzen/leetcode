package org.kaidzen.study.leetcode.july2022;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static void main(String[] args) {
        IsomorphicStrings iso = new IsomorphicStrings();

        String s = "egg";
        String t = "add";
        System.out.println("Is isomorphic: " + iso.isIsomorphic(s, t));
        System.out.println("Is isomorphic2: " + iso.isIsomorphic2(s, t));

        String s1 = "foo";
        String t1 = "bar";
        System.out.println("Is isomorphic: " + iso.isIsomorphic(s1, t1));
        System.out.println("Is isomorphic2: " + iso.isIsomorphic2(s1, t1));


        String s2 = "bbbaaaba";
        String t2 = "aaabbbba";
        System.out.println("Is isomorphic: " + iso.isIsomorphic(s2, t2));
        System.out.println("Is isomorphic2: " + iso.isIsomorphic2(s2, t2));

    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        final int length = s.length();

        for (int i = 0; i < length; i++) {
            char firstCh = s.charAt(i);
            char secondCh = t.charAt(i);
            boolean isNot = s.indexOf(firstCh, i + 1) != t.indexOf(secondCh, i + 1);
            if (isNot){
                return false;
            }

        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        final int length = s.length();
        Map<Character, Character> sMap = new HashMap<>(length);
        Map<Character, Character> tMap = new HashMap<>(length);

        for (int i = 0; i < length; i++) {
            Character firstCh = s.charAt(i);
            Character secondCh = t.charAt(i);
            if (sMap.containsKey(firstCh)){
                if (sMap.get(firstCh) != secondCh){
                    return false;
                }
            }
            if (tMap.containsKey(secondCh)){
                if (tMap.get(secondCh) != firstCh){
                    return false;
                }
            }
            sMap.put(firstCh, secondCh);
            tMap.put(secondCh, firstCh);
        }
        return true;
    }


}
