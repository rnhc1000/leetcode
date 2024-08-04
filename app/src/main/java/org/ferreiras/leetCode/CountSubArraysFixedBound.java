package org.ferreiras.leetCode;
/*
You are given an integer array nums and two integers minK and maxK.

A fixed-bound subarray of nums is a subarray that satisfies the following conditions:

The minimum value in the subarray is equal to minK.
The maximum value in the subarray is equal to maxK.
Return the number of fixed-bound subarrays.

A subarray is a contiguous part of an array.



Example 1:

Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
Output: 2
Explanation:
The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
Example 2:

Input: nums = [1,1,1,1], minK = 1, maxK = 1
Output: 10
Explanation:
Every subarray of nums is a fixed-bound subarray. There are 10 possible subarrays.


Constraints:

2 <= nums.length <= 105
1 <= nums[i], minK, maxK <= 106

 */
public class CountSubArraysFixedBound {
  public static void main(String[] args) {
    int[] nums = {1,3,5,2,7,5};
    int minK = 1;
    int maxK = 5;
    long response = countSubarrays(nums, minK, maxK);
    System.out.println(response);

  }
  public static long countSubarrays(int[] nums, int minK, int maxK) {
    int currentIndex = -1, leftIndex = -1, rightIndex = -1, max = 0;
    long result = 0;

    for (int i = 0; i < nums.length; ++i) {
      if (!(minK <= nums[i] && nums[i] <= maxK)) {
        currentIndex = i;
      }

      if (nums[i] == minK) {
        leftIndex = i;
      }

      if (nums[i] == maxK) {
        rightIndex = i;
      }

      result += Math.max(max, Math.min(leftIndex, rightIndex) - currentIndex);
    }

    return result;
  }
}
