package leetcode.solutions;

import leetcode.common.classes.TreeNode;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants
 * (where we allow a node to be a descendant of itself).”

          _______6______
         /              \
     ___2__          ___8__
    /      \        /      \
    0      4        7       9
         /  \
        3   5

 Example 1:

 Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 Output: 6
 Explanation: The LCA of nodes 2 and 8 is 6.
 Example 2:

 Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 Output: 2
 Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.


 Note:

 All of the nodes' values will be unique.
 p and q are different and both values will exist in the BST.

 */
public class _235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

    public static class Solution1 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || p == root || q == root) {
                return root;
            }
            if ((root.val - p.val) * (root.val - q.val) > 0) {
                if (root.val - p.val > 0) {
                    return lowestCommonAncestor(root.left, p, q);
                }
                return lowestCommonAncestor(root.right, p, q);
            }
            return root;
        }
    }

    public static class Solution2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (p == root || q == root || p == q) {
                return root;
            }
            if (p.val < root.val && q.val > root.val) {
                return root;
            }
            if (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            }
            if (p.val > root.val && q.val > root.val) {
                return lowestCommonAncestor(root.right, p, q);
            }
            return root;
        }
    }
}
