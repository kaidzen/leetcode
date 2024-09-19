package org.kaidzen.study.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class FlippMatrix {

    public static int solition(List<List<Integer>> matrix) {

        int sum = 0;
        int n = matrix.size() / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += Math.max(
                        matrix.get(i).get(j),
                        Math.max(
                                matrix.get(i).get(2*n-j-1),
                                Math.max(
                                        matrix.get(2*n-1-i).get(j), matrix.get(2*n-1-i).get(2*n-1-j)
                                )
                        )
                );
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> a = new ArrayList<>(List.of(1, 2));
        List<Integer> b = new ArrayList<>(List.of(3, 4));
        matrix.add(a);
        matrix.add(b);
        final int solition = FlippMatrix.solition(matrix);

        System.out.println(solition);
    }
}
