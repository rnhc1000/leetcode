package org.ferreiras.leetcode;

import java.util.List;

import static org.ferreiras.leetcode.TreeNode.newNode;

/*
Smallest String Starting From Leaf
You are given the root of a binary tree where each node has a value in the range [0, 25]
representing the letters 'a' to 'z'.

Return the lexicographically smallest string that starts at a leaf of this tree and ends
at the root.

As a reminder, any shorter prefix of a string is lexicographically smaller.

For example, "ab" is lexicographically smaller than "aba".
A leaf of a node is a node that has no children.

Example 1:
Input: root = [0,1,2,3,4,3,4]
Output: "dba"

Example 2:
Input: root = [25,1,3,1,3,0,2]
Output: "adz"

Example 3:
Input: root = [2,2,1,null,1,0,null,0]
Output: "abc"


Constraints:

The number of nodes in the tree is in the range [1, 8500].
0 <= Node.val <= 25

We will use a recursive DFS traversal where:

At each node, we'll append the current node's character to a string.
If it's a leaf node (both children are null), we'll reverse the string (since we're building
from leaf to root) and compare it with the smallest string found so far.
Recursively continue the traversal for left and right children.

Here's why DFS is preferred for this task:

Depth-First Search (DFS):
DFS is suitable for problems where you need to explore as far as possible along each branch
before backtracking which perfectly aligns to our problem requirement.

Breadth-First Search (BFS):
BFS can also be used be solve this problem but with little more modifications to the traversal.
Because BFS is ideal for finding the shortest path in an unweighted graph or tree.
It explores all the neighboring nodes at the present depth before moving on to nodes at the
next depth level.

Approach✅:
We are given a binary tree where each node contains a lowercase letter ('a' to 'z').
Our goal is to find the lexicographically smallest string that starts from any leaf node and ends at the root.
We'll use a recursive DFS traversal to explore the tree.

Explanation of DFS Function (dfs()):
This function performs the depth-first search traversal.
node is the current node being processed.
path is the list that stores the current path of characters (from root to current node).
smallest is a list containing the smallest string found (using list to pass by reference).
Processing Inside dfs():
If node is None, we return immediately (base case for recursion).
Append the current node's character (derived from node.val) to the path.
If node is a leaf node (both node.left and node.right are None), construct the current string
by reversing path and compare it with the smallest string found so far (smallest[0]).
Recursively call dfs() for the left and right child nodes to continue the traversal.
Backtrack by removing the last character (current node's character) from path after exploring
a node.
Initializing and Calling smallestFromLeaf():
Initialize smallest with a large value ('z' + 1) to ensure it gets updated with the smallest
string found during traversal.
Call dfs() starting from the root of the binary tree with an empty path.
Return the smallest string (smallest[0]) after traversal completes.
Edge Cases:
Handle cases where the tree is empty (root is None).
Handle cases where the tree has a single node (the root is also a leaf).
 */
public class TreeSmallestString {

  static String smallestString = null;

  public static void main(String[] args) {
//    TreeNode root = newNode(0);
//    root.left = newNode(1);
//    root.right = newNode(2);
//    root.left.left = newNode(3);
//    root.left.right = newNode(4);
//    root.right.left = newNode(3);
//    root.right.right = newNode(4);
    TreeNode root = newNode(25);
    root.left = newNode(1);
    root.right = newNode(3);
    root.left.left = newNode(1);
    root.left.right = newNode(3);
    root.right.left = newNode(0);
    root.right.right = newNode(2);

    //25,1,3,1,3,0,2

    String response = smallestFromLeaf(root);
    System.out.println(response);
    List<Integer> list = root.dfsPreOrder(root);
    System.out.println(list);
  }

  public static String smallestFromLeaf(TreeNode root) {
    dfs(root, new StringBuilder());
    return smallestString;
  }

  public static void dfs(TreeNode node, StringBuilder currentString) {
    if (node == null) {
      return;
    }

    currentString.insert(0, (char) ('a' + node.value));

    if (node.left == null && node.right == null) {
      if (smallestString == null || currentString.toString().compareTo(smallestString) < 0) {
        smallestString = currentString.toString();
      }
    } else {

      dfs(node.left, currentString);
      dfs(node.right, currentString);

    }

    currentString.deleteCharAt(0);
  }
}
