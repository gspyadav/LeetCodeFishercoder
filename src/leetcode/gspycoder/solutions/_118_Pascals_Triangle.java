package leetcode.gspycoder.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class _118_Pascals_Triangle {

    public static class Solution1 {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList();
            int len = 1;
            for (int i = 0; i < numRows; i++) {
                List<Integer> row = new ArrayList(len);
                row.add(1);
                if (i > 0) {
                    List<Integer> lastRow = result.get(i - 1);
                    for (int j = 1; j < lastRow.size(); j++) {
                        row.add(lastRow.get(j - 1) + lastRow.get(j));
                    }
                    row.add(1);
                }
                result.add(row);
                len++;
            }
            return result;
        }
    }
}
