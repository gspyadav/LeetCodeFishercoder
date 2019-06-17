package leetcode.gspycoder.solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 * <p>
 * Implement the following operations of a stack using queues.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * <p>
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 * Update (2015-06-11):
 * The class name of the Java function had been updated to MyStack instead of Stack.
 */

public class _225 {

    public static class Solution1 {
        class MyStack {

            Queue<Integer> q = new LinkedList();

            // Push element x onto stack.
            public void push(int x) {
                q.offer(x);
                for (int i = 1; i < q.size(); i++) {
                    q.offer(q.remove());
                }
            }

            // Removes the element on top of the stack.
            public void pop() {
                q.poll();
            }

            // Get the top element.
            public int top() {
                return q.peek();
            }

            // Return whether the stack is empty.
            public boolean empty() {
                return q.isEmpty();
            }
        }
    }

    public static class Solution2 {
        class MyStack2 {
            private Queue<Integer> q1;
            private Queue<Integer> q2;

            /**
             * Initialize your data structure here.
             */
            public MyStack2() {
                q1 = new LinkedList<Integer>();
                q2 = new LinkedList<Integer>();
            }

            /**
             * Push element x onto stack.
             */
            public void push(int x) {

                q1.offer(x);
                while (!q2.isEmpty()) {
                    q1.offer(q2.remove());
                }
                Queue<Integer> temp = q1;
                q1 = q2;
                q2 = temp;
            }

            /**
             * Removes the element on top of the stack and returns that element.
             */
            public int pop() {
                if (!q2.isEmpty()) {
                    return q2.remove();
                } else {
                    return -1;
                }

            }

            /**
             * Get the top element.
             */
            public int top() {
                if (!q2.isEmpty()) {
                    return q2.peek();
                }
                return -1;
            }

            /**
             * Returns whether the stack is empty.
             */
            public boolean empty() {
                return q2.isEmpty();

            }
        }
    }
}
