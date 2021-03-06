package leetcode.solutions;

import leetcode.common.classes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. Minimum Depth of Binary Tree
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 */

public class _111_Minimum_Depth_of_Binary_Tree {
    public static class Solution1 {
        /**
         * DFS
         */
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            if (left == 0) {
                return right + 1;
            }
            if (right == 0) {
                return left + 1;
            }
            return Math.min(left, right) + 1;
        }
    }

    public static class Solution2 {
        /**
         * BFS
         */
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> q = new LinkedList();
            q.offer(root);
            int level = 0;
            while (!q.isEmpty()) {
                level++;
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode curr = q.poll();
                    if (curr.left != null) {
                        q.offer(curr.left);
                    }
                    if (curr.right != null) {
                        q.offer(curr.right);
                    }
                    if (curr.left == null && curr.right == null) {
                        return level;
                    }
                }
            }
            return level;
        }
    }
}
