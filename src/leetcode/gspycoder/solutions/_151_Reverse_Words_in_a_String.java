package leetcode.gspycoder.solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 151. Reverse Words in a String
 * Given an input string, reverse the string word by word.
 *
 *
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Follow up:
 *
 * For C programmers, try to solve it in-place in O(1) extra space.
 */

public class _151_Reverse_Words_in_a_String {
    public static class Solution1 {
        public String reverseWords(String s) {
            s.trim();
            if (s == null || s.length() == 0) {
                return "";
            }
            String[] words = s.split(" ");
            if (words == null || words.length == 0) {
                return "";
            }
            Deque<String> stack = new ArrayDeque<>();
            for (String word : words) {
                if (!word.equals("")) {
                    stack.offer(word);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (!stack.isEmpty()) {
                stringBuilder.append(stack.pollLast()).append(" ");
            }
            return stringBuilder.substring(0, stringBuilder.length() - 1).toString();
        }
    }
}
