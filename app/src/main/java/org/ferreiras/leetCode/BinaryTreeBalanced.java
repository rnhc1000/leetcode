package org.ferreiras.leetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary search tree, return a balanced binary search tree with the same node values.
If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.

Example 1:

Input: root = [1,null,2,null,3,null,4,null,null]
Output: [2,1,3,null,null,null,4]
Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.
Example 2:


Input: root = [2,1,3]
Output: [2,1,3]
Explanation:

balanceBST Method:
Initializes a vector sortedElements to store the sorted node values.
Calls inOrderTraversal to fill sortedElements with in-order traversal of the BST.
Calls buildBalancedBST to construct and return the balanced BST from sortedElements.

buildBalancedBST Method:
Recursively builds a balanced BST from the sorted node values by selecting the middle element
as the root and recursively constructing the left and right subtrees.

inOrderTraversal Method:
Recursively traverses the BST in in-order and collects node values in sortedElements.
 */
public class BinaryTreeBalanced {
  public TreeNode balanceBST(TreeNode root) {

    List<Integer> sortedElements = new ArrayList<>();

    inOrderTraversal(root, sortedElements);

    return buildBalancedBST(sortedElements, 0, sortedElements.size() - 1);

  }

  private static void inOrderTraversal(TreeNode node, List<Integer> sortedElements) {
    if (node == null) {
      return;
    }
    inOrderTraversal(node.left, sortedElements);
    sortedElements.add(node.value);
    inOrderTraversal(node.right, sortedElements);
  }

  private static TreeNode buildBalancedBST(List<Integer> elements, int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = start + (end - start) / 2;
    TreeNode node = new TreeNode(elements.get(mid));
    node.left = buildBalancedBST(elements, start, mid - 1);
    node.right = buildBalancedBST(elements, mid + 1, end);
    return node;
  }
}
