package puzzles;

import utils.Node;

/**
 * Created by pankaj on 2/7/16.
 */
public class DeletionList {
    /**
     * Assumes that the node is not tail!
     *
     * @param node the node to delete in the list
     */
    public void deleteNode(Node node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
