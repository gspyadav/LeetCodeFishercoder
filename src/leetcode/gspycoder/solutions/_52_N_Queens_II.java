package leetcode.gspycoder.solutions;

/**
 * 52. N-Queens II
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 *
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Example:
 *
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */
public class _52_N_Queens_II {

    public static class Solution1 {
        /**
         * credit: https://discuss.leetcode.com/topic/29626/easiest-java-solution-1ms-98-22
         */
        int count = 0;

        public int totalNQueens(int n) {
            boolean[] cols = new boolean[n];
            boolean[] diagnol = new boolean[2 * n];
            boolean[] antiDiagnol = new boolean[2 * n];
            backtracking(0, cols, diagnol, antiDiagnol, n);
            return count;
        }

        private void backtracking(int row, boolean[] cols, boolean[] diagnol, boolean[] antiDiagnol,
                                  int n) {
            if (row == n) {
                count++;
            }
            for (int col = 0; col < n; col++) {
                int x = col - row + n;
                int y = col + row;
                if (cols[col] || diagnol[x] || antiDiagnol[y]) {
                    continue;
                }
                cols[col] = true;
                diagnol[x] = true;
                antiDiagnol[y] = true;
                backtracking(row + 1, cols, diagnol, antiDiagnol, n);
                cols[col] = false;
                diagnol[x] = false;
                antiDiagnol[y] = false;
            }
        }
    }
}
