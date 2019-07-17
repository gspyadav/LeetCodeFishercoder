package leetcode.gspycoder.solutions;

/**
 * 97. Interleaving String
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * Example 1:
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 *
 * Example 2:
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 */
public class _97_Interleaving_String {
    public static class Solution1 {
        public boolean isInterleave(String s1, String s2, String s3) {
            int m = s1.length();
            int n = s2.length();
            if (m + n != s3.length()) {
                return false;
            }

            boolean[][] dp = new boolean[m + 1][n + 1];

            dp[0][0] = true;

            for (int i = 0; i < m; i++) {
                if (s1.charAt(i) == s3.charAt(i)) {
                    dp[i + 1][0] = true;
                } else {
                    //if one char fails, that means it breaks, the rest of the chars won't matter any more.
                    //Mian and I found one missing test case on Lintcode: ["b", "aabccc", "aabbbcb"]
                    //if we don't break, here, Lintcode could still accept this code, but Leetcode fails it.
                    break;
                }
            }

            for (int j = 0; j < n; j++) {
                if (s2.charAt(j) == s3.charAt(j)) {
                    dp[0][j + 1] = true;
                } else {
                    break;
                }
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    int k = i + j - 1;
                    dp[i][j] = (s1.charAt(i - 1) == s3.charAt(k) && dp[i - 1][j])
                            || (s2.charAt(j - 1) == s3.charAt(k) && dp[i][j - 1]);
                }
            }

            return dp[m][n];
        }
    }
}
