package leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 *
 * Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]

 */

public class _46_Permutations {

    public static void main(String args[]){
        int[] arr = {1,2,3,4};
        new Solution1().permute(arr);
    }
    public static class Solution1 {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList();
            result.add(new ArrayList<>());
            return backtracking(result, nums, 0);
        }

        private List<List<Integer>> backtracking(List<List<Integer>> result, int[] nums, int pos) {
            if (pos == nums.length) {
                return result;
            }
            List<List<Integer>> newResult = new ArrayList();
            for (List<Integer> eachList : result) {
                for (int i = 0; i <= eachList.size(); i++) {
                    //attn: i starts from 0
                    List<Integer> newList = new ArrayList(eachList);
                    newList.add(i, nums[pos]);
                    newResult.add(newList);
                }
            }
            result = newResult;
            return backtracking(result, nums, pos + 1);
        }
    }

}
