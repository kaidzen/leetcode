package org.kaidzen.study.leetcode.june2020;

public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int columns = dungeon[0].length;
        int[][] solution = new int[rows][columns];
        //Start resolving from final step. Etraxt from 1, from convert negative value.
        solution[rows - 1][columns - 1] = dungeon[rows - 1][columns - 1] > 0 ? 1 : (1 - dungeon[rows - 1][columns - 1]);

        for (int i = rows - 2; i >= 0; i--) {
            //Calculate solution for last column
            solution[i][columns - 1] =
                    //If previous value minus current negative, use minimal health value
                    // (for knight to reach final step)
                    Math.max(solution[i + 1][columns - 1] - dungeon[i][columns - 1], 1);
        }
        for (int j = columns - 2; j >= 0; j--) {
            //Calculate solution for last row
            solution[rows - 1][j] =
                    //If previous value minus current negative, use minimal health value
                    // (for knight to reach final step)
                    Math.max(solution[rows - 1][j + 1] - dungeon[rows - 1][j], 1);
        }
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = columns - 2; j >= 0; j--) {
                //Calculate solution for all rest columns and rows. With max we will set
                // minimal required level of life for knight >=1
                //And we will take only minimal values, according to task
                // (Find minimal life amount, that will allow to finish)
                solution[i][j] = Math.max(Math.min(solution[i + 1][j], solution[i][j + 1]) - dungeon[i][j], 1);
            }
        }
        //Backward steps will lead to start point
        return solution[0][0];
    }

    public static void main(String[] args) {
        DungeonGame game = new DungeonGame();
//        Dungeon map: {[-2,-3,3],[-5,-10,1],[10,30,-5]}
//        Result: 7 
        int res = game.calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}});
        System.out.println(res);
    }
}
