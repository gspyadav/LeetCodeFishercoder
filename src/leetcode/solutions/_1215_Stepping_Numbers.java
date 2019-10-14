package leetcode.solutions;

import java.util.*;

public class _1215_Stepping_Numbers {
    public static class Solution1{
        public static List<Integer> countSteppingNumbers(int low, int high) {
            List<Integer> results = new ArrayList<>();
            for (int i = 0; i <= 9; i++) {
                Queue<Long> queue = new LinkedList<Long>();
                queue.add((long)i);
                while (!queue.isEmpty()) {
                    long temp = queue.poll();
                    if (temp <= high && temp >= low) {
                        results.add((int)temp);
                    }
                    if (temp == 0 || temp > high)
                        continue;
                    int last = (int)temp % 10;

                    long prev = temp * 10 + (last - 1);
                    long next = temp * 10 + (last + 1);

                    if (last == 0)
                        queue.add(next);
                    else if (last == 9)
                        queue.add(prev);
                    else {
                        queue.add(prev);
                        queue.add(next);
                    }
                }
            }
            Collections.sort(results);
            return results;
        }
    }
}
