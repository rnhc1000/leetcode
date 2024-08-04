package org.ferreiras.leetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
There are n pieces arranged in a line, and each piece is colored either by 'A' or by 'B'.
You are given a string colors of length n where colors[i] is the color of the ith piece.

Alice and Bob are playing a game where they take alternating turns removing pieces from the line.
In this game, Alice moves first.

Alice is only allowed to remove a piece colored 'A' if both its neighbors are also colored 'A'.
She is not allowed to remove pieces that are colored 'B'.
Bob is only allowed to remove a piece colored 'B' if both its neighbors are also colored 'B'.
He is not allowed to remove pieces that are colored 'A'.
Alice and Bob cannot remove pieces from the edge of the line.
If a player cannot make a move on their turn, that player loses and the other player wins.
Assuming Alice and Bob play optimally, return true if Alice wins, or return false if Bob wins.

Example 1:

Input: colors = "AAABABB"
Output: true
Explanation:
AAABABB -> AABABB
Alice moves first.
She removes the second 'A' from the left since that is the only 'A' whose neighbors are both 'A'.

Now it's Bob's turn.
Bob cannot make a move on his turn since there are no 'B's whose neighbors are both 'B'.
Thus, Alice wins, so return true.
Example 2:

Input: colors = "AA"
Output: false
Explanation:
Alice has her turn first.
There are only two 'A's and both are on the edge of the line, so she cannot move on her turn.
Thus, Bob wins, so return false.
Example 3:

Input: colors = "ABBBBBBBAAA"
Output: false
Explanation:
ABBBBBBBAAA -> ABBBBBBBAA
Alice moves first.
Her only option is to remove the second to last 'A' from the right.

ABBBBBBBAA -> ABBBBBBAA
Next is Bob's turn.
He has many options for which 'B' piece to remove. He can pick any.

On Alice's second turn, she has no more pieces that she can remove.
Thus, Bob wins, so return false.


Constraints:

1 <= colors.length <= 105
colors consists of only the letters 'A' and 'B'
Approach by https://leetcode.com/NinjaFire
The code uses a while loop to iterate over the characters of the colors string.
Within this loop, there is another while loop that starts at the current position i
and continues until it encounters a different color.
This inner loop helps in finding consecutive sequences of the same color.

Inside the inner loop, it calculates the length of the consecutive sequence (turn).
If this length is greater than or equal to 3, it subtracts 2 from it (as per the game rules),
otherwise, it sets turn to 0.

The code then updates the score of player A or player B based on the current color and the
calculated turn value.

Finally, after processing the entire string, it checks whether the score of player A (a)
is greater than player B (b) and returns the result.

Complexity
Time complexity:
O(n)

Space complexity:
O(1)
 */
public class StringRemoveColors {
  public static void main(String[] args) {
    String colors = "ABBBBBBBAAA";
    boolean response = winnerOfGame(colors);
    System.out.println(response);
  }

  public static boolean winnerOfGames(String colors) {

    String alice, bob = "";
    boolean response = false;
    Deque<Character> queue = new LinkedList<>();

    for (char ch : colors.toCharArray()) {
      queue.add(ch);
    }

    System.out.println(queue.getFirst());
    System.out.println(queue.getLast());
    StringBuilder sb = new StringBuilder(colors);
    for (int i = 1; i < sb.length() - 1; i++) {
      if (sb.charAt(i) == sb.charAt(i - 1) && sb.charAt(i) == sb.charAt(i + 1)) {
        sb.deleteCharAt(i);
        response = true;
      } else {
        response = false;
      }
    }


    return response;
  }

  public static boolean winnerOfGame(String board) {

    int left = 0, right = board.length(), aux = 0, alice = 0, bob = 0;

    while (left < right) {
      aux = left;
      while (aux < right && board.charAt(aux) == board.charAt(left)) aux++;
      int turn = (aux - left) >= 3 ? (aux - left) - 2 : 0;
      if (board.charAt(left) == 'A') {
        alice+=turn;
      } else {
        bob += turn;
      }
      left = aux;
    }
      return alice > bob;
  }
}
