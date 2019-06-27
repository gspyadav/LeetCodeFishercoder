package leetcode.gspycoder.solutions;

/**
 * 36. Valid Sudoku
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * A partially filled sudoku which is valid.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Example 1:
 *
 * Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * Example 2:
 *
 * Input:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 *     modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 */
public class _36_Valid_Sudoku {

    public static class Solution1 {
        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                if (!isValidRowOrColumn(board, i)) {
                    return false;
                }
            }

            for (int j = 0; j < 9; j++) {
                if (!isValidCol(board, j)) {
                    return false;
                }
            }

            for (int i = 0; i < 7; i = i + 3) {
                for (int j = 0; j < 7; j = j + 3) {
                    if (!isValidSquare(board, i, j)) {
                        return false;
                    }
                }
            }
            return true;
        }

        boolean isValidRowOrColumn(char[][] board, int index) {
            int[] nums = new int[9];
            for (int i = 0; i < 9; i++) {
                nums[i] = 1;
            }
            for (int j = 0; j < 9; j++) {
                if (board[index][j] != '.') {
                    nums[Character.getNumericValue(board[index][j]) - 1]--;
                }
            }
            for (int i : nums) {
                if (i < 0) {
                    return false;
                }
            }
            return true;
        }

        boolean isValidCol(char[][] board, int col) {
            int[] nums = new int[9];
            for (int i = 0; i < 9; i++) {
                nums[i] = 1;
            }
            for (int i = 0; i < 9; i++) {
                if (board[i][col] != '.') {
                    nums[Character.getNumericValue(board[i][col]) - 1]--;
                }
            }
            for (int i : nums) {
                if (i < 0) {
                    return false;
                }
            }
            return true;
        }

        boolean isValidSquare(char[][] board, int row, int col) {
            int[] nums = new int[9];
            for (int i = 0; i < 9; i++) {
                nums[i] = 1;
            }
            for (int i = row; i < row + 3; i++) {
                for (int j = col; j < col + 3; j++) {
                    if (board[i][j] != '.') {
                        nums[Character.getNumericValue(board[i][j]) - 1]--;
                    }
                }
            }
            for (int i : nums) {
                if (i < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
