package org.ferreiras.leetcode;

/**
 * You are given an integer array nums of size n and a positive integer k.
 * Divide the array into one or more arrays of size 3 satisfying the following conditions:
 * Each element of nums should be in exactly one array.
 * The difference between any two elements in one array is less than or equal to k.
 * Return a 2D array containing all the arrays. If it is impossible to satisfy the conditions, return an empty array. And if there are multiple answers, return any of them.
 * Example 1:
 * Input: nums = [1,3,4,8,7,9,3,5,1], k = 2
 * Output: [[1,1,3],[3,4,5],[7,8,9]]
 * Explanation: We can divide the array into the following arrays:
 * [1,1,3], [3,4,5] and [7,8,9].
 * The difference between any two elements in each array is less than or equal to 2.
 * Note that the order of elements is not important.
 * Example 2:
 * <p>
 * Input: nums = [1,3,3,2,7,3], k = 3
 * Output: []
 * Explanation: It is not possible to divide the array satisfying all the conditions.
 */

import java.util.Arrays;

public class DivideArrayIntoArrays {
  public static void main(String[] args) {
    int[] nums = {15, 13, 12, 13, 12, 14, 12, 2, 3, 13, 12, 14, 14, 13, 5, 12, 12, 2, 13, 2, 2};
    int k = 3;
    int[][] response = divideArray(nums, k);
    for (int[] a : response) {
      System.out.println(Arrays.toString(a));
    }
  }

  public static int[][] divideArray(int[] nums, int k) {
    int size = nums.length;
    if (size % 3 != 0) return new int[][]{};
    Arrays.sort(nums);
    int num = size / 3;
    int[][] response = new int[num][3];
    int count = 0;
    int left = 0;
    int jump = 3;
    int i = 0;
    while (size > 0) {
      int[] aux = new int[3];
      for (int right = left; right < jump; right++) {
        aux[i] = nums[right];
        i++;
      }
      i = 0;
      left = jump;
      jump += 3;
      response[count] = aux;
      count++;
      size -= 3;
    }
    int check = 3;
    for (int[] r : response) {
      int x = 0;
      int y = 1;
      check = 3;
      while (check > 1) {
        if (r[y] - r[x] > k) {
          return new int[][]{};
        }
        check--;
        y++;
        x++;
      }
    }
    return response;
  }

  public static int[][] dividerArray(int[] nums, int k) {
    int size = nums.length;
    int dimensionOne = size/3;
    int[][] twoDimension = new int[dimensionOne][3];
    int index = 0;
    Arrays.sort(nums);
    for (int i = 0; i < size; i += 3) {
      int zero = nums[i];
      int one = nums[i + 1];
      int second = nums[i + 2];
      if (second - zero <= k) {
        twoDimension[index][0] = zero;
        twoDimension[index][1] = one;
        twoDimension[index][2] = second;
        index++;
      } else {
        return new int[][]{};
      }
    }
    return twoDimension;
  }
}
