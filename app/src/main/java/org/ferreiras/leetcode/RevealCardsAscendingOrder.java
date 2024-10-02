package org.ferreiras.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
You are given an integer array deck. There is a deck of cards where every card has a unique integer.
The integer on the ith card is deck[i].

You can order the deck in any order you want. Initially, all the cards start face down (unrevealed)
in one deck.

You will do the following steps repeatedly until all cards are revealed:

Take the top card of the deck, reveal it, and take it out of the deck.
If there are still cards in the deck then put the next top card of the deck at the bottom of the deck.
If there are still unrevealed cards, go back to step 1. Otherwise, stop.
Return an ordering of the deck that would reveal the cards in increasing order.

Note that the first entry in the answer is considered to be the top of the deck.

Example 1:

Input: deck = [17,13,11,2,3,5,7]
Output: [2,13,3,11,5,17,7]
Explanation:
We get the deck in the order [17,13,11,2,3,5,7] (this order does not matter), and reorder it.
After reordering, the deck starts as [2,13,3,11,5,17,7], where 2 is the top of the deck.
We reveal 2, and move 13 to the bottom.  The deck is now [3,11,5,17,7,13].
We reveal 3, and move 11 to the bottom.  The deck is now [5,17,7,13,11].
We reveal 5, and move 17 to the bottom.  The deck is now [7,13,11,17].
We reveal 7, and move 13 to the bottom.  The deck is now [11,17,13].
We reveal 11, and move 17 to the bottom.  The deck is now [13,17].
We reveal 13, and move 17 to the bottom.  The deck is now [17].
We reveal 17.
Since all the cards revealed are in increasing order, the answer is correct.
Example 2:

Input: deck = [1,1000]
Output: [1,1000]


Constraints:

1 <= deck.length <= 1000
1 <= deck[i] <= 106
All the values of deck are unique.
 */
public class RevealCardsAscendingOrder {
  public static void main(String[] args) {
    int[] deck = {17, 13, 11, 2, 3, 5, 7};
    int[] response = deckRevealedIncrease(deck);
    System.out.println(Arrays.toString(response));
  }

  public static int[] deckRevealedIncreasing(int[] deck) {

    Deque<Integer> queue = new ArrayDeque<>();
    for (int card : deck) {
      queue.offer(card);
    }
    int[] response = new int[deck.length];
    int index = 0;

    while (!queue.isEmpty()) {

      response[index] = queue.removeFirst();
      int j = queue.remove();
      queue.addLast(j);
      index++;

    }
    System.out.println(queue);
    return response;
  }

  public static int[] deckRevealedIncrease(int[] deck) {
    int size = deck.length;
//    Arrays.sort(deck);
    Deque<Integer> stack = new ArrayDeque<>();
    stack.addFirst(deck[size - 1]);
    for (int i = size - 2; i >= 0; i--) {
      stack.addFirst(stack.removeLast());
      stack.addFirst(deck[i]);
    }
    //
    // we can either create a new array or change the existing since
    // we don't need it right?? but it is not recommended

    for (int i = 0; i < size; i++) deck[i] = stack.removeFirst();
    return deck;
  }
}
