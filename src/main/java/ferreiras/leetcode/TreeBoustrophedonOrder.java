package ferreiras.leetcode;

import java.util.*;

import static ferreiras.leetcode.TreeNode.newNode;

/*
In Ancient Greece, it was common to write text with the first line going left to right,
the second line going right to left, and continuing to go back and forth.
This style was called "boustrophedon".

Given a binary tree, write an algorithm to print the nodes in boustrophedon order.

For example, given the following tree:

       1
    /     \
  2         3
 / \       / \
4   5     6   7
You should return [1, 3, 2, 4, 5, 6, 7].
 */
public class TreeBoustrophedonOrder {
  public static void main(String[] args) {
//    TreeNode root = newNode(0);
//    root.left = newNode(1);
//    root.right = newNode(2);
//    root.left.left = newNode(3);
//    root.left.right = newNode(4);
//    root.right.left = newNode(3);
//    root.right.right = newNode(4);
    TreeNode root = newNode(0);
//    root.left = newNode(1);
//    root.right = newNode(2);
//    root.left.left = newNode(3);
//    root.left.right = newNode(4);
//    root.right.left = newNode(5);
//    root.right.right = newNode(6);
    Deque<Integer> response = boustrophedOrder(root);
    System.out.println("ZigZag");
    System.out.println(response);
    List<List<Integer>> list = boustrophenOrder(root);
//    for (List<Integer> l: list) {
//      System.out.println("List of Lists");
//      System.out.println(l);
//    }

    System.out.println(list);
  }

  public static List<Integer> list = new ArrayList<>();

  public static Deque<Integer> boustrophedOrder(TreeNode root) {
    if (root == null) return null;

    TreeNode currentNode = root;

//    list.add(currentNode.value);
    Deque <TreeNode> queue = new LinkedList<>();
    Deque <Integer>  stack = new ArrayDeque<>();
    queue.add(root);
    stack.add(root.value);
    int level = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        if (level % 2 == 0) {
          currentNode = queue.pollLast();
        } else {
          currentNode = queue.peekFirst();
          queue.pollFirst();
        }
        if (level % 2 != 0) {
          if ((currentNode != null ? currentNode.right : null) != null) {
            queue.add(currentNode.right);
            stack.add(currentNode.right.value);
          }
          if ((currentNode != null ? currentNode.left : null) != null) {
            queue.add(currentNode.left);
            stack.add(currentNode.left.value);
          }
        } else  {
          if ((currentNode != null ? currentNode.left : null) != null) {
            queue.offerFirst(currentNode.left);
            stack.add(currentNode.left.value);
          }
          if ((currentNode != null ? currentNode.right : null) != null) {
            queue.offerFirst(currentNode.right);
            stack.add(currentNode.right.value);
          }
        }
      }
      level += 1;
    }

    return stack;
  }
  public static List<List<Integer>> boustrophenOrder(TreeNode root) {

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    if (root == null) return null;
    if (root.right == null && root.left == null) {
//      list.add(root.value);
//      lists.add(list);
//      return lists;
      return new ArrayList<>(new ArrayList<>(root.value));
    }

    TreeNode currentNode = root;

//    list.add(currentNode.value);
    Deque <TreeNode> queue = new LinkedList<>();
    queue.add(root);
    list.add(root.value);
    lists.add(list);
    list.clear();
    int level = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        if (level % 2 == 0) {
          currentNode = queue.pollLast();
        } else {
          currentNode = queue.peekFirst();
          queue.pollFirst();
        }
        if (level % 2 != 0) {
          if ((currentNode != null ? currentNode.right : null) != null) {
            queue.add(currentNode.right);
            list.add(currentNode.right.value);
          }
          if ((currentNode != null ? currentNode.left : null) != null) {
            queue.add(currentNode.left);
            list.add(currentNode.left.value);
          }
        } else  {
          if ((currentNode != null ? currentNode.left : null) != null) {
            queue.offerFirst(currentNode.left);
            list.add(currentNode.left.value);
          }
          if ((currentNode != null ? currentNode.right : null) != null) {
            queue.offerFirst(currentNode.right);
            list.add(currentNode.right.value);
          }
        }
      }
      level += 1;
      lists.add(list);
      list.clear();
    }

    return lists;
  }
}
