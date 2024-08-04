package org.ferreiras.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all valid combinations of k numbers that sum up to n such
 * that the following conditions are true:
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
 * Example 1:
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Explanation:
 * 1 + 2 + 4 = 7
 * There are no other valid combinations.
 * Example 2:
 * Input: k = 3, n = 9
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * Explanation:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * There are no other valid combinations.
 * Example 3:
 * <p>
 * Input: k = 4, n = 1
 * Output: []
 * Explanation: There are no valid combinations.
 * Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10
 * and since 10 > 1, there are no valid combination.
 * Backtracking is an algorithmic technique for solving problems recursively by trying to build
 * a solution incrementally, one piece at a time, removing those solutions that fail to satisfy
 * the constraints of the problem at any point of time (by time, here, is referred to the time
 * elapsed till reaching any level of the search tree).
 * There are three types of problems in backtracking
 *
 * Decision Problem: In this, we search for a feasible solution.
 * Optimization Problem: In this, we search for the best solution.
 * Enumeration Problem: In this, we find all feasible solutions.
 */
public class CombinationSum {

  public static void main(String[] args) {
    int k = 3;
    int n = 9;

    List<List<Integer>> response = CombinationSum.combinationSum3(k,n);
    for(List<Integer> r : response) {
      System.out.println(r);
    }
  }
  public static List<List<Integer>> combinationSum3(int k, int n) {

    // create a list to store all subsets that satisfy the conditions
    List<List<Integer>> subset = new ArrayList<>();

    // create an array list to store the current subset
    ArrayList<Integer> current = new ArrayList<>();

    // generate the subsets
    generateSubset(1, 9, current, subset, k, n);

    // return the list of subsets
    return subset;
  }

  // helper method to generate the subsets
  public static void generateSubset(int start, int end, ArrayList<Integer> current, List<List<Integer>> subset, int k, int target) {

    // if target is reached and the size of current subset is k, add current subset to the list of subsets
    if (target == 0 && current.size() == k) {
      subset.add(new ArrayList<>(current));
    }

    // recursively generate subsets by trying all possible numbers from start to end
    for (int i = start; i <= end; i++) {
      current.add(i);

      // recursively call generateSubset with updated current subset and target
      generateSubset(i + 1, end, current, subset, k, target - i);

      // remove the last element from current subset before trying the next number
      current.remove(current.size() - 1);
    }
  }
}

