package leetcode.solutions;

import leetcode.common.classes.ListNode;

/**
 * 2. Add Two Numbers

 You are given two linked lists representing two non-negative numbers.
 The digits are stored in reverse order and each of their nodes contain a single digit.
 Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */

public class _2_Add_Two_Numbers {
    public static class Solution1 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(0);
            ListNode tmp = result;
            int sum = 0;
            while (l1 != null || l2 != null) {
                sum /= 10;
                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }
                tmp.next = new ListNode(sum % 10);
                tmp = tmp.next;
            }
            if (sum / 10 == 1) {
                tmp.next = new ListNode(1);//this means there's a carry, so we add additional 1, e.g. [5] + [5] = [0, 1]
            }
            return result.val == 0 ? result.next : result;
        }
    }

    public static class Solution2 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode pre = new ListNode(-1);
            ListNode head = new ListNode(0);
            pre.next = head;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int val = carry;
                if (l1 != null) {
                    val += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    val += l2.val;
                    l2 = l2.next;
                }
                if (val >= 10) {
                    val %= 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                head.next = new ListNode(val);
                head = head.next;
            }
            if (carry != 0) {
                head.next = new ListNode(carry);
            }
            return pre.next.next;
        }
    }

    public static class Practice{
        public ListNode addNumbers(ListNode num1, ListNode num2){
            ListNode result = new ListNode(-1);
            ListNode temp = result;
            int carry =0;
            while(num1!=null || num2!=null){
                int sum = carry;
                if(num1!=null){
                    sum+=num1.val;
                    num1 = num1.next;
                }
                if(num2!=null){
                    sum+=num2.val;
                    num2=num2.next;
                }
                temp.next = new ListNode(sum%10);
                temp = temp.next;
                if(sum >= 10){
                    carry = 1;
                }else{
                    carry = 0;
                }
            }
            if(carry>0){
                temp.next = new ListNode(carry);
            }
            return result.next;
        }
    }
}
