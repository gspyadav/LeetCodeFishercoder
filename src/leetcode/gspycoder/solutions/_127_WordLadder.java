package leetcode.gspycoder.solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 127. Word Ladder
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 *
 * Example 1:
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Example 2:
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

public class _127_WordLadder {
    public static class Solution1 {

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> beginSet = new HashSet<>();
            Set<String> endSet = new HashSet<>();
            Set<String> visited = new HashSet<>();
            Set<String> dict = new HashSet<>(wordList);
            int len = 1;

            beginSet.add(beginWord);

            if (dict.contains(endWord)) {
                endSet.add(endWord);
            }

            while (!beginSet.isEmpty() && !endSet.isEmpty()) {
                Set<String> nextBeginSet = new HashSet<>();
                for (String word : beginSet) {
                    char[] chars = word.toCharArray();
                    for (int i = 0; i < chars.length; i++) {
                        for (char c = 'a'; c <= 'z'; c++) {
                            char old = chars[i];
                            if(old!=c){
                                chars[i] = c;
                            }
                            String newWord = new String(chars);
                            if (endSet.contains(newWord)) {
                                return len + 1;
                            }

                            if (!visited.contains(newWord) && dict.contains(newWord)) {
                                visited.add(newWord);
                                nextBeginSet.add(newWord);
                            }
                            chars[i] = old;
                        }
                    }
                }

                beginSet = nextBeginSet;
                len++;
            }
            return 0;
        }
    }
    
    class WordNode{
        String word;
        int numSteps;

        public WordNode(String word, int numSteps){
            this.word = word;
            this.numSteps = numSteps;
        }
    }

    public class Solution2 {
        public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
            LinkedList<WordNode> queue = new LinkedList<WordNode>();
            queue.add(new WordNode(beginWord, 1));

            wordDict.add(endWord);

            while(!queue.isEmpty()){
                WordNode top = queue.remove();
                String word = top.word;

                if(word.equals(endWord)){
                    return top.numSteps;
                }

                char[] arr = word.toCharArray();
                for(int i=0; i<arr.length; i++){
                    for(char c='a'; c<='z'; c++){
                        char temp = arr[i];
                        if(arr[i]!=c){
                            arr[i]=c;
                        }

                        String newWord = new String(arr);
                        if(wordDict.contains(newWord)){
                            queue.add(new WordNode(newWord, top.numSteps+1));
                            wordDict.remove(newWord);
                        }

                        arr[i]=temp;
                    }
                }
            }

            return 0;
        }
    }
}
