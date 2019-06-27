package leetcode.gspycoder.solutions;

/**
 * 72. Edit Distance
 *
 Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

 You have the following 3 operations permitted on a word:

 Insert a character
 Delete a character
 Replace a character
 Example 1:

 Input: word1 = "horse", word2 = "ros"
 Output: 3
 Explanation:
 horse -> rorse (replace 'h' with 'r')
 rorse -> rose (remove 'r')
 rose -> ros (remove 'e')
 Example 2:

 Input: word1 = "intention", word2 = "execution"
 Output: 5
 Explanation:
 intention -> inention (remove 't')
 inention -> enention (replace 'i' with 'e')
 enention -> exention (replace 'n' with 'x')
 exention -> exection (replace 'n' with 'c')
 exection -> execution (insert 'u')
 */

public class _72_Edit_Distance {

    public static class Solution1 {
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            if (m == 0) {
                return n;
            }
            if (n == 0) {
                return m;
            }
            char[] str1 = word1.toCharArray();
            char[] str2 = word2.toCharArray();

            int[][] table = new int[m + 1][n + 1];
            for (int i = 0; i < m + 1; i++) {
                table[i][0] = i;
            }
            for (int j = 0; j < n + 1; j++) {
                table[0][j] = j;
            }
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    int cost = 0;
                    if (str1[i - 1] != str2[j - 1]) {
                        cost = 1;
                    }
                    table[i][j] = Math.min(Math.min(table[i - 1][j] + 1, table[i][j - 1] + 1),
                        table[i - 1][j - 1] + cost);
                }
            }
            return table[m][n];
        }
    }
}
