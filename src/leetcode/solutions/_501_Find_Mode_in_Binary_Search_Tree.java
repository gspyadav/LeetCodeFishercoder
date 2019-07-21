package leetcode.solutions;

import leetcode.common.classes.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


/**
 * 501. Find Mode in Binary Search Tree
 *
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * For example:
 * Given BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 *
 *
 * return [2].
 *
 * Note: If a tree has more than one mode, you can return them in any order.
 *
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */
public class _501_Find_Mode_in_Binary_Search_Tree {

    public static class Solution1 {
        public int[] findMode(TreeNode root) {
            int[] result = new int[]{};
            Map<Integer, Integer> map = new HashMap();
            if (root == null) {
                return result;
            }
            List<Integer> list = bfs(root, map);
            result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }

        private List<Integer> bfs(TreeNode root, Map<Integer, Integer> map) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = queue.poll();
                    if (treeNode.left != null) {
                        queue.offer(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.offer(treeNode.right);
                    }
                    map.put(treeNode.val, map.getOrDefault(treeNode.val, 0) + 1);
                }
            }

            int highestFrequency = 0;
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > highestFrequency) {
                    highestFrequency = entry.getValue();
                    list.clear();
                    list.add(entry.getKey());
                } else if (entry.getValue() == highestFrequency) {
                    list.add(entry.getKey());
                }
            }

            return list;
        }
    }

    public static class Solution2 {
        public int[] findMode(TreeNode root) {
            Map<Integer, Integer> map = new HashMap<>();
            dfs(root, map);
            int modeCount = 0;
            for (int key : map.keySet()) {
                modeCount = Math.max(modeCount, map.get(key));
            }
            List<Integer> mode = new ArrayList<>();
            for (int key : map.keySet()) {
                if (map.get(key) == modeCount) {
                    mode.add(key);
                }
            }
            int[] result = new int[mode.size()];
            for (int i = 0; i < mode.size(); i++) {
                result[i] = mode.get(i);
            }
            return result;
        }

        private void dfs(TreeNode root, Map<Integer, Integer> map) {
            if (root == null) {
                return;
            }
            dfs(root.left, map);
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            dfs(root.right, map);
        }
    }

}
