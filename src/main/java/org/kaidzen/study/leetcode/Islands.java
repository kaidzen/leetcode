package org.kaidzen.study.leetcode;

public class Islands {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int counter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if ((i == 0 || grid[i - 1][j] == '0') && (j == 0 || grid[i][j - 1] == '0')) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    merge(grid, i, j);
                }
            }
        }
        return count;
    }

    private void merge(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1')
            return;

        grid[i][j] = 'X';

        merge(grid, i - 1, j);
        merge(grid, i + 1, j);
        merge(grid, i, j - 1);
        merge(grid, i, j + 1);
    }

    public static void main(String[] args) {
        Islands island = new Islands();
        char[][] map1 = new char[][]{
                "11110".toCharArray(),
                "11010".toCharArray(),
                "11000".toCharArray(),
                "00000".toCharArray()};
        char[][] map2 = new char[][]{
                "11000".toCharArray(),
                "11000".toCharArray(),
                "00100".toCharArray(),
                "00011".toCharArray()

        };
        char[][] map3 = {
                "111".toCharArray(),
                "010".toCharArray(),
                "111".toCharArray()};

//        List<char[][]> list = Arrays.asList(
//                map1,
//                map2,
//                map3);
//        list.forEach(grid -> System.out.println(island.numIslands(grid)));
//        System.out.println(island.numIslands(map3));
        System.out.println(island.numIslands2(map3));
    }
}
