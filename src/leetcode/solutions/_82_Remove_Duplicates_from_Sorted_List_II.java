package leetcode.solutions;

import leetcode.common.classes.ListNode;

/**
 * 82. Remove Duplicates from Sorted List II
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class _82_Remove_Duplicates_from_Sorted_List_II {
    public static class Solution1 {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode fakeHead = new ListNode(-1);
            fakeHead.next = head;
            ListNode pre = fakeHead;
            ListNode curr = head;
            while (curr != null) {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                if (pre.next == curr) {
                    pre = pre.next;
                } else {
                    pre.next = curr.next;
                }
                curr = curr.next;
            }
            return fakeHead.next;
        }
    }

}
