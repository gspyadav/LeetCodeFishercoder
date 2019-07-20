package leetcode.solutions;

import leetcode.common.classes.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 * <p>
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 *          3
 *         / \
 *        9  20
 *          /  \
 *         15   7
 * <p>
 * return its level order traversal as:
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class _102_Binary_Tree_Level_Order_Traversal {

    public static class Solution1 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> q = new LinkedList();
            q.offer(root);
            while (!q.isEmpty()) {
                List<Integer> thisLevel = new ArrayList();
                int qSize = q.size();
                for (int i = 0; i < qSize; i++) {
                    TreeNode curr = q.poll();
                    thisLevel.add(curr.val);
                    if (curr.left != null) {
                        q.offer(curr.left);
                    }
                    if (curr.right != null) {
                        q.offer(curr.right);
                    }
                }
                result.add(thisLevel);
            }
            return result;
        }
    }
}
