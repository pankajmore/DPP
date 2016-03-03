package BTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pankaj on 1/29/16.
 */
public class BTree<T> {
    private List<Integer> values;
    private List<BTree<T>> children;

    public BTree() {

    }

    public BTree(List<Employee> employees, int numChildren) {
        values = new ArrayList<>();
        children = new ArrayList<>();
        //leaf node
        if (employees.size() < numChildren) {
            for (int i = 0; i < employees.size(); i++) {
                values.add(employees.get(i).id);
                children.add(new BTreeLeaf<T>(employees.get(i)));
            }
        }
        //internal node
        for (int i = 0; i < employees.size(); i += employees.size() / numChildren) {
            values.add(employees.get(i).id);
            children.add(new BTreeNode<T>(employees.subList(i, i + employees.size() / numChildren), numChildren));
        }
    }

    private BTree findChild(int id) {
        int i;
        for (i = 0; i < values.size(); i++) {
            if (values.get(i) > id) break;
        }
        return children.get(i);
    }

    public Employee select(int id) {
        BTree t = findChild(id);
        if (t instanceof BTreeLeaf) return ((BTreeLeaf) t).emp;
        return t.select(id);
    }

}
