package org.kaidzen.leetcode;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.List;

public class BackspaceStringCompare2 {

    public static void main(String[] args) {
        List<Pair<String, String>> list = Arrays.asList(
                new Pair<>("ab#c", "ad#c"),
                new Pair<>("ab##", "c#d#"),
                new Pair<>("a##c", "#a#c"),
                new Pair<>("a#c", "b")
        );
        BackspaceStringCompare2 comparator = new BackspaceStringCompare2();

        list.forEach(pair -> System.out.println(comparator.backspaceCompare(pair.getKey(), pair.getValue())));
    }

    public boolean backspaceCompare(String S, String T) {
        int sPointer = S.length() - 1;
        int tPointer = T.length() - 1;

        int sSkips = 0;
        int tSkips = 0;

        while (sPointer >= 0 || tPointer >= 0) {
            while (sPointer >= 0) {
                if (S.charAt(sPointer) == '#') {
                    sSkips++;
                    sPointer--;
                } else if (sSkips > 0) {
                    sSkips--;
                    sPointer--;
                } else {
                    break;
                }
            }
            while (tPointer >= 0) {
                if (T.charAt(tPointer) == '#') {
                    tSkips++;
                    tPointer--;
                } else if (tSkips > 0) {
                    tSkips--;
                    tPointer--;
                } else {
                    break;
                }
            }
            if (sPointer >= 0 && tPointer >= 0 && S.charAt(sPointer) != T.charAt(tPointer)) {
                return false;
            }
            if ((sPointer >= 0) != (tPointer >= 0)) {
                return false;
            }

            sPointer--;
            tPointer--;
        }
        return true;
    }
}
