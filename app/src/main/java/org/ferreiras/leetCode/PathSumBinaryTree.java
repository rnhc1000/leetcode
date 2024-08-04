package org.ferreiras.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given the root of a binary tree and an integer targetSum,
 * return the number of paths where the sum of the values
 * along the path equals targetSum.
 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 * Input:
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 * Example 2:
 * Input:
 * root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: 3
 */
public class PathSumBinaryTree {
  class TreeNode {
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

  int sum = 0;

  public int pathSum(TreeNode root, int targetSum) {
    if (root == null)
      return 0;
    Map<Long, Integer> map = new HashMap<>();
    map.put(0L, 1);

    helper(root, targetSum, map, 0L);

    return sum;
  }

  public void helper(TreeNode root, int target, Map<Long, Integer> map, long current) {

    if (root == null)
      return;

    current = current + root.val;

    if (map.containsKey(current - target)) {
      sum += map.get(current - target);
    }

    map.put(current, map.getOrDefault(current, 0) + 1);

    if (root.left != null)
      helper(root.left, target, map, current);

    if (root.right != null)
      helper(root.right, target, map, current);

    map.put(current, map.get(current) - 1);

  }
}
