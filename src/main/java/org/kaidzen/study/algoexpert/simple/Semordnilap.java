package org.kaidzen.study.algoexpert.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * “Semordnilap” is a word playfully coined by word-game lovers some time in the mid 20th century.
 * While a palindrome reads the same way backwards or forwards (otto, kayak),
 * a semordnilap (itself a semordnilap of “palindromes”) makes a completely different word when spelled backwards.
 * <p>
 * I just learned of the beautiful twin name combo of
 * Aidan and Nadia. Cleverly, Nadia is Aidan spelled backwards, and vice versa
 * Heaven and Neveah
 * Noel and Leon
 * Nora and Aron
 */
public class Semordnilap {

    public static void main(String[] args) {
        Semordnilap pairs = new Semordnilap();

        String[] words = new String[]{"diaper", "abc", "test", "cba", "repaid"};
        System.out.println(pairs.semordnilap(words));
    }

    public ArrayList<ArrayList<String>> semordnilap(String[] words) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word: words) {
            String reverse = doReverse(word);
            if (set.contains(reverse) && !word.equals(reverse)) {
                set.remove(word);
                set.remove(reverse);
                result.add(new ArrayList<>(Arrays.asList(word, reverse)));
            }
        }
        return result;
    }

    private String doReverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}
