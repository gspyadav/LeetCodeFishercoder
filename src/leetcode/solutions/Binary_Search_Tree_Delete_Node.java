package leetcode.solutions;

import leetcode.common.classes.TreeNode;

public class Binary_Search_Tree_Delete_Node {
    public static class Solution1 {
        public static class BSTDeleteNode {
            public TreeNode deleteNode(TreeNode root, int key) {
                if (root == null) {
                    return root;
                }

                if (key < root.val) {
                    root.left = deleteNode(root.left, key);
                } else if (key > root.val) {
                    root.right = deleteNode(root.right, key);
                } else {
                    if (root.left == null)
                        return root.right;
                    else if (root.right == null)
                        return root.left;
                    root.val = leftMostNode(root.right);
                    root.right = deleteNode(root.right, root.val);
                }
                return root;
            }
        }

        private static int leftMostNode(TreeNode root) {
            int leftMost = root.val;
            while (root.left != null) {
                leftMost = root.left.val;
                root = root.left;
            }
            return leftMost;
        }
    }
}
