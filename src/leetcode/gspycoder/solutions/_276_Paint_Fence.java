package leetcode.gspycoder.solutions;

/**
 * 276. Paint Fence
 * <p>
 * There is a fence with n posts, each post can be painted with one of the k colors.
 * <p>
 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 * <p>
 * Return the total number of ways you can paint the fence.
 * <p>
 * Note:
 * n and k are non-negative integers.
 */

public class _276_Paint_Fence {
    public static class Solution1 {
        public int numWays(int n, int k) {
            if (n == 0) {
                return 0;
            } else if (n == 1) {
                return k;
            }
            int sameColorCnt = k;
            int diffColorCnt = k * (k - 1);
            for (int i = 2; i < n; i++) {
                int temp = diffColorCnt;
                diffColorCnt = (diffColorCnt + sameColorCnt) * (k - 1);
                sameColorCnt = temp;
            }
            return sameColorCnt + diffColorCnt;
        }
    }
}
