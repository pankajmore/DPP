package BTree;

import java.util.List;

/**
 * Created by pankaj on 1/29/16.
 */
public class BTreeNode<T> extends BTree<T> {
    public BTreeNode(List<Employee> employees, int numChildren) {
        super(employees, numChildren);
    }
}
