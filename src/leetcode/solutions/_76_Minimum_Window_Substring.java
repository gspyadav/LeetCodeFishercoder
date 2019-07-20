package leetcode.solutions;

/**
 * 76. Minimum Window Substring
 * <p>
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * <p>
 * Minimum window is "BANC".
 * <p>
 * Note:
 * <p>
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */

public class _76_Minimum_Window_Substring {

    public static class Solution1 {
        public String minWindow(String s, String t) {
            int[] counts = new int[256];
            for (char c : t.toCharArray()) {
                counts[c]++;
            }

            int start = 0;
            int end = 0;
            int minStart = 0;
            int minLen = Integer.MAX_VALUE;
            int counter = t.length();
            while (end < s.length()) {
                if (counts[s.charAt(end)] > 0) {
                    counter--;
                }

                counts[s.charAt(end)]--;
                end++;

                while (counter == 0) {
                    if (end - start < minLen) {
                        minStart = start;
                        minLen = end - start;
                    }
                    counts[s.charAt(start)]++;
                    if (counts[s.charAt(start)] > 0) {
                        counter++;
                    }
                    start++;
                }
            }

            if (minLen == Integer.MAX_VALUE) {
                return "";
            }
            return s.substring(minStart, minStart + minLen);
        }
    }
}
