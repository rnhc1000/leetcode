package org.ferreiras.leetcode;

import java.util.*;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 * <p>
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 */
public class SortedSquare {
  public static void main(String[] args) {
    int[] numbers = {-7,-3,2,3,11};
    sortedSquares(numbers);
  }

  public static void sortedSquares(int[] nums) {

    List<Integer> list = new ArrayList<>();
    for (int num : nums) {
      list.add(num * num);
    }
    Arrays.sort(nums);
    int[] resp = new int[list.size()];
    List<Integer> sorted = list.stream().sorted().toList();
     for (int i = 0; i < list.size(); i++) {
       resp[i] = sorted.get(i);//   List<Integer> list = set.stream().toList(); = num
     }
    System.out.println(Arrays.toString(resp));
  }
}
