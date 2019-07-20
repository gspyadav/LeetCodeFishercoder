package leetcode.solutions;

/**
 * 238. Product of Array Except Self
 *
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */

public class _238_Product_of_Array_Except_Self {

    public static class Solution1 {
        /**
         * Very straightforward idea: iterate through the array twice:
         * first time: get res[i] = res[i-1]*nums[i-1]
         * second time: have a variable called right, which means all the numbers product to its right, then do
         * res[i] *= right;
         * right *= nums[i];
         * that's it.
         *
         * This could be very well illustrated with this example: [1,2,3,4]
         */
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] result = new int[n];
            result[0] = 1;
            for (int i = 1; i < n; i++) {
                result[i] = result[i - 1] * nums[i - 1];
            }
            int right = 1;
            for (int i = n - 1; i >= 0; i--) {
                result[i] *= right;
                right *= nums[i];
            }
            return result;
        }
    }
}
