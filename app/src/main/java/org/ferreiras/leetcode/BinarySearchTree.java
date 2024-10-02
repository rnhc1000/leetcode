package org.ferreiras.leetcode;

/*
 * You are given the root of a binary search tree (BST) and an integer val.
 * Find the node in the BST that the node's value equals val and return the subtree
 * rooted with that node. If such a node does not exist, return null.
 * Input: root = [4,2,7,1,3], val = 2
 * Output: [2,1,3]
 * Input: root = [4,2,7,1,3], val = 5
 * Output: []
 */

@ClassPreamble(
        author = "Ricardo Ferreira",
        date = "10/01/2024",
        currentRevision = 7,
        lastModified = "10/01/2024",
        lastModifiedBy = "Ricardo Ferreira",
        reviewers = {}
)
public class BinarySearchTree {

  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null)
      return null;
    if (root.value == val) return root;
    TreeNode bst = null;

    if (root.value > val) {
      bst = searchBST(root.left, val);
    } else {
      bst = searchBST(root.right, val);
    }

    return bst;
  }
}
