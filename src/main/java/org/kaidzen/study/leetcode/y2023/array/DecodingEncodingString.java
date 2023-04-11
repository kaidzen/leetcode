package org.kaidzen.study.leetcode.y2023.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DecodingEncodingString {

    public static void main(String[] args) {
        DecodingEncodingString decoder = new DecodingEncodingString();

        List<String> list = Stream.of("lint","code","love","you").collect(Collectors.toList());
        String res = decoder.encode(list);
        System.out.println(res);
        final List<String> stringList = decoder.decode(res);
        System.out.println(stringList);
    }

    public String encode(List<String> strs) {
        return strs.stream()
                .map(str -> str.length() + "#" + str)
                .collect(Collectors.joining());
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> answer = new ArrayList<>();

        while (i < str.length()) {
            int j = i;
            while (j != str.indexOf("#", i)) {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            answer.add(str.substring(j + 1, j + 1 + length));
            i = j + 1 + length;
        }
        return answer;
    }
}
