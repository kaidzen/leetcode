package org.kaidzen.study.leetcode.y2023.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GroupAnagram {

    public static void main(String[] args) {
        GroupAnagram anagrams = new GroupAnagram();

        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(anagrams.group(strs));
    }

    public List<List<String>> group(String[] strs){

        Map<String, List<String>> groups = new HashMap<>();
        for(String str: strs){
            String key = createSignature(str);
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(str);
        }
        System.out.println(groups.keySet());
        return new ArrayList<>(groups.values());
    }

    private String createSignature(String str) {
        int[] count = new int[26];
        for (char ch: str.toCharArray()) {
            count[ch-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i< count.length; i++){
            if (count[i] != 0){
                sb.append((char) 'a' + i).append(count[i]);
            }
        }
        return sb.toString();
    }

}
