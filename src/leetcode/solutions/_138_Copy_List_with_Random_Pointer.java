package leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer
 *
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input:
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 *
 * Explanation:
 * Node 1's value is 1, both of its next and random pointer points to Node 2.
 * Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 *
 *
 * Note:
 *
 * You must return the copy of the given head as a reference to the cloned list.
 */

public class _138_Copy_List_with_Random_Pointer {
    public static class Solution1 {
        public RandomListNode copyRandomList(RandomListNode head) {
            /**Key is the original nodes, value is the new nodes we're deep copying to.*/
            Map<RandomListNode, RandomListNode> map = new HashMap();
            RandomListNode node = head;

            //loop for the first time: copy the node themselves with only labels
            while (node != null) {
                map.put(node, new RandomListNode(node.label));
                node = node.next;
            }

            //loop for the second time: copy random and next pointers
            node = head;
            while (node != null) {
                map.get(node).next = map.get(node.next);
                map.get(node).random = map.get(node.random);
                node = node.next;
            }

            return map.get(head);
        }

        // Definition for singly-linked list with a random pointer.
        class RandomListNode {
            int label;

            RandomListNode next;
            RandomListNode random;

            RandomListNode(int x) {
                this.label = x;
            }
        }
    }
}
