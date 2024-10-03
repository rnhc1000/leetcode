package ferreiras.leetcode;
/**
 * Given a binary tree, find the lowest common ancestor (LCA)
 * of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the
 * lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 */

import java.util.*;

public class LowestCommonAncestor {
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

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    parent.put(root, null);
    stack.push(root);

    while (!parent.containsKey(p) || !parent.containsKey(q)) {
      TreeNode node = stack.pop();
      if (node.left != null) {
        parent.put(node.left, node);
        stack.push(node.left);
      }
      if (node.right != null) {
        parent.put(node.right, node);
        stack.push(node.right);
      }
    }
    Set<TreeNode> ancestors = new HashSet<>();
    while (p != null) {
      ancestors.add(p);
      p = parent.get(p);
    }
    while (!ancestors.contains(q))
      q = parent.get(q);
    return q;
  }
}
