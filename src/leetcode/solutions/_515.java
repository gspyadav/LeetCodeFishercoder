package leetcode.solutions;

import leetcode.common.classes.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. Find Largest Value in Each Tree Row
 *
 * You need to find the largest value in each row of a binary tree.

 Example:
 Input:

      1
     / \
    3   2
   / \   \
  5  3   9

 Output: [1, 3, 9]
 */
public class _515 {

    public static class Solution1 {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if (root != null) {
                queue.offer(root);
                while (!queue.isEmpty()) {
                    int max = Integer.MIN_VALUE;
                    int size = queue.size();
                    for (int i = 0; i < size; i++) {
                        TreeNode curr = queue.poll();
                        max = Math.max(max, curr.val);
                        if (curr.left != null) {
                            queue.offer(curr.left);
                        }
                        if (curr.right != null) {
                            queue.offer(curr.right);
                        }
                    }
                    list.add(max);
                }
            }
            return list;
        }
    }

    public static class Solution2 {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            dfs(root, res, 0);
            return res;

        }

        public void dfs(TreeNode root, List<Integer> res, int level) {
            if (root == null) {
                return;
            }
            if (level == res.size()) {
                res.add(root.val);
            }
            res.set(level, Math.max(res.get(level), root.val));
            dfs(root.left, res, level + 1);
            dfs(root.right, res, level + 1);
        }
    }

}
