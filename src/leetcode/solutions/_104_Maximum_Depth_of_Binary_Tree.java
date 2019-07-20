package leetcode.solutions;

import leetcode.common.classes.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree
 * <p>
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class _104_Maximum_Depth_of_Binary_Tree {

    public static class Solution1 {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
