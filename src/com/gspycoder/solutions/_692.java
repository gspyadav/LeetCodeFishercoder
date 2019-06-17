package com.gspycoder.solutions;

import java.util.*;

/**
 * 692. Top K Frequent Words
 *
 * Given a non-empty list of words, return the k most frequent elements.
 * Your answer should be sorted by frequency from highest to lowest.
 * If two words have the same frequency, then the word with the lower alphabetical order comes first.

 Example 1:
 Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 Output: ["i", "love"]
 Explanation: "i" and "love" are the two most frequent words.
 Note that "i" comes before "love" due to a lower alphabetical order.

 Example 2:
 Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 Output: ["the", "is", "sunny", "day"]
 Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 with the number of occurrence being 4, 3, 2 and 1 respectively.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Input words contain only lowercase letters.

 Follow up:
 Try to solve it in O(n log k) time and O(n) extra space.
 Can you solve it in O(n) time with only O(k) extra space?

 */
public class _692 {

    public static class Solution1 {
        /**
         * O(n) extra space
         * O(nlogk) time
         * */
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }

            SortedSet<Map.Entry<String, Integer>> sortedset = new TreeSet<>(
                    (e1, e2) -> {
                        if (e1.getValue() != e2.getValue()) {
                            return e2.getValue() - e1.getValue();
                        } else {
                            return e1.getKey().compareToIgnoreCase(e2.getKey());
                        }
                    });
            sortedset.addAll(map.entrySet());

            List<String> result = new ArrayList<>();
            Iterator<Map.Entry<String, Integer>> iterator = sortedset.iterator();
            while (iterator.hasNext() && k-- > 0) {
                result.add(iterator.next().getKey());
            }
            return result;
        }


    }
    public static class Solution2 {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> count = new HashMap();
            for (String word : words) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
            List<String> candidates = new ArrayList(count.keySet());
            Collections.sort(candidates, (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                    w1.compareTo(w2) : count.get(w2) - count.get(w1));

            return candidates.subList(0, k);
        }
    }
    public static class Solution3 {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> count = new HashMap();
            for (String word: words) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
            PriorityQueue<String> heap = new PriorityQueue<String>(
                    (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                            w2.compareTo(w1) : count.get(w1) - count.get(w2) );

            for (String word: count.keySet()) {
                heap.offer(word);
                if (heap.size() > k) heap.poll();
            }

            List<String> ans = new ArrayList();
            while (!heap.isEmpty()) ans.add(heap.poll());
            Collections.reverse(ans);
            return ans;
        }
    }
}
