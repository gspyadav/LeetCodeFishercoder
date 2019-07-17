package leetcode.gspycoder.solutions;

/**
 * 59. Spiral Matrix II
 *
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class _59_Spiral_Matrix_II {

    public static class Solution1 {
        public int[][] generateMatrix(int num) {
            int temp = num;
            int[][] fourEdges = new int[num][num];
            int value = 1;
            int i = 0;
            int j = 0;
            while (i < num / 2 && j < num / 2 && temp >= 0) {
                /* Assign the top row */
                while (j < temp) {
                    fourEdges[i][j] = value;
                    j++;
                    value++;
                }

                /* Assign the right column */
                while (i < temp - 1) {
                    i++;
                    fourEdges[i][j - 1] = value;
                    value++;
                }
                j = j - 2;

                /* Assign the bottom row */
                while (j >= num - temp) {
                    fourEdges[i][j] = value;
                    j--;
                    value++;
                }
                i--;
                j++;

                /* Assign the left column */
                while (i > num - temp) {
                    fourEdges[i][j] = value;
                    i--;
                    value++;
                }
                //}
                i++;
                j++;
                temp--;
            }
            if (num % 2 == 0) {
            } else {
                fourEdges[num / 2][num / 2] = num * num;
            }
            for (int m = 0; m < num; m++) {
                for (int n = 0; n < num; n++) {
                    System.out.print(fourEdges[m][n] + "\t");
                    if ((n + 1) % num == 0) {
                        System.out.println();
                    }
                }
            }
            return fourEdges;
        }
    }
}
