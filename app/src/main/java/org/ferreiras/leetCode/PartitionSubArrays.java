package org.ferreiras.leetCode;

/**
 * Given an integer array arr, partition the array into (contiguous)
 * subarrays of length at most k. After partitioning, each subarray
 * has their values changed to become the maximum value of that subarray.
 * Return the largest sum of the given array after partitioning.
 * Test cases are generated so that the answer fits in a 32-bit integer.
 * Example 1:
 * Input: arr = [1,15,7,9,2,5,10], k = 3
 * Output: 84
 * Explanation: arr becomes [15,15,15,9,10,10,10]
 * Example 2:
 * Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
 * Output: 83
 * Example 3:
 * Input: arr = [1], k = 1
 * Output: 1
 * Approach
 * Initialize a DP array: Initialize a DP array of length n+1 (n being the
 * length of the input array) with all zeros.
 * This DP array will store the maximum sum achievable up to each index.
 * The reason for having n+1 elements is to conveniently handle the base case
 * where no elements have been considered yet (i.e., dp[0] = 0).
 * Iterating Through the Array: For each element in the array (
 * from the first to the last), determine the maximum sum achievable up to that point.
 * This involves considering all possible partition sizes up to k that could end at
 * the current element.
 * Considering All Partitions Up to Size k: For each element i, look back up to k
 * elements to find the partition that maximizes the sum.
 * This step involves two sub-steps:
 * Finding the maximum value in the current partition (max), which will be used to
 * update all elements in the partition to this value.
 * Calculating the maximum sum for the current partition by adding the product of
 * the maximum value (max) and the partition size (j) to
 * the maximum sum achievable before this partition started (dp[i-j]).
 * Updating the DP Array: Update dp[i] with the maximum sum achievable by including
 * the current element in a partition. This is done by comparing the sum calculated
 * for each possible partition size and choosing the maximum.
 *
 * Result:
 * After filling the DP array, the maximum sum after partitioning the array is found
 * at dp[n], which accounts for the entire array.
 */
public class PartitionSubArrays {

  public static void main(String[] args) {
    int[] nums = {1,4,1,5,7,3,6,1,9,9,3};
    int k = 4;
    int response = maxSumAfterPartitioning(nums,k);
    System.out.println(response);
  }
  public static int sumMaxAfterPartitioning(int[] arr, int k) {
    int size = arr.length;
    int aux = k + 1;
    int[] maximums = new int[aux];
    for (int start = size - 1; start >= 0; start--) {
      int currentMax = 0;
      int end = Math.min(size, start + aux);
      for (int i = start; i < end; i++) {
        currentMax = Math.max(currentMax, arr[i]);
        maximums[start % aux] = Math.max(
                maximums[start % aux],
                maximums[(i + 1) % aux] + currentMax * (i - start + 1)
        );
      }
    }
    return maximums[0];
  }
    public static int maxSumAfterPartitioning(int[] arr, int k) {
      int n = arr.length;
      int[] dp = new int[n + 1];

      for (int i = 1; i <= n; i++) {
        int maximum = 0;
        int maxSum = 0;
        for (int j = 1; j <= k && i - j >= 0; j++) {
          maximum = Math.max(maximum, arr[i - j]);
          maxSum = Math.max(maxSum, dp[i - j] + maximum * j);
        }
        dp[i] = maxSum;
      }

      return dp[n];
    }
  }







