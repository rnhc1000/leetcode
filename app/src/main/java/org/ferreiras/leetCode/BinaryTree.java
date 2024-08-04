package org.ferreiras.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
  TreeNode root;

  @Override
  public String toString() {
    return "BinaryTree{" +
            "root=" + root +
            '}';
  }

  public BinaryTree() {
  }

  public BinaryTree(TreeNode root) {
    this.root = root;
  }

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.root = new TreeNode(1);
    tree.root.left = new TreeNode(2);
    tree.root.right = new TreeNode(3);
    tree.root.left.left = new TreeNode(4);
    tree.root.left.right = new TreeNode(5);
    tree.root.right.left = new TreeNode(6);
    tree.root.right.right = new TreeNode(7);
    tree.root.left.left.left = new TreeNode(8);
    tree.root.left.left.right = new TreeNode(9                        );

    List<Integer> list = tree.dfsPreOrder(tree.root);
    System.out.println(list);
    int h = tree.heightOfTree(tree.root);
    System.out.println(h);
    int d = tree.diameterOfTree(tree.root);
    System.out.println(tree.diameter);
  }

  List<Integer> results = new ArrayList<>();

  public List<Integer> dfsPreOrder(TreeNode node) {
    if (node == null) return new ArrayList<>();

    results.add(node.value);
    if (node.left != null) {
      dfsPreOrder(node.left);
    }
    if (node.right != null) {
      dfsPreOrder(node.right);
    }

    return results;
  }

  public int heightOfTree(TreeNode node) {
    if (node == null) return -1;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(node);
    int height = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode currentNode = queue.poll();
        assert currentNode != null;
        if (currentNode.left != null) {
          queue.offer(currentNode.left);
        }
        if (currentNode.right != null) {
          queue.offer(currentNode.right);
        }
      }
      height++;
    }

    return height;
  }

  int diameter = 0;
  public int diameterOfTree(TreeNode node) {
    if (node == null) return 0;
    int leftNode = diameterOfTree(node.left);
    int rightNode = diameterOfTree(node.right);
    diameter = Math.max(diameter, rightNode + leftNode);

    return Math.max(rightNode, leftNode) + 1;
  }
}
