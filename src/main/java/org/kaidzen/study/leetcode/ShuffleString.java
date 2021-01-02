package org.kaidzen.study.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ShuffleString {

    private static String restoreString(String s, int[] indices) {
        int length = indices.length;
        char[] list = new char[length];

        for (int i = 0; i < length; i++) {
            list[indices[i]] = s.charAt(i);
        }

        return String.valueOf(list);
    }

    private static String restoreString2(String s, int[] indices) {
        String[] chars = s.split("");
        int length = indices.length;
        List<String> list = new ArrayList<>(length);

        for (int i = 0; i<length; i++) {
            list.add("");
        }

        for (int i = 0; i<length; i++) {
            list.add(indices[i], chars[i]);
        }

        return String.join("", list);
    }

    public static void main(String[] args) {
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
        System.out.println(restoreString("codeleet", indices));
        System.out.println(restoreString2("codeleet", indices));
    }

}
