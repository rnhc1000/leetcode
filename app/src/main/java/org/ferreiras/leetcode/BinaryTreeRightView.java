package org.ferreiras.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * Input:
 * root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * Input: root = [1,null,3]
 * Output: [1,3]
 * Input: root = []
 * Output: []
 */

public class BinaryTreeRightView {

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    // Call the recursive rightView function to populate the
    // right side view of the tree
    rightSide(root, result, 0);
    return result;
  }

  // Recursive function to populate the right side view of the tree
  public void rightSide(TreeNode currentNode, List<Integer> result, int currentDepth){
    // If the current node is null, we have reached the end of the tree or a leaf node
    if(currentNode == null){
      return;
    }

    // If the current depth is equal to the size of the result list, it means we are
    // visiting the rightmost node at this depth for the first time
    // So, add the current node's value to the result list for the right side view
    if(currentDepth == result.size()){
      result.add(currentNode.value);
    }

    // Recursively call the rightSide function on the right and left subtrees,
    // incrementing the current depth by 1 for each recursive call
    // The right subtree is processed before the left subtree, ensuring that the rightmost
    // node at each depth is added to the result list
    rightSide(currentNode.right, result, currentDepth + 1);
    rightSide(currentNode.left, result, currentDepth + 1);
  }
}
