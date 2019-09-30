package leetcode.solutions;

/**
 * Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.
 *
 * We repeatedly make k duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made.
 *
 * It is guaranteed that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 * Example 2:
 *
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * Example 3:
 *
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * 2 <= k <= 10^4
 * s only contains lower case English letters.
 */

public class _1209_Remove_All_Adjacent_Duplicates_in_String_II {
    public static class Solution1{
        public static String removeDuplicates(String s, int k) {
            boolean flag = true;
            while(flag){
                flag = false;
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<s.length();i++){
                    char c = s.charAt(i);
                    int start = i;
                    while(i+1<s.length() && s.charAt(i+1)==c && i-start<k-1){
                        i++;
                    }
                    if(i==start){
                        sb.append(s.charAt(i));
                    }
                    else if(i-start+1==k){
                        flag = true;
                    }else{
                        sb.append(s.substring(start,i+1));
                    }
                }
                s = new String(sb);
            }
            return s;
        }
    }
}
