package org.ferreiras.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]


Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
 */
public class CombinationSumTwo {

  public static void main(String[] args) {
    int[] candidates = {10,1,2,7,6,1,5};
    int target = 8;
    List<List<Integer>> lists = combinationSum2(candidates, target);

    for (List<Integer> list : lists) {
      System.out.println(list);
    }


  }

  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

    Arrays.sort(candidates);
    List<List<Integer>> response = new ArrayList<>();
    getSubsets(0, candidates, target, response, new ArrayList<>());

    return response;
  }
  static void getSubsets(
          int start, int[] candidates, int target,
          List<List<Integer>> response, List <Integer> current) {

    if (target == 0) {
      response.add(new ArrayList<>(current));
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      if (i > start && candidates[i] == candidates[i - 1])
        continue;
      if (candidates[i] > target)
        break;
      current.add(candidates[i]);
      getSubsets(i + 1, candidates, target - candidates[i], response, current);
      current.removeLast();
    }
  }


}
