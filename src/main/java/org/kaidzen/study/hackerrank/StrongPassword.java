package org.kaidzen.study.hackerrank;

public class StrongPassword {

    public static void main(String[] args) {
/*        final int number = StrongPassword.minimumNumber(11, "#HackerRank");
        System.out.println(number); // 1

        final int number2 = StrongPassword.minimumNumber(3, "Ab1");
        System.out.println(number2); // 3

        final int number3 = StrongPassword.minimumNumber(4, "4700");
        System.out.println(number3); // 3*/

        final int number4 = StrongPassword.minimumNumber(5, "55542");
        System.out.println(number4); // 3
    }

    /*
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";

        boolean num = true;
        boolean lower = true;
        boolean upper = true;
        boolean special = true;

        for(char ch: password.toCharArray()) {
            String st = String.valueOf(ch);
            num &= !numbers.contains(st);
            lower &= !lower_case.contains(st);
            upper &= !upper_case.contains(st);
            special &= !special_characters.contains(st);
        }
        int counter = 0;
        boolean[] res = new boolean[]{num, lower, upper, special};
        for (boolean flag: res) {
            if (flag) {
                counter++;
            }
        }
        final int minLen = 6;
        if (n < minLen) {
            return (n + counter) > minLen? counter: minLen - n;
        }
        return counter;
    }
}
