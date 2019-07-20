package leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. Substring with Concatenation of All Words
 * <p>
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * <p>
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * <p>
 * You should return the indices: [0,9].
 * (order does not matter).
 * "wordgoodgoodgoodbestword"
 * ["word","good","best","good"]
 */
public class _30_Substring_with_Concatenation_of_All_Words {

    public static void main(String args[]) {
        String words[] = {};
        List<Integer> result = new Solution1().findSubstring("a", words);
        for (int i : result) {
            System.out.println(i);
        }

    }

    public static class Solution1 {
        /**
         * TODO: this one is not AC'ed. fix this one.
         */
        public List<Integer> findSubstring(String s, String[] words) {
            if (words == null || words.length == 0) {
                return new ArrayList<>();
            }
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            List<Integer> result = new ArrayList<>();
            int startIndex = 0;
            int wordLen = words.length;
            for (int i = 0; i < s.length(); i++) {
                startIndex = i;
                int icopy = i;
                Map<String, Integer> clone = new HashMap<>(map);
                int matchedWord = 0;
                for (int j = icopy + 1; j <= s.length(); j++) {

                    String word = s.substring(icopy, j);

                    if (clone.containsKey(word) && clone.get(word) > 0) {

                        clone.put(word, clone.get(word) - 1);
                        icopy = j;
                        matchedWord++;
                        //System.out.println(word+"   matchedWord:"+matchedWord);
                    }
                    if (matchedWord == wordLen) {
                        boolean all = true;
                        for (String key : clone.keySet()) {
                            if (clone.get(key) != 0) {
                                all = false;
                                break;
                            }
                        }
                        if (all) {
                            result.add(startIndex);
                        }
                        matchedWord = 0;
                    }
                }
            }
            return result;
        }
    }

}
