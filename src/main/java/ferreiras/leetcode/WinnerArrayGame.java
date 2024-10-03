package ferreiras.leetcode;

/*
Given an integer array arr of distinct integers and an integer k.

A game will be played between the first two elements of the array (i.e. arr[0] and arr[1]).
In each round of the game, we compare arr[0] with arr[1], the larger integer wins and remains
at position 0, and the smaller integer moves to the end of the array.
The game ends when an integer wins k consecutive rounds.

Return the integer which will win the game.

It is guaranteed that there will be a winner of the game.

Example 1:

Input: arr = [2,1,3,5,4,6,7], k = 2
Output: 5
Explanation:
Let's see the rounds of the game:
Round |       arr       | winner | win_count
  1   | [2,1,3,5,4,6,7] | 2      | 1
  2   | [2,3,5,4,6,7,1] | 3      | 1
  3   | [3,5,4,6,7,1,2] | 5      | 1
  4   | [5,4,6,7,1,2,3] | 5      | 2
So we can see that 4 rounds will be played and 5 is the winner because it wins 2 consecutive games.
Example 2:

Input: arr = [3,2,1], k = 10
Output: 3
Explanation:
3 will win the first 10 rounds consecutively.


Constraints:

2 <= arr.length <= 105
1 <= arr[i] <= 106
arr contains distinct integers.
1 <= k <= 109
 */
public class WinnerArrayGame {

  public static void main(String[] args) {
    int[] nums = {2, 1, 3, 5, 4, 6, 7};
    int k = 2;
    int r = getWinner(nums, k);
    System.out.println(r);
  }

  public static int getWinner(int[] arr, int k) {
    int count = 0, winner = Integer.MIN_VALUE;
    int[] temp = new int[2];


    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > arr[i - 1]) {
        winner = Math.max(winner, arr[i]);
      }
    }
    if (k >= arr.length) {
      return winner;
    }
    System.out.println(winner);
    int right = arr.length - 1;
    int currentWinner = arr[0];
    int streak = 0;
    for (int i = 1; i < right; i++) {

      if (currentWinner > arr[i]) {
        streak++;
      } else {
        streak = 1;
        currentWinner = arr[i];
      }
      if (streak == k || currentWinner == winner) {
        return currentWinner;
      }
    }
    return currentWinner;
  }

  public static int[] currentWinner(int[] arr, int j, int k) {

    int[] currentWinnerPair = new int[2];

    currentWinnerPair[0] = arr[1];
    currentWinnerPair[1] = arr[0];

    return currentWinnerPair;
  }
}
