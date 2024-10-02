package org.ferreiras.leetcode;

import java.util.LinkedList;
import java.util.Queue;
/*
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */


public class BinaryTreeHeight {

  public static void main(String... args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    System.out.println("Height(Depth) of tree is: "
            + height(root));
  }


  public static int height(TreeNode root) {
    // Initialising a variable to count the
    // height of tree
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root);
    int height = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode temp = q.poll();
        assert temp != null;
        if (temp.left != null) {
          q.add(temp.left);
        }
        if (temp.right != null) {
          q.add(temp.right);
        }
      }
      height++;
    }
    return height;
  }

  public int maxxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int lHeight = maxxDepth(root.left);
    int rHeight = maxxDepth(root.right);
    return Math.max(lHeight, rHeight) + 1;
  }
}
