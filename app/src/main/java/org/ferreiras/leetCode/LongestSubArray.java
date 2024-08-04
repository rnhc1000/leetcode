package org.ferreiras.leetCode;

import java.util.Collections;

/**
 * Given a binary array nums, you should delete one element from it.
 * Return the size of the longest non-empty sub array containing only 1's
 * in the resulting array. Return 0 if there is no such sub array.
 * Example 1:
 * Input: nums = [1,1,0,1]
 * Output: 3
 * Explanation: After deleting the number in position 2, [1,1,1] contains
 * 3 numbers with value of 1's.
 * Example 2:
 * Input: nums = [0,1,1,1,0,1,1,0,1]
 * Output: 5
 * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1]
 * longest sub array with value of 1's is [1,1,1,1,1].
 * Example 3:
 * Input: nums = [1,1,1]
 * Output: 2
 * Explanation: You must delete one element.
 */
public class LongestSubArray {

  public static void main(String[] args) {
    int[] nums = {0,1,1,1,1,1,0,1};
    int response = longestSubarray(nums);
    System.out.println(response);

  }
  public static int longestSubarray(int[] nums) {
    int size = nums.length;
    int left = 0, right =0;
    int countZeros = 0;
    int maxNumberOfOnes  = 0;
    for (;left<size;left++) {
      countZeros += (nums[left] == 0 ? 1 : 0);
      while (countZeros > 1) {
        countZeros -= (nums[right] == 0 ? 1 : 0);
        right++;
      }
      maxNumberOfOnes = Math.max(maxNumberOfOnes, left-right);
    }
    return maxNumberOfOnes;
  }
}
