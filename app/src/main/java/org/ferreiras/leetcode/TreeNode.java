package org.ferreiras.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
  /*
   * Definition for a binary tree node.
   */
  private TreeNode root;
  int value;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int value) {
    this.value = value;
  }

  TreeNode(int value, TreeNode left, TreeNode right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public TreeNode getRoot() {
    return root;
  }

  public static TreeNode newNode(int key) {
    TreeNode temp = new TreeNode();
    temp.value = key;
    temp.left = temp.right = null;
    return temp;
  }

  public boolean insert(int value) {
    TreeNode newNode = new TreeNode(value);
    if (root == null) {
      root = newNode;
      return true;
    }
    TreeNode temp = root;
    while (true) {
      if (newNode.value == temp.value) return false;
      if (newNode.value < temp.value) {
        if (temp.left == null) {
          temp.left = newNode;
          return true;
        }
        temp = temp.left;
      } else {
        if (temp.right == null) {
          temp.right = newNode;
          return true;
        }
        temp = temp.right;
      }
    }
  }

  public boolean contains(int value) {
    if (root == null) return false;
    TreeNode temp = root;
    while (temp != null) {
      if (value < temp.value) {
        temp = temp.left;
      } else if (value > temp.value) {
        temp = temp.right;
      } else {
        return true;
      }
    }
    return false;
  }

  public List<Integer> dfsPreOrder(TreeNode node) {
    if (node == null) return new ArrayList<>();
    List<Integer> results = new ArrayList<>();
    results.add(node.value);
    while (node.left != null) {
      results.add(node.left.value);
      dfsPreOrder(node.left);
    }
    while (node.right != null) {
      results.add(node.right.value);
      dfsPreOrder(node.right);
    }

    return results;
  }

  public List<Integer> depthFirstSearchPreOrder() {
    List<Integer> results = new ArrayList<>();
    class Traverse {
      Traverse(TreeNode currentNode) {
        results.add(currentNode.value);
        if (currentNode.left != null) {
          new Traverse(currentNode.left);
        }
        if (currentNode.right != null) {
          new Traverse(currentNode.right);
        }
      }
    }
    new Traverse(root);
    return results;
  }
}

