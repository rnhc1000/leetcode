package org.ferreiras.leetcode;

/**
 * Given the roots of two binary trees p and q, write a function to check if they
 * are the same or not.
 * Two binary trees are considered the same if they are structurally identical,
 * and the nodes have the same valueue.
 * Example 1:
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * Example 2:
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * Example 3:
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 * Constraints:
 * The number of nodes in both trees is in the range [0, 100].
 * -104 <= Node.value <= 104
 */
public class SameTree {
  public static void main(String[] args) {

  }
  public boolean isSameTree(TreeNode p, TreeNode q) {
    boolean check = false, checkLeft = false, checkRight = false;
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;
    check = p.value == q.value;
    checkLeft = isSameTree(p.left, q.left);
    checkRight = isSameTree(p.right, q.right);

    return check &&  checkLeft && checkRight;
  }
}
