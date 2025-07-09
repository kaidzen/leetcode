package org.kaidzen.study.leetcode.y2025.strings;

/**
 * Strange string modification. You should take into account, that path for the next character,
 * among input string, is consists from V-shapes, that form, in result, Z-shaped path.
 * "Height of the V-shape defined by numRows parameter"
 */
public class ZigzagConversion_6 {

    public static void main(String[] args) {

        ZigzagConversion_6 zigZag = new ZigzagConversion_6();

        String expected = "PAHNAPLSIIGYIR";
        String s = "PAYPALISHIRING";
        int numR = 3;

        final String converted = zigZag.convert(s, numR);
        System.out.println(converted.equals(expected));

        String expected2 = "ACB";
        String s2 = "ABC";
        int numR2 = 1;
        final String converted2 = zigZag.convert(s2, numR2);
        System.out.println(converted2.equals(expected2));
    }

    public String convert(String s, int numRows) {
        if (s.length() <= 2 || numRows == 1) return s;
        StringBuilder res = new StringBuilder();

        for (int r = 0; r < numRows; r++) {
            int increment = 2 * (numRows - 1); // V-shape movement, calculate steps for it.
            for (int i = r; i < s.length(); i += increment) {
                res.append(s.charAt(i));
                if (r > 0 && r < numRows - 1 && i + increment - 2 * r < s.length()) {
                    res.append(s.charAt(i + increment - 2 * r));
                }
            }
        }
        return res.toString();
    }
}
