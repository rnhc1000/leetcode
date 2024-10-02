package org.ferreiras.leetcode;
/*
You are given the root of a binary tree with n nodes.
Each node is uniquely assigned a valueue from 1 to n. You are also given an integer startValue
representing the value of the start node s, and a different integer destValue representing
the value of the destination node t.



import java.util.*;Find the shortest path starting from node s and ending at node t.
         Generate step-by-step directions of such path as a string consisting of
        only the uppercase letters 'L', 'R', and 'U'.
        Each letter indicates a specific direction:

'L' means to go from a node to its left child node.
'R' means to go from a node to its right child node.
'U' means to go from a node to its parent node.
Return the step-by-step directions of the shortest path from node s to node t.



Example 1:


Input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
Output: "UURL"
Explanation: The shortest path is: 3 → 1 → 5 → 2 → 6.
Example 2:


Input: root = [2,1], startValue = 2, destValue = 1
Output: "L"
Explanation: The shortest path is: 2 → 1.


Constraints:

The number of nodes in the tree is n.
2 <= n <= 105
1 <= Node.val <= n
All the values in the tree are unique.
1 <= startValue, destValue <= n
startValue != destValue
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//import br.dev.ferreiras.challenges.dataStructures.Pair;

import java.util.*;

public class TreeNodeDirections {


  public String getDirections(TreeNode root, int startValue, int destValue) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    TreeNode startNode = null;

    while (!queue.isEmpty()) {
      TreeNode currentNode = queue.poll();

      if (currentNode.value == startValue) {
        startNode = currentNode;
        break;
      }

      if (currentNode.left != null) {
        queue.offer(currentNode.left);
      }
      if (currentNode.right != null) {
        queue.offer(currentNode.right);
      }
    }

    Map<Integer, TreeNode> nodesParents = new HashMap<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      TreeNode currentNode = queue.poll();

      if (currentNode.left != null) {
        nodesParents.put(currentNode.left.value, currentNode);
        queue.offer(currentNode.left);
      }
      if (currentNode.right != null) {
        nodesParents.put(currentNode.right.value, currentNode);
        queue.offer(currentNode.right);
      }
    }

    Set<TreeNode> visited = new HashSet<>();
    queue.offer(startNode);
    Map<TreeNode, Pai> trackedPath = new HashMap<>();
    TreeNode destinationNode = null;

    while (!queue.isEmpty()) {
      TreeNode currentNode = queue.poll();
      visited.add(currentNode);

      if (currentNode.value == destValue) {
        destinationNode = currentNode;
        break;
      }

      if (nodesParents.containsKey(currentNode.value) && !visited.contains(nodesParents.get(currentNode.value))) {
        TreeNode parent = nodesParents.get(currentNode.value);
        queue.offer(parent);
        trackedPath.put(parent, new Pai(currentNode, "U"));
      }

      if (currentNode.left != null && !visited.contains(currentNode.left)) {
        queue.offer(currentNode.left);
        trackedPath.put(currentNode.left, new Pai(currentNode, "L"));
      }

      if (currentNode.right != null && !visited.contains(currentNode.right)) {
        queue.offer(currentNode.right);
        trackedPath.put(currentNode.right, new Pai(currentNode, "R"));
      }
    }

    List<String> resultPath = new ArrayList<>();
    TreeNode currentNode = destinationNode;

    while (currentNode != startNode) {
      Pai sourceAndDirection = trackedPath.get(currentNode);
//      resultPath.add(sourceAndDirection.getValue());
//      currentNode = sourceAndDirection.getKey();
    }

    Collections.reverse(resultPath);
    return String.join("", resultPath);
  }
  static class Pai {

    TreeNode node;
    String string;

    public Pai(TreeNode node, String string) {
      this.node = node;
      this.string = string;

    }
  }
  }
