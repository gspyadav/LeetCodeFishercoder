package leetcode.solutions;

/**
 * 344. Reverse String
 *
 *Write a function that reverses a string. The input string is given as an array of characters char[].
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 */
public class _344_Reverse_String {
    public static void main(String args[]){
        System.out.println(new Solution1().reverseString("hello"));
    }
    public static class Solution1 {
        public String reverseString(String s) {
            int i = 0;
            int j = s.length() - 1;
            char[] chars = s.toCharArray();
            while (i < j) {
                char temp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = temp;
            }
            return new String(chars);
        }
    }
}
