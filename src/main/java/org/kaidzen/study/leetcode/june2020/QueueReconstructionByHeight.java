package org.kaidzen.study.leetcode.june2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(people, (a, b) -> {return a[0]==b[0] ? a[1]-b[1] : b[0]-a[0];});
        for (int[] person: people){
            result.add(person[1], person);
        }
        return result.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
//        Input:
//        [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//        Output:
//        [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
        QueueReconstructionByHeight reconstruct = new QueueReconstructionByHeight();
        int[][] ints = reconstruct.reconstructQueue(new int[][]{{7, 0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}});
        System.out.println(Arrays.deepToString(ints));
    }
}
