package org.kaidzen.study.leetcode;

import java.util.Arrays;
import java.util.List;

public class LeftMostColumn {

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        int rows = dimension.get(0);
        int columns = dimension.get(1);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = columns - 1; j >= 0; j--) {
                if (binaryMatrix.get(i, j) == 0) {
                    break;
                } else {
                    result = Math.min(j, result);
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int leftMostColumnWithOne1(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        int rows = dimension.get(0);
        int columns = dimension.get(1);
        int result = -1;
        int i = 0;
        int j = columns - 1;
        while (i < rows && j >= 0) {
            int current = binaryMatrix.get(i, j);
            if (current == 0) {
                i++;
            } else {
                result = j;
                j--;
            }
        }
        return result;
    }

    public int leftMostColumnWithOne2(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        int rows = dimension.get(0);
        int columns = dimension.get(1);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            int left = 0;
            int right = columns - 1;
            while (left <= right) {
                if (left > result) {
                    break;
                }
                int mid = left + (right - left) / 2;
                int midElem = binaryMatrix.get(i, mid);
                if (midElem == 1 && (mid == 0 || binaryMatrix.get(i, mid - 1) == 0)) {
                    result = Math.min(result, mid);
                }
                if (midElem == 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        int[][] arr1 = new int[][]{{0, 0}, {0, 1}};
        int[][] arr2 = new int[][]{{0, 0}, {1, 1}};
        int[][] arr3 = new int[][]{{0, 0}, {0, 0}};
        int[][] arr4 = new int[][]{{0, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 1}};
        int[][] arr5 = new int[][]{{1, 1, 1, 1, 1}, {0, 0, 0, 1, 1}, {0, 0, 1, 1, 1}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}};

        LeftMostColumn mostLeft = new LeftMostColumn();

        List<int[][]> list = Arrays.asList(arr1, arr2, arr3, arr4, arr5);
        list.stream()
                .map(IntBiMatrix::new)
                .forEach(matrix -> System.out.println(mostLeft.leftMostColumnWithOne(matrix)));
        System.out.println("====================");
        list.stream()
                .map(IntBiMatrix::new)
                .forEach(matrix -> System.out.println(mostLeft.leftMostColumnWithOne1(matrix)));
        System.out.println("====================");
        list.stream()
                .map(IntBiMatrix::new)
                .forEach(matrix -> System.out.println(mostLeft.leftMostColumnWithOne2(matrix)));
    }

    interface BinaryMatrix {
        int get(int x, int y);

        List<Integer> dimensions();
    }

    private static class IntBiMatrix implements BinaryMatrix {

        private int[][] array;

        IntBiMatrix(int[][] array) {
            this.array = array;
        }

        @Override
        public int get(int x, int y) {
            return array[x][y];
        }

        @Override
        public List<Integer> dimensions() {
            return Arrays.asList(array.length, array[0].length);
        }
    }
}
