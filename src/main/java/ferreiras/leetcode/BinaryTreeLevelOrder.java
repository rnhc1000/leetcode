package ferreiras.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the level order traversal
 * of its nodes' values. (i.e., from left to right, level by level).
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 * Input: root = []
 * Output: []
 * Cool explanation by
 * <a href="https://leetcode.com/sakshamkaushiik/">...</a>
 * Approach
 * This is a Java solution for the problem of traversing a binary tree level
 * by level and returning the values of each level in a list of lists of integers.
 * The solution uses a Queue to traverse the tree in a level-by-level fashion.
 * The outer list of the resulting list of lists is represented as an ArrayList
 * in this solution, while the inner lists are also represented as ArrayLists.
 * Here is a step-by-step explanation of the code:
 * Declare a Queue named q that will be used for level-by-level traversal of the
 * binary tree.
 * Declare a List of Lists of Integers named finalAns to store the final result.
 * Check if the root of the binary tree is null. If it is, return the empty list of lists.
 * Add the root node of the binary tree to the queue.
 * While the queue is not empty, perform the following steps for each level of the tree:
 * Get the size of the current level of the queue.
 * Create a new list to store the values of the current level.
 * For each node in the current level of the queue, add its left and right children
 * (if they exist) to the end of the queue and add its value to the list of values
 * for the current level.
 * Add the list of values for the current level to the final result list.
 * Return the final result list of lists of values for each level of the binary tree.
 * Complexity
 * Time complexity:
 * The time complexity of this solution is O(n), where n is the number of nodes in the
 * binary tree. This is because we visit each node in the tree exactly once, and the
 * time taken to process each node is constant time.
 * Space complexity:
 * The space complexity of this solution is O(n), where n is the number of nodes in the
 * binary tree. This is because in the worst case, the queue can store all the nodes of
 * the last level of the binary tree, which is approximately half of the total number of
 * nodes in the tree. Additionally, the space required for the output list of lists is
 * also proportional to the number of nodes in the tree.
 * Therefore, the overall time and space complexity of this solution are both O(n).
 * Note
 * The difference between using LinkedList and ArrayList for the outer list in this code
 * is related to their internal data structures and their performance characteristics.
 * LinkedList is implemented as a doubly linked list, where each node has a reference
 * to its previous and next nodes. This makes it efficient to add or remove elements
 * from the beginning or end of the list, but less efficient to access elements at
 * arbitrary positions in the list. Therefore, using LinkedList for the outer list
 * would be more efficient if we frequently add or remove elements from the beginning
 * or end of the list.
 * List<List<Integer>> finalAns = new LinkedList<List<Integer>>();
 * On the other hand, ArrayList is implemented as a dynamic array, where elements
 * are stored in a contiguous block of memory. This makes it efficient to access
 * elements at arbitrary positions in the list, but less efficient to add or remove
 * elements from the beginning or end of the list. Therefore, using ArrayList for
 * the outer list would be more efficient if we frequently access elements at
 * arbitrary positions in the list.
 * List<List<Integer>> finalAns = new ArrayList<List<Integer>>();
 * In the case of the provided code, since we only add elements to the end of the
 * outer list and do not access elements at arbitrary positions, using either
 * LinkedList or ArrayList for the outer list should produce the same results in
 * terms of correctness. However, using ArrayList may be more efficient in terms
 * of memory usage and performance, especially for larger input trees, because
 * it avoids the overhead of maintaining the linked list structure.
 */
public class BinaryTreeLevelOrder {
  public static void main(String[] args) {
    TreeNode node = new TreeNode();
    node.insert(3);
    node.insert(9);
    node.insert(20);
    node.insert(15);
    node.insert(7);
    List<List<Integer>> list = levelOrder(node);
    for (List<Integer> l : list) {
      System.out.print(" " + l);
    }
  }
  public static List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> response = new ArrayList<>();
    if (root == null)
      return response;
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        try {
          if (queue.peek().left != null) {
            queue.add(queue.peek().left);
          }
          if (queue.peek().right != null) {
            queue.add(queue.peek().right);
          }
        } catch (NullPointerException np) {
          System.out.println(np.getMessage());
        }
        list.add(queue.remove().value);
      }
      response.add(list);
    }
    return response;

  }
}
