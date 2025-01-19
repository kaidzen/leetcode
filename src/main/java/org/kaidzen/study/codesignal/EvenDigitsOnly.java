package org.kaidzen.study.codesignal;

public class EvenDigitsOnly {

    public static void main(String[] args) {
        EvenDigitsOnly ed = new EvenDigitsOnly();

        System.out.println(ed.solution(5468428));
    }

    boolean solution(int n) {
        while (n != 0) {
            if (n % 2 != 0) {
                return false;
            }
            n = n / 10;
        }

        return true;
    }
}
