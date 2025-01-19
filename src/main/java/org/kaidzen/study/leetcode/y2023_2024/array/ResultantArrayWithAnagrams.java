package org.kaidzen.study.leetcode.y2023_2024.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ResultantArrayWithAnagrams{

    public static void main(String[] args) {
        ResultantArrayWithAnagrams resultant = new ResultantArrayWithAnagrams();

        String[] words = new String[]{"abba","baba","bbaa","cd","cd"};
        System.out.println(resultant.removeAnagrams(words));

        String[] words2 = new String[]{"a","b","c","d","e"};
        System.out.println(resultant.removeAnagrams(words2));
    }

    public List<String> removeAnagrams(String[] words) {
        final Deque<String> stack = new ArrayDeque<>();
            for (int i=words.length-1; i>=0; i--) {
                String word = words[i];
                while (!stack.isEmpty() && isAnagram(stack.peek(), word)) {
                    stack.pop();
                }
                stack.push(word);

            }
        List<String> result = new ArrayList<>();
            while (!stack.isEmpty()){
                result.add(stack.pop());
            }
        return result;
    }

    private boolean isAnagram(String first, String second){
        int  length = first.length();
        if (length != second.length()){
            return false;
        }
        int[] firstI = new int[26];
        int[] secondI = new int[26];

          for(char ch: first.toCharArray()) firstI[ch-'a']++;
        for(char ch: second.toCharArray()) secondI[ch-'a']++;

        for(int i=0; i<firstI.length; i++){
            if(firstI[i] != secondI[i]){
                return false;
            }
        }
        return true;
    }
}
