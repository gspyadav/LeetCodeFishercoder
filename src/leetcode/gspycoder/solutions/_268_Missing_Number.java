package leetcode.gspycoder.solutions;

/**
 * 268. Missing Number
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1:
 * Input: [3,0,1]
 * Output: 2
 *
 * Example 2:
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 *
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class _268_Missing_Number {

    public static class Solution1 {
        /**
         * we could take advantage of the array indices
         * then a number xor with itself is zero, so after we xor the entire array with all of its indices, the missing number will show up.
         */
        public int missingNumber(int[] nums) {
            int xor = 0;
            int i = 0;
            for (; i < nums.length; i++) {
                xor = xor ^ i ^ nums[i];
            }
            return xor ^ i;
        }
    }

}
