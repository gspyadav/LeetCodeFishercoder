package leetcode.gspycoder.solutions;

import leetcode.gspycoder.common.classes.TreeLinkNode;

/**
 * 117. Populating Next Right Pointers in Each Node II
 *
 * Given a binary tree
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 *
 *
 * Example:
 *           1
 *         /  \
 *        2    3
 *       / \    \
 *      4   5    7
 *
 *
 *           1 -> null
 *         /  \
 *        2 -> 3 -> null
 *       / \    \
 *      4 ->5 -> 7 -> null
 *
 *
 * Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 *
 * Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":null,"right":null,"val":7},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"6","left":null,"next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"6"},"val":1}
 *
 * Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B.
 *
 *
 * Note:
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 **/

public class _117_Populating_Next_Right_Pointers_in_Each_Node_II {
    public static class Solution1 {
        /**
         * credit: https://discuss.leetcode.com/topic/1106/o-1-space-o-n-complexity-iterative-solution
         * O(1) space, based on level order traversal
         */
        public TreeLinkNode connect(TreeLinkNode root) {

            TreeLinkNode head = null; //head of the next level
            TreeLinkNode prev = null; //the leading node on the next level
            TreeLinkNode cur = root;  //current node of current level

            while (cur != null) {

                while (cur != null) { //iterate on the current level
                    //left child
                    if (cur.left != null) {
                        if (prev != null) {
                            prev.next = cur.left;
                        } else {
                            head = cur.left;
                        }
                        prev = cur.left;
                    }
                    //right child
                    if (cur.right != null) {
                        if (prev != null) {
                            prev.next = cur.right;
                        } else {
                            head = cur.right;
                        }
                        prev = cur.right;
                    }
                    //move to next node
                    cur = cur.next;
                }

                //move to next level
                cur = head;
                head = null;
                prev = null;
            }
            return root;
        }
    }
}
