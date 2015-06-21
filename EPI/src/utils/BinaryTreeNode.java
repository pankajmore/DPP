package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Pankaj on 6/12/15.
 */
public class BinaryTreeNode {
    private int _val;
    private BinaryTreeNode _left;
    private BinaryTreeNode _right;

    public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right)
    {
        this._val = val;
        this._left = left;
        this._right = right;
    }

    public int val() { return _val; }

    public BinaryTreeNode left() {
        return _left;
    }

    public BinaryTreeNode right() {
        return _right;
    }

    public ArrayList<Integer> inOrder()
    {
        ArrayList<Integer> vals = new ArrayList<Integer>();
        if(this.left() != null)
            vals.addAll(this.left().inOrder());
        vals.add(this.val());
        if(this.right() != null)
            vals.addAll(this.right().inOrder());
        return vals;
    }

    public ArrayList<Integer> preOrder()
    {
        ArrayList<Integer> vals = new ArrayList<Integer>();
        vals.add(this.val());
        if(this.left() != null)
            vals.addAll(this.left().preOrder());
        if(this.right() != null)
            vals.addAll(this.right().preOrder());
        return vals;
    }

    public ArrayList<Integer> postOrder()
    {
        ArrayList<Integer> vals = new ArrayList<Integer>();
        if(this.left() != null)
            vals.addAll(this.left().postOrder());
        if(this.right() != null)
            vals.addAll(this.right().postOrder());
        vals.add(this.val());
        return vals;
    }

    public ArrayList<Integer> levelOrder()
    {
        ArrayList<Integer> vals = new ArrayList<Integer>();
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(this);
        while(!q.isEmpty())
        {
            BinaryTreeNode node = q.remove();
            vals.add(node.val());
            if(node.left() != null)
                q.add(node.left());
            if(node.right() != null)
                q.add(node.right());
        }
        return vals;
    }

    public ArrayList<ArrayList<Integer>> levelOrderByDepth()
    {
        ArrayList<ArrayList<Integer>> ls = new ArrayList<ArrayList<Integer>>();
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(this);
        int numNodesCurrLevel = 0, numNodePrevLevel = 0;
        numNodesCurrLevel ++;
        while(!q.isEmpty())
        {
            ArrayList<Integer> currDepth = new ArrayList<Integer>();
            while(numNodesCurrLevel > 0 && !q.isEmpty())
            {
                BinaryTreeNode node = q.remove();
                numNodesCurrLevel--;
                //TODO: incomplete
            }
        }
        return ls;
    }
}

