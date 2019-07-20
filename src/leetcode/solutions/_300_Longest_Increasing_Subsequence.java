package leetcode.solutions;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 *
 Given an unsorted array of integers, find the length of longest increasing subsequence.

 Example:

 Input: [10,9,2,5,3,7,101,18]
 Output: 4
 Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 Note:

 There may be more than one LIS combination, it is only necessary for you to return the length.
 Your algorithm should run in O(n2) complexity.
 Follow up: Could you improve it to O(n log n) time complexity?
 */
public class _300_Longest_Increasing_Subsequence {
    public static void main(String args[]){
        int arr[] = {10,9,2,5,3,7,101,18};
        System.out.println(new Solution1().lengthOfLIS(arr));
    }

    public static class Solution1 {

        /**
         * credit: https://discuss.leetcode.com/topic/28719/short-java-solution-using-dp-o-n-log-n
         * The idea is that as you iterate the sequence,
         * you keep track of the minimum value a subsequence of given length might end with,
         * for all so far possible subsequence lengths.
         * So dp[i] is the minimum value a subsequence of length i+1 might end with.
         * Having this info, for each new number we iterate to,
         * we can determine the longest subsequence where it can be appended using binary search.
         * The final answer is the length of the longest subsequence we found so far.
         */
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            int len = 0;
            for (int x : nums) {
                /**Java Doc of this binarySearch API:
                 * @return index of the search key, if it is contained in the array
                 *         within the specified range;
                 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
                 *         <i>insertion point</i> is defined as the point at which the
                 *         key would be inserted into the array: the index of the first
                 *         element in the range greater than the key,
                 *         or <tt>toIndex</tt> if all
                 *         elements in the range are less than the specified key.  Note
                 *         that this guarantees that the return value will be &gt;= 0 if
                 *         and only if the key is found.*/
                int index = Arrays.binarySearch(dp, 0, len, x);
                //System.out.println("x value:"+x+" and index:"+index+" len:"+len);
                if (index < 0) {
                    index = -(index + 1);
                }
                dp[index] = x;
                if (index == len) {
                    len++;
                }
                //System.out.println(dp[len-1] + " len:"+len);
            }
            return len;
        }
    }
}
