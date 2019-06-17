package leetcode.gspycoder.solutions;

import leetcode.gspycoder.common.classes.ListNode;

/**
 * 148. Sort List
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class _148 {

    public static class Solution1 {
        /**
         * Credit: https://discuss.leetcode.com/topic/18100/java-merge-sort-solution
         * But this is not using constant space.
         */
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            //Step 1: split the list into halves
            ListNode prev = null;
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                prev = slow;
                fast = fast.next.next;
                slow = slow.next;
            }
            prev.next = null;

            //step 2: sort each half
            ListNode l1 = sortList(head);
            ListNode l2 = sortList(slow);

            //step 3: merge the two halves
            return merge(l1, l2);
        }

        private ListNode merge(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(0);
            ListNode tmp = result;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    tmp.next = l1;
                    l1 = l1.next;
                } else {
                    tmp.next = l2;
                    l2 = l2.next;
                }
                tmp = tmp.next;
            }

            if (l1 != null) {
                tmp.next = l1;
            }
            if (l2 != null) {
                tmp.next = l2;
            }
            return result.next;
        }
    }
}
