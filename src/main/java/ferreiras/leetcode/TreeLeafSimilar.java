package ferreiras.leetcode;
/**
 * Consider all the leaves of a binary tree, from left to right order,
 * the values of those leaves form a leaf value sequence.
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * Return true if and only if the two given trees with head nodes root1 and root2 are
 * leaf-similar.
 * Input:
 * root1 = [3,5,1,6,2,9,8,null,null,7,4],
 * root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * Output: true
 * Input: root1 = [1,2,3],
 * root2 = [1,3,2]
 * Output: false
 */

import java.util.ArrayList;
import java.util.List;

public class TreeLeafSimilar {


  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> listOne = new ArrayList<>();
    List<Integer> listTwo = new ArrayList<>();
    traverse(root1, listOne);
    traverse(root2, listTwo);
    return listOne.equals(listTwo);
  }

  public void traverse(TreeNode currentNode, List<Integer> list) {
    if (currentNode == null) {
      return;
    }
    if (currentNode.right == null && currentNode.left == null) {
      list.add(currentNode.value);
    } else {
      traverse(currentNode.left, list);
      traverse(currentNode.right, list);
    }
  }
}
