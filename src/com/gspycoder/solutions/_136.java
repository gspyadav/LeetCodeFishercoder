package com.gspycoder.solutions;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**136. Single Number

Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

public class _136 {

  public static class Solution1 {
    /**
     * Approach 1: use set, since this problem explicitly states that every element appears twice
     * and only one appears once so, we could safely remove the ones that are already in the set,
     * O(n) time and O(n) space. HashTable approach works similarly like this one, but it could be
     * more easily extend to follow-up questions.
     */
    public int singleNumber(int[] nums) {
      Set<Integer> set = new HashSet();
      for (int i : nums) {
        if (!set.add(i)) {
          set.remove(i);
        }
      }
      Iterator<Integer> it = set.iterator();
      return it.next();
    }
  }

  public static class Solution2 {
    /**
     * Approach 2: bit manipulation, use exclusive or ^ to solve this problem: we're using the trick
     * here: every number ^ itself will become zero, so, the only remaining element will be the one
     * that appeared only once.
     */
    public int singleNumber(int[] nums) {
      int res = 0;
      for (int i : nums) {
        res ^= i;
      }
      return res;
    }
  }
}
