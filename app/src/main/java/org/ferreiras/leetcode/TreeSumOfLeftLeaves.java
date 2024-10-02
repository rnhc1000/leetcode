package org.ferreiras.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
Given the root of a binary tree, return the sum of all left leaves.

A leaf is a node with no children.
A left leaf is a leaf that is the left child of another node.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation:
There are two left leaves in the binary tree, with values 9 and 15 respectively.

Example 2:
Input: root = [1]
Output: 0

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-1000 <= Node.val <= 1000
 */
public class TreeSumOfLeftLeaves {


  static class Pair<T, B> {
    private TreeNode node;
    private Boolean value;

    public Pair(T root, B b) {
    }

    public TreeNode getNode() {
      return node;
    }

    public void setNode(TreeNode node) {
      this.node = node;
    }

    public Boolean getValue() {
      return value;
    }

    public void setValue(Boolean value) {
      this.value = value;
    }
  }
  public static int sumOfLeftLeaves(TreeNode root) {
    if (root == null)
      return 0;


    Queue<Pair<TreeNode, Boolean>> queue = new LinkedList<>();
    queue.offer(new Pair<>(root, false));
    int sum = 0;

    while (!queue.isEmpty()) {

      Pair<TreeNode, Boolean> pair = queue.poll();
      TreeNode node =  pair.getNode();
      boolean isLeft = pair.getValue();

      if (isLeft && node.left == null && node.right == null) {
        sum += node.value;
      }

      if (node.left != null) {
        queue.offer(new Pair<>(node.left, true));
      }

      if (node.right != null) {
        queue.offer(new Pair<>(node.right, false));
      }

    }

    return sum;
  }

  public int sumOfLeftBranches(TreeNode root) {
    if (root == null)
      return 0;

    int sum = 0;

    if (root.left != null) {
      if (root.left.left == null && root.left.right == null)
        sum += root.left.value;
      else
        sum += sumOfLeftBranches(root.left);
    }
    sum += sumOfLeftBranches(root.right);

    return sum;
  }
}
