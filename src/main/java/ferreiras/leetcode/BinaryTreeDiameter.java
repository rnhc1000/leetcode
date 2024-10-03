package ferreiras.leetcode;
/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two
 * nodes in a tree. This path may or may not pass through the root.
 * The length of a path between two nodes is represented by the number of edges between them.
 * Example 1:
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * Example 2:
 * Input: root = [1,2]
 * Output: 1
 * Constraints:
 * The number of nodes in the tree is in the range [1, 104].
 * -100 <= Node.val <= 100
 */

import java.util.ArrayList;
import java.util.List;
@ClassPreamble(
        author = "Ricardo Ferreira",
        date = "10/01/2024",
        currentRevision = 7,
        lastModified = "10/01/2024",
        lastModifiedBy = "Ricardo Ferreira",
        reviewers = {}
)
public class BinaryTreeDiameter {
  public static int diameterOfBinaryTree(TreeNode root) {
    List<Integer> right = rightSideView(root);
    List<Integer> left = leftSideView(root);

    return Math.max(right.size(), left.size());
  }

  public static List<Integer> rightSideView(TreeNode root) {
    List<Integer> rightHeight = new ArrayList<Integer>();
    rightSide(root, rightHeight, 0);
    return rightHeight;
  }

  public static void rightSide(TreeNode currentNode, List<Integer> rightHeight, int currentDepth) {

    if (currentNode == null) {
      return;
    }

    if (currentDepth == rightHeight.size()) {
      rightHeight.add(currentNode.value);
    }
    rightSide(currentNode.right, rightHeight, currentDepth + 1);
    rightSide(currentNode.right, rightHeight, currentDepth + 1);
  }

  public static List<Integer> leftSideView(TreeNode root) {
    List<Integer> leftHeight = new ArrayList<Integer>();
    leftSide(root, leftHeight, 0);
    return leftHeight;
  }

  public static void leftSide(TreeNode currentNode, List<Integer> leftHeight, int currentDepth) {

    if (currentNode == null) {
      return;
    }

    if (currentDepth == leftHeight.size()) {
      leftHeight.add(currentNode.value);
    }
    leftSide(currentNode.left, leftHeight, currentDepth + 1);
    leftSide(currentNode.right, leftHeight, currentDepth + 1);
  }
  int diameter = 0;

  public int diameterOfBinaryThree(TreeNode root) {
    helper(root);

    return diameter;
  }

  public int helper(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int lNode = helper(root.left);
    int rNode = helper(root.right);
    diameter = Math.max(diameter, lNode + rNode);

    return Math.max(lNode, rNode) + 1;
  }
}
