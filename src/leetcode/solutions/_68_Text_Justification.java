package leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. Text Justification
 *
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 * Example 1:
 *
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Example 2:
 *
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 *              because the last line must be left-justified instead of fully-justified.
 *              Note that the second line is also left-justified becase it contains only one word.
 * Example 3:
 *
 * Input:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 */
public class _68_Text_Justification {

    public static class Solution1 {
        public List<String> fullJustify(String[] words, int L) {
            ArrayList<String> result = new ArrayList();
            if (words == null || words.length == 0) {
                return result;
            }
            int count = 0;
            int last = 0;
            for (int i = 0; i < words.length; i++) {
                if (count + words[i].length() + (i - last) > L) {
                    int spaceNum = 0;
                    int extraNum = 0;
                    if (i - last - 1 > 0) {
                        spaceNum = (L - count) / (i - last - 1);
                        extraNum = (L - count) % (i - last - 1);
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int j = last; j < i; j++) {
                        sb.append(words[j]);
                        if (j < i - 1) {
                            for (int k = 0; k < spaceNum; k++) {
                                sb.append(" ");
                            }
                            if (extraNum > 0) {
                                sb.append(" ");
                            }
                            extraNum--;
                        }
                    }
                    for (int j = sb.length(); j < L; j++) {
                        sb.append(" ");
                    }
                    result.add(sb.toString());
                    count = 0;
                    last = i;
                }
                count += words[i].length();
            }
            StringBuilder sb = new StringBuilder();
            for (int i = last; i < words.length; i++) {
                sb.append(words[i]);
                if (sb.length() < L) {
                    sb.append(" ");
                }
            }
            for (int i = sb.length(); i < L; i++) {
                sb.append(" ");
            }
            result.add(sb.toString());
            return result;
        }
    }

}
