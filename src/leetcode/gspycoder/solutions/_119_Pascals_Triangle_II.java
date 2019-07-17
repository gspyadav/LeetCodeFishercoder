package leetcode.gspycoder.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 3
 * Output: [1,3,3,1]
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 */

public class _119_Pascals_Triangle_II {

    public static void main(String args[]){
        System.out.println(new Solution2().getRow(15));
    }
    public static class Solution1 {
        public List<Integer> getRow(int rowIndex) {
            if (rowIndex < 0) {
                return new ArrayList();
            }
            List<List<Integer>> result = new ArrayList();
            List<Integer> row = new ArrayList();
            row.add(1);
            result.add(row);
            for (int i = 1; i <= rowIndex; i++) {
                List<Integer> newRow = new ArrayList();
                newRow.add(1);
                List<Integer> lastRow = result.get(i - 1);
                for (int j = 1; j < lastRow.size(); j++) {
                    newRow.add(lastRow.get(j - 1) + lastRow.get(j));
                }
                newRow.add(1);
                result.add(newRow);
            }
            return result.get(result.size() - 1);
        }
    }

    public static class Solution2 {
        /**
         * O(k) space
         */
        public List<Integer> getRow(int rowIndex) {
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < rowIndex + 1; i++) {
                row.add(0, 1);
                for (int j = 1; j < row.size() - 1; j++) {
                    row.set(j, row.get(j) + row.get(j + 1));
                }
            }
            return row;
        }
    }
}
