package dailycodingproblem;

/*

Given a stack of N elements, interleave the first half of the stack
with the second half reversed using only one other queue. This should
be done in-place.

Recall that you can only push or pop from a stack, and enqueue or dequeue from a queue.

For example, if the stack is [1, 2, 3, 4, 5], it should become [1, 5, 2, 4, 3]. If the stack is
[1, 2, 3, 4], it should become [1, 4, 2, 3].

[1, 2, 3, 4, 5, 6] -> [1, 6, 2, 5, 3, 4]

[1, 6, 2, 5, 3, 4]
[1, 6, 2, 5, 4, 3]
[1, 6, 2, 3, 4, 5]
[1, 6, 5, 4, 3, 2]
[1, 2, 3, 4, 5, 6]

*/

import java.util.Queue;
import java.util.Stack;

class DCP20180107 {
    static void interleave(Stack<Integer> s, Queue<Integer> q) {
        int len = s.size();
        for (int i = len - 1; i >= 2; i--) {
            rotate(s, q, i);
        }
    }

    static void rotate(Stack<Integer> s, Queue<Integer> q, int k) {
        for (int i = 0; i < k; i++) {
            q.add(s.pop());
        }
        for (int i = 0; i < k; i++) {
            s.push(q.remove());
        }
    }
}
