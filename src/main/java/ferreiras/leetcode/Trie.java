package ferreiras.leetcode;

/**
 * Trie is a tree-like data structure that efficiently stores and retrieves a dynamic
 * set of strings.
 * It supports three main operations: insertion of a word, searching for a word, and
 * checking if a given prefix exists.
 * Approach:
 * - The Trie class is implemented with a Node inner class, representing characters in
 * the Trie.
 * - Each node has an array of child nodes, character value, and a flag indicating the
 * end of a word.
 * - The Trie starts with a root node, and characters are added in a way that each path
 * from the root to a node
 *   represents a valid word in the Trie.
 * - The insert method traverses the Trie, creating nodes as needed, and marks the last
 * node as the end of a word.
 * - The search method checks if a given word exists in the Trie by traversing the nodes.
 * - The startsWith method checks if there is any word with a given prefix in the Trie.
 * Usage:
 * - Trie obj = new Trie();
 * - obj.insert(word): Inserts a word into the Trie.
 * - boolean param_2 = obj.search(word): Searches for a word in the Trie.
 * - boolean param_3 = obj.startsWith(prefix): Checks if any word starts with a given prefix.
 */
public class Trie {

  static class Node {
    Node[] children = new Node[26];
    char value;
    boolean endOfWord = false;
  }

  Node root;
  public Trie() {
    root = new Node();
  }

  public void insert(String word) {
    Node currentNode = root;
    for (char c : word.toCharArray()) {
      if (currentNode.children[c - 'a'] == null) {
        Node child = new Node();
        child.value = c;
        currentNode.children[c - 'a'] = child;
      }
      currentNode = currentNode.children[c - 'a'];
    }
    currentNode.endOfWord = true;
  }

  public boolean search(String word) {
    Node currentNode = root;
    for (char c : word.toCharArray()) {
      if (currentNode.children[c - 'a'] == null) {
        return false;
      }
      currentNode = currentNode.children[c - 'a'];
    }
    return currentNode.endOfWord;
  }

  public boolean startsWith(String prefix) {
    Node currentNode = root;
    for (char c : prefix.toCharArray()) {
      if (currentNode.children[c - 'a'] == null) {
        return false;
      }
      currentNode = currentNode.children[c - 'a'];
    }
    return true;
  }
}
