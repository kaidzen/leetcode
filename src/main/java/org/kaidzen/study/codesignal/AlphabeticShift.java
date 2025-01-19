package org.kaidzen.study.codesignal;

public class AlphabeticShift {

    public static void main(String[] args) {
        AlphabeticShift shift = new AlphabeticShift();

        System.out.println(shift.solution("crazy")); //dsbaz
    }

    String solution(String inputString) {
        char[] shift = inputString.toCharArray();
        for (int i = 0; i < shift.length; i++) {
            if (shift[i] == 'z') shift[i] = 'a';
            else shift[i]++;
        }

        return new String(shift);
    }
}
