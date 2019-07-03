package leetcode.gspycoder.solutions;

/**
 * 152. Maximum Product Subarray
 * <p>
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class _152_Maximum_Product_Subarray {
    public static class Solution1 {
        public int maxProduct(int[] nums) {
            int pos = nums[0];
            int neg = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int temp = pos;
                pos = Math.max(nums[i], nums[i] * ((nums[i] >= 0) ? pos : neg));
                neg = Math.min(nums[i], nums[i] * ((nums[i] >= 0) ? neg : temp));
                max = Math.max(max, pos);
            }
            return max;
        }
    }
}
