package Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * In a given grid, each cell can have one of three values:
 * <p>
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 */

public class RottedFruit {
    public static int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();

        int[][] dir = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;
            for (int j = 0; j < size; j++) {
                int[] curr = queue.poll();
                for (int i = 0; i < dir.length; i++) {
                    if (dir[i][0] + curr[0] >= 0 && dir[i][0] + curr[0] < row && dir[i][1] + curr[1] >= 0 && dir[i][1] + curr[1] < col && grid[dir[i][0] + curr[0]][dir[i][1] + curr[1]] == 1) {
                        grid[dir[i][0] + curr[0]][dir[i][1] + curr[1]] = 2;
                        queue.offer(new int[]{dir[i][0] + curr[0], dir[i][1] + curr[1]});
                        flag = true;
                    }
                }
            }
            if(flag) {
                count++;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count;
    }

    public static void main(String args[]){
        int [][] grid = new int[][]{{0,2}};
        System.out.println(orangesRotting(grid));
    }
}
