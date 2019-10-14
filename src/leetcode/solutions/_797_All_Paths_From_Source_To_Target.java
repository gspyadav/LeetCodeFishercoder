package leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 797. All Paths From Source to Target
 *
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.
 *
 * The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.
 *
 * Example:
 * Input: [[1,2], [3], [3], []]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: The graph looks like this:
 * 0--->1
 * |    |
 * v    v
 * 2--->3
 * There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * Note:
 *
 * The number of nodes in the graph will be in the range [2, 15].
 * You can print different paths in any order, but you should keep the order of nodes inside one path.
 */
public class _797_All_Paths_From_Source_To_Target {
    public static class Solution1 {

        List<List<Integer>> lists;

        private void helper(int[][] graph, int curr, List<Integer> list) {
            list.add(curr);
            if(curr == graph.length-1) {
                lists.add(new ArrayList<Integer>(list));
            }
            for(int neighbor : graph[curr]) {
                helper(graph, neighbor, list);
            }
            list.remove(list.size()-1);
        }

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<Integer> list = new ArrayList<>();
            lists = new ArrayList<>();
            helper(graph, 0, list);
            return lists;
        }
    }
}
