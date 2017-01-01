import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 * Created by pankaj on 01/01/17.
 */
public class ImplementQueueUsingStacks {
    class MyQueue {
        private Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();

        // Push element x to the back of queue.
        public void push(int x) {
            s1.push(x);
        }

        // Removes the element from in front of queue.
        public void pop() {
            peek();
            s2.pop();
        }

        // Get the front element.
        public int peek() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) s2.push(s1.pop());
            }
            return s2.peek();
        }

        // Return whether the aqueue is empty.
        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }
}
