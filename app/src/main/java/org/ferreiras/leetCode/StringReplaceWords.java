package org.ferreiras.leetCode;

import java.util.*;

/*
In English, we have a concept called root, which can be followed by some other word to form another
longer word - let's call this word derivative.
For example, when the root "help" is followed by the word "ful", we can form a derivative "helpful".

Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces,
replace all the derivatives in the sentence with the root forming it. If a derivative can be replaced by more than one root, replace it with the root that has the shortest length.

Return the sentence after the replacement.

Example 1:

Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
Example 2:

Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
Output: "a a b c"


Constraints:

1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 100
dictionary[i] consists of only lower-case letters.
1 <= sentence.length <= 106
sentence consists of only lower-case letters and spaces.
The number of words in sentence is in the range [1, 1000]
The length of each word in sentence is in the range [1, 1000]
Every two consecutive words in sentence will be separated by exactly one space.
sentence does not have leading or trailing space

Intuition - https://leetcode.com/initishjha
The problem asks us to replace words in a sentence with their shortest root from a given
dictionary. We can leverage a trie data structure to efficiently search for these roots.
A trie is a tree where each node represents a character in a word.
By traversing the trie, we can check if a prefix of the word exists as a root in the dictionary.

Approach
Trie Construction:
Build a trie from the dictionary words.
Each node in the trie will have an array of child nodes (one for each lowercase letter)
and a boolean flag indicating if it's a complete word.
Sentence Processing:
Split the sentence into individual words.
Iterate through each word:
Traverse the trie for that word, checking if any prefix is marked as a root.
If a root is found, replace the word with that root (prioritize the shortest root in case of ambiguity).
If no root is found, keep the original word.
Result Formation:
Build the final sentence by joining the processed words with spaces.
Remove any trailing whitespace using trim().
 */
public class StringReplaceWords {
  static class Trie {
    private static class Node {
      Node[] nodes;
      boolean isWord;

      Node() {
        nodes = new Node[26];
      }
    }

    private final Node root;

    Trie() {
      root = new Node();
    }

    void add(String word) {
      Node currentNode = root;
      for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        int index = ch - 'a';
        if (currentNode.nodes[index] != null) {
          currentNode = currentNode.nodes[index];
        } else {
          currentNode.nodes[index] = new Node();
          currentNode = currentNode.nodes[index];
        }
      }
      currentNode.isWord = true;
    }

    String getRoot(String word) {
      Node currentNode = root;
      int i = 0;
      for (; i < word.length(); i++) {

        if (currentNode.isWord) {
          break;
        }
        char ch = word.charAt(i);
        int index = ch - 'a';

        if (currentNode.nodes[index] != null) {
          currentNode = currentNode.nodes[index];
        } else {
          return "";
        }
      }
      return word.substring(0, i);
    }
  }

  public static void main(String[] args) {
    List<String> dictionary = List.of("cat", "bat", "rat");
    String sentence = "the cattle was rattled by the battery";
    String response = replaceWord(dictionary, sentence);
    System.out.println("Sentence: " + response);
  }

  public static String replaceWord(List<String> dictionary, String sentence) {
    Trie trie = new Trie();
    for (String s : dictionary) {
      trie.add(s);
    }
    String regex = "\\s+";
    String[] words = sentence.split(regex);
    StringBuilder result = new StringBuilder(sentence.length() + 1);

    for (String word : words) {

      String root = trie.getRoot(word);
      if (root.isEmpty()) {
        result.append(word);
        result.append(" ");

      } else {
        result.append(root);
        result.append(" ");
      }
    }
    return result.toString().trim();
  }
}
