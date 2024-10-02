package org.ferreiras.leetcode;

/**
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j].
 * An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
 * Given an integer array nums, return true if the given array is monotonic, or false otherwise.
 * Example 1:
 * Input: nums = [1,2,2,3]
 * Output: true
 * Example 2:
 * Input: nums = [6,5,4,4]
 * Output: true
 * Example 3:
 * Input: nums = [1,3,2]
 * Output: false
 * Intuition by
 * <a href="https://leetcode.com/antrixsh/">...</a>
 * To check if an array is monotonic, we can iterate through the array once
 * and check if it is either entirely non-increasing or entirely non-decreasing.
 * Approach
 * Initialize two flags, increasing and decreasing, as true.
 * Iterate through the array from the second element to the last.
 * If the current element is greater than the previous element, set decreasing to false.
 * If the current element is less than the previous element, set increasing to false.
 * If both flags remain true after the loop, return true (monotonic).
 * Otherwise, return false (not monotonic).
 */
public class MonotonicArray {

  public static void main(String[] args) {
    int[] numbers = {6,5,4,4};
    boolean r = isMonotonic(numbers);
    System.out.println(r);
  }

  public static boolean isMonotonic(int[] nums) {
    boolean isIncreasing = false;
    boolean isDecreasing = false;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) {
        isIncreasing = true;
      } else if (nums[i] < nums[i-1]) {
        isDecreasing = true;
      } else {
        continue;
      }
      if (isDecreasing && isIncreasing) {
        return false;
      }
    }
    return true;
  }

  public boolean monotonic(int[] nums) {
    boolean isAscending = nums[0] < nums[nums.length-1];
    if(isAscending){
      for(int i=1; i<nums.length; i++){
        if(nums[i] < nums[i-1]) return false;
      }
    }else{
      for(int i=1; i<nums.length; i++){
        if(nums[i] > nums[i-1]) return false;
      }
    }

    return true;
  }
}
