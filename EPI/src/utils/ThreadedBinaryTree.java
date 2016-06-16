package utils;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pankaj on 6/16/16.
 */
public class ThreadedBinaryTree {
    public final int val;
    public ThreadedBinaryTree left, right;
    private boolean leftThreaded, rightThreaded;

    public ThreadedBinaryTree(int val) {
        this.val = val;
    }

    public static ThreadedBinaryTree construct(@NotNull BinaryTreeNode n) {
        ThreadedBinaryTree c = copy(n);
        final List<ThreadedBinaryTree> nodes = c.inOrderPreThreading();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).left == null && i != 0) {
                nodes.get(i).left = nodes.get(i - 1);
                nodes.get(i).leftThreaded = true;
            }
            if (nodes.get(i).right == null && i != nodes.size() - 1) {
                nodes.get(i).right = nodes.get(i + 1);
                nodes.get(i).rightThreaded = true;
            }
        }
        return c;
    }

    private static ThreadedBinaryTree copy(@NotNull BinaryTreeNode n) {
        ThreadedBinaryTree c = new ThreadedBinaryTree(n.val);
        if (n.left != null)
            c.left = copy(n.left);
        if (n.right != null)
            c.right = copy(n.right);
        return c;
    }

    private List<ThreadedBinaryTree> inOrderPreThreading() {
        List<ThreadedBinaryTree> nodes = new ArrayList<>();
        if (this.left != null)
            nodes.addAll(this.left.inOrderPreThreading());
        nodes.add(this);
        if (this.right != null)
            nodes.addAll(this.right.inOrderPreThreading());
        return nodes;
    }

    public List<ThreadedBinaryTree> inOrder() {
        List<ThreadedBinaryTree> nodes = new ArrayList<>();
        if (!this.leftThreaded && this.left != null)
            nodes.addAll(this.left.inOrder());
        nodes.add(this);
        if (!this.rightThreaded && this.right != null)
            nodes.addAll(this.right.inOrder());
        return nodes;
    }

    public List<ThreadedBinaryTree> inOrderMorris() {
        List<ThreadedBinaryTree> nodes = new ArrayList<>();
        ThreadedBinaryTree curr = this;
        while (curr.left != null) curr = curr.left;
        while (curr != null) {
            nodes.add(curr);
            curr = curr.inOrderMorrisSuccessor();
        }
        return nodes;
    }

    public List<ThreadedBinaryTree> inOrderMorrisReverse() {
        List<ThreadedBinaryTree> nodes = new ArrayList<>();
        ThreadedBinaryTree curr = this;
        while (curr.right != null) curr = curr.right;
        while (curr != null) {
            nodes.add(curr);
            curr = curr.inOrderMorrisPredecessor();
        }
        return nodes;
    }

    public ThreadedBinaryTree inOrderMorrisSuccessor() {
        if (this.right == null) {
            return null;
        } else {
            if (this.rightThreaded) return this.right;
            ThreadedBinaryTree curr = this.right;
            while (curr.left != null && !curr.leftThreaded) curr = curr.left;
            return curr;
        }
    }

    public ThreadedBinaryTree inOrderMorrisPredecessor() {
        if (this.left == null) {
            return null;
        } else {
            if (this.leftThreaded) return this.left;
            ThreadedBinaryTree curr = this.left;
            while (curr.right != null && !curr.rightThreaded) curr = curr.right;
            return curr;
        }
    }
}
