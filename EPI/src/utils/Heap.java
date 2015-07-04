package utils;

/**
 * Created by Pankaj on 7/4/15.
 */
public interface Heap {

    public void insert(int x);

    public int find_max();

    public void delete_max(int x);

    public int size();

    public boolean isEmpty();

}
