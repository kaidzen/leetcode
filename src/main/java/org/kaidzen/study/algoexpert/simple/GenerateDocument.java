package org.kaidzen.study.algoexpert.simple;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {

    public static void main(String[] args) {
        GenerateDocument generator = new GenerateDocument();

        String characters = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";
        System.out.println(generator.generateDocument(characters, document));
    }

    public boolean generateDocument(String characters, String document) {
        Map<Character, Integer> chars = new HashMap<>();
        Map<Character, Integer> docs = new HashMap<>();
        for(char ch: characters.toCharArray()) {
            chars.merge(ch, 1, (a, b) -> a += 1);
        }

        for(char ch: document.toCharArray()) {
            docs.merge(ch, 1, (a, b) -> a += 1);
        }
        if (chars.size() < docs.size()) {
            return false;
        }
        return docs.entrySet().stream()
                        .allMatch(entry -> {
                            Character docKey = entry.getKey();
                            return chars.containsKey(docKey) && entry.getValue() <= chars.get(docKey);
                        });

    }
}
