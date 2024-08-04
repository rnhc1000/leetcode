package org.ferreiras.leetCode;
/*
You are given an integer array nums of even length n and an integer limit. In one move,
you can replace any integer from nums with another integer between 1 and limit, inclusive.
The array nums is complementary if for all indices i (0-indexed), nums[i] + nums[n - 1 - i]
equals the same number.
For example, the array [1,2,3,4] is complementary because for all indices i,
nums[i] + nums[n - 1 - i] = 5.
Return the minimum number of moves required to make nums complementary.
 */
public class ComplimentaryArray {

  public static void main(String[] args) {
    int[] numbers = {1,2,1,2};
    int limit = 2;
    System.out.println(minMoves(numbers,limit));
  }
  public static int minMoves(int[] numbers, int limit) {
    int moves = 0;
    int stepAscending = 0, stepDescending = numbers.length - 1 - stepAscending;
    int sum = 0;
    int equalSum = numbers[stepAscending] + numbers[stepDescending];
    while (stepDescending > 0) {
        sum = numbers[stepAscending] + numbers[stepDescending];
        if (sum == equalSum) {
          stepDescending--;
          stepAscending++;
          continue;
        } else {

          moves++;
          numbers[stepDescending] = sum - limit;
        }
        stepDescending--;
        stepAscending++;
    }
    return moves;
  }
}
