package leetcode.gspycoder.solutions;

import leetcode.gspycoder.common.classes.ListNode;
import leetcode.gspycoder.common.classes.TreeNode;

/**
 * 109. Convert Sorted List to Binary Search Tree
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class _109_Convert_Sorted_List_to_Binary_Search_Tree {

    public static class Solution1 {

        public TreeNode sortedListToBST(ListNode head) {
            return toBstRecursively(head, null);
        }

        public TreeNode toBstRecursively(ListNode start, ListNode end) {
            if (start == end) {
                return null;
            } else {
                ListNode mid = start;
                ListNode fast = start;
                while (fast != end && fast.next != end) {
                    mid = mid.next;
                    fast = fast.next.next;
                }

                TreeNode root = new TreeNode(mid.val);
                root.left = toBstRecursively(start, mid);
                root.right = toBstRecursively(mid.next, end);
                return root;
            }
        }
    }
}
