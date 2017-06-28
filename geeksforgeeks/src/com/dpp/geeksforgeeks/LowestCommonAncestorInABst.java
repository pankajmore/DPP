package com.dpp.geeksforgeeks;

/**
 * http://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1 Created by pankaj on
 * 28/06/17.
 */
class LowestCommonAncestorInABst {
  Node lca(final Node node, final int n1, final int n2) {
    Node curr = node;
    while (curr != null) {
      int val = curr.data;
      if (val > n1 && val > n2) {
        curr = curr.left;
      } else if (val < n1 && val < n2) {
        curr = curr.right;
      } else {
        return curr;
      }
    }
    return null;
  }

  class Node {
    private Node left;
    private Node right;
    private int data;
  }
}
