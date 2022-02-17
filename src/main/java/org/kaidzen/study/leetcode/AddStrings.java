package org.kaidzen.study.leetcode;

public class AddStrings {

    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();
        String result = addStrings.addStrings("123", "45");
        System.out.println(result);
    }

    public String addStrings(String num1, String num2) {
        int first = num1.length() - 1;
        int second = num2.length() - 1;
        StringBuilder container = new StringBuilder();
        int carry = 0;
        while (first >= 0 || second >= 0) {
            int sum = 0;

            if (first >= 0) {
                sum += num1.charAt(first) - '0';
            }
            if (second >= 0) {
                sum += num2.charAt(second) - '0';
            }
            container.append(sum % 10);
            carry = sum / 10;

            first--;
            second--;
        }
        if (carry != 0) {
            container.append(carry);
        }
        return container.reverse().toString();
    }
}
