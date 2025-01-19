package org.kaidzen.study.codesignal;

public class ChessBoardColor {

    public static void main(String[] args) {
        ChessBoardColor sameColor = new ChessBoardColor();

        String cell1 = "A1";
        String cell2 = "C3";
        System.out.println(sameColor.solution(cell1, cell2)); //true
    }

    /*
    in nutshell, we should check if diff of same axis is BOTH even or BOTH odd
     */
    boolean solution(String cell1, String cell2) {
        if (cell1.length() != 2 || cell2.length() != 2) return false;

        String xAxis = "ABCDEFGH";
        String yAxis = "12345678";

        return isDistributed(xAxis, cell1.charAt(0), cell2.charAt(0)) == isDistributed(yAxis, cell1.charAt(1), cell2.charAt(1));
    }

    private int isDistributed (String space, char one, char two) {
        int firstIdx = space.indexOf(one);
        int secondIdx = space.indexOf(two);

        return Math.abs(secondIdx - firstIdx) % 2;
    }
}
