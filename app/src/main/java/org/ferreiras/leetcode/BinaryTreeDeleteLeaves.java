package org.ferreiras.leetcode;
/*
https://leetcode.com/problems/delete-leaves-with-a-given-value/
Given a binary tree root and an integer target, delete all the leaf nodes with value target.

Note that once you delete a leaf node with value target, if its parent node becomes a leaf node
and has the value target, it should also be deleted (you need to continue doing that until you cannot).


Example 1:

Input: root = [1,2,3,2,null,2,4], target = 2
Output: [1,null,3,null,4]
Explanation:
Leaf nodes in green with value (target = 2) are removed (Picture in left).
After removing, new nodes become leaf nodes with value (target = 2) (Picture in center).

Example 2:

Input: root = [1,3,3,3,2], target = 3
Output: [1,3,null,null,2]

Example 3:

Input: root = [1,2,null,2,null,2], target = 2
Output: [1]
Explanation: Leaf nodes in green with value (target = 2) are removed at each step.

Intuition https://leetcode.com/Saketh3011
We can use recursive approach where we can traverse the tree and check each node's children.
If a node's children are leaves with the value target, they should be deleted, i.e return null.
So we performed bottom-up (post-order traversal), to ensuring that any new leaf nodes formed by
deletions are also evaluated.

🧠 Approach:
Use recursion that processes the tree in a post-order manner (left, right, root).
For each node, recursively call the function on its left and right children.
After processing the children, check if the current node is a leaf node with the value target.
If so, delete the node by returning null.
If a node have both left and right as null its a leaf node.
If the node is not a leaf node with the value target, return the node itself.
Start the process from the root node and apply the function recursively.
📒 Complexity:
⏰ Time complexity: $$O(n)$$
Each node is visited exactly once.
🧺 Space complexity: $$O(n)$$
In the worst case, the depth of the recursion stack can be equal to the height of the tree,
which is proportional to the number of nodes for a binary tree.
 */
public class BinaryTreeDeleteLeaves {

  public TreeNode removeLeafNodes(TreeNode root, int target) {

    if (root.left != null) {
      root.left = removeLeafNodes(root.left, target);
    }
    if (root.right != null) {
      root.right = removeLeafNodes(root.right, target);
    }
    if (root.left == null && root.right == null && root.value == target) {
      return null;
    }
    return root;
  }
}
