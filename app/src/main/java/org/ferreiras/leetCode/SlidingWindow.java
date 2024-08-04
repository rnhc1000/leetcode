package org.ferreiras.leetCode;

/*
 * Time Complexity:
 * The time complexity of the sliding window technique is usually linear or close to linear, O(n),
 * where n is the size of the input data structure (e.g., array or string).
 * This is because you process each element once as the window slides through the data.
 * Space Complexity:
 * The space complexity of the sliding window technique is generally constant, O(1), because you’re
 * maintaining a fixed-size window and a few additional variables to perform calculations or store
 * intermediate results.
 * The amount of extra memory used does not grow with the input size; it remains constant regardless
 * of the input size.
 * Problems Solved by this technique:
 * Maximum/Minimum Subarray Sum:
 * Longest Substring with K Distinct Characters:
 * Longest Subarray with Ones after Replacement:
 * Find All Anagrams in a String:
 * Smallest Subarray with Sum at Least K:
 * Maximum Consecutive Ones after Flipping Zeros:
 * Minimum Window Substring:
 * Longest Repeating Character Replacement:
 * Fruit Into Baskets:
 * Subarrays with Product Less than K:
 * Problem: Given an array of positive integers and an integer K, find the length of the
 * longest subarray whose sum is less than K.
 * Initialize variables: left to track the start of the subarray and right to iterate
 * through the array.
 * Initialize windowSum as the first element of the array.
 * Initialize maxLength to keep track of the maximum subarray length.
 */
public class SlidingWindow {
  public static void main(String[] args) {
//    int[] nums = {2, 1, 5, 1, 3, 2};
//    int k = 3;
    int[] nums = {1,2,3,4,5};
    int k =11;
    int response = maxSubArrayLength(nums, k);
    System.out.println(response);
  }

  public static int maxSubArray(int[] nums, int k) {
    int maxSum = Integer.MIN_VALUE;
    int windowSum = 0;
    for (int i = 0; i < k; i++) {
      windowSum += nums[i];
    }
    for (int i = k; i < nums.length; i++) {
      int temp = nums[i] - nums[i - k];
      windowSum += temp;
      maxSum = Math.max(maxSum, windowSum);
    }
    return maxSum;
  }

  public static int maxSubArrayLength(int[] nums, int k) {
    int maxLength = Integer.MIN_VALUE;
    int left = 0, windowSum = 0;
    for (int right = 0; right < nums.length; right++) {
      while (windowSum >= k) {
        windowSum -= nums[left];
        left += 1;
      }
      maxLength = Math.max(maxLength, right - left + 1);

      if (right < nums.length - 1) {
        windowSum +=nums[right + 1];
      }
    }
    return maxLength;
  }
}
