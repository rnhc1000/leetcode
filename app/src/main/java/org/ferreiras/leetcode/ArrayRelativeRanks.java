package org.ferreiras.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
You are given an integer array score of size n, where score[i] is the score of the ith athlete
in a competition. All the scores are guaranteed to be unique.

The athletes are placed based on their scores, where the 1st place athlete has the highest score,
the 2nd place athlete has the 2nd highest score, and so on.
The placement of each athlete determines their rank:

The 1st place athlete's rank is "Gold Medal".
The 2nd place athlete's rank is "Silver Medal".
The 3rd place athlete's rank is "Bronze Medal".

For the 4th place to the nth place athlete, their rank is their placement number
(i.e., the xth place athlete's rank is "x").
Return an array answer of size n where answer[i] is the rank of the ith athlete.

Example 1:

Input: score = [5,4,3,2,1]
Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
Example 2:

Input: score = [10,3,8,9,4]
Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].

Constraints:

n == score.length
1 <= n <= 104
0 <= score[i] <= 106
All the values in score are unique.
 */
public class ArrayRelativeRanks {
  public static void main(String[] args) {
    int[] score = {10,3,8,9,4};
    String[] response = findRelativeRanks(score);
    for (String s : response) {
      System.out.printf("%s, ", s);
    }
  }

  public static String[] findRelativeRanks(int[] score) {
    Integer[] sortedScore = Arrays.stream(score)
            .boxed()
            .sorted(Collections.reverseOrder()).toArray(Integer[]::new);
    System.out.println(Arrays.toString(sortedScore));
    Arrays.sort(score);
    System.out.println(Arrays.toString(score));
    int[] sortedScores = new int[score.length];
    int j = 0;
    for (int i=score.length-1; i>= 0; i--) {
      sortedScores[j] = score[i];
      j++;
    }

    System.out.println(Arrays.toString(sortedScores));



    String[] medals = {"Gold Medal", "Silver Medal", "Bronze Medal"};
    Map<Integer, String> map = new HashMap<>();
    for (int i = 0; i < sortedScore.length; i++) {
      if (i < 3) {
        map.put(sortedScore[i], medals[i]);
      } else {
        map.put(sortedScore[i], String.valueOf(i + 1));
      }
    }
    System.out.println(map);

    String[] result = new String[score.length];
    for (int i = 0; i < score.length; i++) {
      result[i] = map.get(score[i]);
    }
    return result;
  }
}