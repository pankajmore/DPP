package BTree;

/**
 * Created by pankaj on 1/29/16.
 */
public class BTreeLeaf<T> extends BTree<T> {
    public final Employee emp;

    public BTreeLeaf(Employee employee) {
        super();
        emp = employee;
    }
}
