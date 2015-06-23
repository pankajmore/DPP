package utils;

import java.util.*;

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

    public List<Integer> inOrder()
    {
        List<Integer> vals = new ArrayList<Integer>();
        if(this.left() != null)
            vals.addAll(this.left().inOrder());
        vals.add(this.val());
        if(this.right() != null)
            vals.addAll(this.right().inOrder());
        return vals;
    }

    public List<Integer> preOrder()
    {
        List<Integer> vals = new ArrayList<Integer>();
        vals.add(this.val());
        if(this.left() != null)
            vals.addAll(this.left().preOrder());
        if(this.right() != null)
            vals.addAll(this.right().preOrder());
        return vals;
    }

    public List<Integer> postOrder()
    {
        List<Integer> vals = new ArrayList<Integer>();
        if(this.left() != null)
            vals.addAll(this.left().postOrder());
        if(this.right() != null)
            vals.addAll(this.right().postOrder());
        vals.add(this.val());
        return vals;
    }

    public List<Integer> levelOrder()
    {
        List<Integer> vals = new ArrayList<Integer>();
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

    /**
     * @return List of
     */
    public List<List<Integer>> levelOrderByDepth()
    {
        List<List<Integer>> ls = new ArrayList<List<Integer>>();
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(this);
        int numNodesCurrLevel = 0, numNodesPrevLevel = 0;
        numNodesPrevLevel ++;
        while(!q.isEmpty())
        {
            List<Integer> currDepth = new ArrayList<Integer>();
            while(numNodesPrevLevel > 0 && !q.isEmpty())
            {
                BinaryTreeNode node = q.remove();
                numNodesPrevLevel--;
                currDepth.add(node.val());
                if(node.left() != null){
                    q.add(node.left());
                    numNodesCurrLevel++;
                }
                if(node.right() != null){
                    q.add(node.right());
                    numNodesCurrLevel++;
                }
            }
            numNodesPrevLevel = numNodesCurrLevel;
            numNodesCurrLevel = 0;
            ls.add(currDepth);
        }
        return ls;
    }
}

