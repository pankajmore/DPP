package utils;

/**
 * Created by Pankaj on 6/11/15.
 */
/*
* TODO: An interface with another implementaion
* with O(1) best case space complexity
* */
public class StackWithMax extends Stack {
    private Node max;

    public void push(int x) {
        super.push(x);
        if (max != null && max.val > x)
            x = max.val;
        max = Node.prepend(max, x);
    }

    public int peek() throws Exception {
        return super.peek();
    }

    public int pop() throws Exception {
        max = max.next;
        return super.pop();
    }

    public int max() throws Exception {
        if (max == null)
            throw new Exception("Stack is Empty!");
        return max.val;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if (max != null)
            sb.append("\n").append(max.toString());
        return sb.toString();
    }
}
