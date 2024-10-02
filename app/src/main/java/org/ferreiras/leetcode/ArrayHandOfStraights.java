package org.ferreiras.leetcode;

import java.util.*;

/*
Alice has some number of cards and she wants to rearrange the cards into groups
so that each group is of size groupSize, and consists of groupSize consecutive cards.

Given an integer array hand where hand[i] is the value written on the ith card and
an integer groupSize, return true if she can rearrange the cards, or false otherwise.

Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
Example 2:

Input: hand = [1,2,3,4,5], groupSize = 4
Output: false
Explanation: Alice's hand can not be rearranged into groups of 4.

 */
public class ArrayHandOfStraights {

  public static void main(String[] args) {
    int[] hand = {2,1};
    int groupSize = 2;
    long start = System.nanoTime();
    boolean response = isNStraightHand(hand,groupSize);
    System.out.println(response);
    long end = System.nanoTime();
    System.out.println("Time: " + (end - start) / 1_000_000 + " ms");
  }
  public static boolean isNStraightHand(int[] hand, int groupSize) {
    if (hand.length % groupSize != 0) {
      return false;
    }
    Map<Integer, Integer> cardCount = new TreeMap<>();
    for (int card : hand) {
      cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
    }

    System.out.println(cardCount.keySet());

    for (int card : cardCount.keySet()) {
      int count = cardCount.get(card);
      if (count > 0) {
        for (int i = 0; i < groupSize; ++i) {
          if (cardCount.getOrDefault(card + i, 0) < count) {
            return false;
          }
          cardCount.put(card + i, cardCount.get(card + i) - count);
        }
      }
    }
    return true;
  }
  public boolean isStraightHand(int[] hand, int groupSize) {
    // Step 1: Check if grouping is possible
    if (hand.length % groupSize != 0) {
      return false;
    }

    // Step 2: Count the occurrences of each card
    Map<Integer, Integer> count = new HashMap<>();
    for (int card : hand) {
      count.put(card, count.getOrDefault(card, 0) + 1);
    }

    // Step 3: Sort the unique card values
    int[] sortedKeys = new int[count.size()];
    int index = 0;
    for (int key : count.keySet()) {
      sortedKeys[index++] = key;
    }
    Arrays.sort(sortedKeys);

    // Step 4: Form consecutive groups
    for (int key : sortedKeys) {
      if (count.get(key) > 0) {  // If this card is still available
        int startCount = count.get(key);
        // Check and form a group starting from `key`
        for (int i = key; i < key + groupSize; i++) {
          if (count.getOrDefault(i, 0) < startCount) {
            return false;
          }
          count.put(i, count.get(i) - startCount);
        }
      }
    }

    // Step 5: Return true if all groups are formed successfully
    return true;
  }
}
