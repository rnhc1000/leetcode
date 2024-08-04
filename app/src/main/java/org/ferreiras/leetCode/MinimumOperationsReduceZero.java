package org.ferreiras.leetCode;

import java.util.Arrays;

/**
 * You are given an integer array nums and an integer x. In one operation,
 * you can either remove the leftmost or the rightmost element from the array
 * nums and subtract its value from x.
 * Note that this modifies the array for future operations.
 * Return the minimum number of operations to reduce x to exactly 0 if it is possible,
 * otherwise, return -1.
 * Example 1:
 * Input: nums = [1,1,4,2,3], x = 5
 * Output: 2
 * Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
 * Example 2:
 * Input: nums = [5,6,7,8,9], x = 4
 * Output: -1
 * Example 3:
 * <p>
 * Input: nums = [3,2,20,1,1,3], x = 10
 * Output: 5
 * Explanation: The optimal solution is to remove the last three elements and the first two
 * elements (5 operations in total) to reduce x to zero.
 */
public class MinimumOperationsReduceZero {
  public static void main(String[] args) {
    int[] numbers = {1, 1, 4, 2, 3};
    int k = 5;
    int response = minOperations(numbers, k);
  }

  public static int minOperations(int[] nums, int x) {
    int sum = nums[0];
    int count = 0;
    Arrays.sort(nums);

      for (int i = 1; i < nums.length; i++) {

        sum = nums[i] + nums[i - 1];
        count++;
        if (sum == x) {
          break;
        }else if (count >= nums.length) {
          return -1;
        }
      }
    return count;
  }
  public int minimumOperations(int[] nums, int x) {
    int totalSum = Arrays.stream(nums).sum();
    int target = totalSum - x;

    if (target < 0)
      return -1;

    if (target == 0)
      return nums.length;

    int n = nums.length;
    int minOperations = Integer.MAX_VALUE;
    int currentSum = 0;
    int leftIndex = 0, rightIndex = 0;

    while (rightIndex < n) {
      currentSum += nums[rightIndex];
      rightIndex++;

      while (currentSum > target && leftIndex < n) {
        currentSum -= nums[leftIndex];
        leftIndex++;
      }

      if (currentSum == target)
        minOperations = Math.min(minOperations, n - (rightIndex - leftIndex));
    }

    return (minOperations == Integer.MAX_VALUE) ? -1 : minOperations;
  }
}
