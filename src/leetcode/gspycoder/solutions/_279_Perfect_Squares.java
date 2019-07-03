package leetcode.gspycoder.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 279. Perfect Squares
 *
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class _279_Perfect_Squares {
    public static class Solution1 {
        Map<Integer, Integer> map = new HashMap<>();
        public int numSquares(int n) {
            if(map.get(n) != null){
                return map.get(n);
            }
            int result = n;
            int num = 2;
            while (num * num <= n) {
                int temp1 = n / (num * num);
                int temp2 = n % (num * num);
                result = Math.min(result, temp1 + numSquares(temp2));
                num++;
            }
            map.put(n,result);
            return result;
        }
    }

    public static class Solution2 {
        //DP solution
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 1; i <= n; i++) {
                int min = Integer.MAX_VALUE;
                int j = 1;
                while (i - j * j >= 0) {
                    min = Math.min(min, dp[i - j * j] + 1);
                    j++;
                }
                dp[i] = min;
            }
            return dp[n];
        }
    }

}
