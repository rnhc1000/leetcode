package org.ferreiras.leetCode;

/*
 * You are given the root of a binary tree.
 * A ZigZag path for a binary tree is defined as follows:
 * Choose any node in the binary tree and a direction (right or left).
 * If the current direction is right, move to the right child of the current node;
 * otherwise, move to the left child.
 * Change the direction from right to left or from left to right.
 * Repeat the second and third steps until you can't move in the tree.
 * Zigzag length is defined as the number of nodes visited -
 * 1. (A single node has a length of 0).
 * Return the longest ZigZag path contained in that tree.
 * Input:
 * root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]
 * Output: 3
 * Explanation:
 * Longest ZigZag path in blue nodes (right -> left -> right)
 * Input:
 * root = [1,1,1,null,1,null,null,1,1,null,1]
 * Output: 4
 * Explanation:
 * Longest ZigZag path in blue nodes (left -> right -> left -> right).
 */
public class ZigZagBinaryTree {
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  int max = 0;

  public int longestZigZag(TreeNode root) {
    if (root.left != null)
      helper(root.left, 0, 0);

    if (root.right != null)
      helper(root.right, 1, 0);

    return max;
  }

  void helper(TreeNode root, int direction, int count) {

    if (root == null) {
      max = Math.max(max, count);
      return;
    }

    if (direction == 1) {
      helper(root.left, 0, count + 1);
      helper(root.right, 1, 0);
    } else {
      helper(root.right, 1, count + 1);
      helper(root.left, 0, 0);
    }
  }
}

