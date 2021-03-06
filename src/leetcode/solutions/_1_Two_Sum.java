package leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class _1_Two_Sum {

    public static class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                   /* result[0] = map.get(target - nums[i]);
                    result[1] = i;
                    break;*/
                    return new int[]{map.get(target - nums[i]), i};
                } else {
                    map.put(nums[i], i);
                }
            }
            return new int[]{};
        }

        public int[] myTwoSum(int[] nums, int target){
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0;i<nums.length;i++){
                if(map.containsKey(target - nums[i])){
                    return new int[]{map.get(target - nums[i]), i};
                }else{
                    map.put(nums[i], i);
                }
            }
            return new int[]{};
        }
    }
    public static class Practice {
        public int[] twoSum(int[] nums, int target){
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i=0; i<nums.length;i++){
                if(map.containsKey(target-nums[i])){
                    return new int[]{map.get(target-nums[i]), i};
                }else{
                    map.put(nums[i], i);
                }
            }
            return new int[]{};
        }
    }
}
