package leetcode.gspycoder.solutions;

/**
 * 63. Unique Paths II
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 *
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 */
public class _63_Unique_Paths_II {
    public static class Solution1 {
        /**
         * Idea: grid[i][j] has to be set to zero if obstacleGrid[i][j] == 1, otherwise, we can get
         * dp[i][j] from its top and left dp.
         */
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if (obstacleGrid == null || obstacleGrid.length == 0) {
                return 0;
            }

            int height = obstacleGrid.length;
            int width = obstacleGrid[0].length;
            int[][] dp = new int[height][width];
            dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
            for (int i = 1; i < height; i++) {
                dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
            }
            for (int j = 1; j < width; j++) {
                dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j - 1];
            }

            for (int i = 1; i < height; i++) {
                for (int j = 1; j < width; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        int paths = 0;
                        if (obstacleGrid[i - 1][j] == 0) {
                            paths += dp[i - 1][j];
                        }
                        if (obstacleGrid[i][j - 1] == 0) {
                            paths += dp[i][j - 1];
                        }
                        dp[i][j] = paths;
                    }
                }
            }
            return dp[height - 1][width - 1];
        }
    }
}
