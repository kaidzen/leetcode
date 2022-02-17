package org.kaidzen.study.other;

public class DrawingBook {

    public static void main(String[] args) {
        DrawingBook book = new DrawingBook();
        System.out.println(book.pageCount(6, 2));
        System.out.println(book.pageCount(5, 4));
    }

    public static int pageCount(int n, int p) {
        int totalTurns = n / 2;
        int forwardPAgeTurns = p / 2;
        return Math.min(forwardPAgeTurns, totalTurns - forwardPAgeTurns);
    }
}
