package org.ferreiras.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You are given an integer array nums. In one operation, you can replace any element in
nums with any integer.
nums is considered continuous if both of the following conditions are fulfilled:

All elements in nums are unique.
The difference between the maximum element and the minimum element in nums equals nums.length - 1.
For example, nums = [4, 2, 5, 3] is continuous, but nums = [1, 2, 3, 5, 6] is not continuous.

Return the minimum number of operations to make nums continuous.
Example 1:

Input: nums = [4,2,5,3]
Output: 0
Explanation: nums is already continuous.
Example 2:
Input: nums = [1,2,3,5,6]
Output: 1
Explanation: One possible solution is to change the last element to 4.
The resulting array is [1,2,3,5,4], which is continuous.
Example 3:
Input: nums = [1,10,100,1000]
Output: 3
Explanation: One possible solution is to:
- Change the second element to 2.
- Change the third element to 3.
- Change the fourth element to 4.
The resulting array is [1,2,3,4], which is continuous.
 */
public class MakeArrayContinuous {
  public static void main(String[] args) {
    int[] nums = {1,2,3,5,6};
    int response = minOperations(nums);
    System.out.println(response);
  }

  public static int minOperations(int[] nums) {

    int size = nums.length;
    int newSize = 1;
    Arrays.sort(nums);
    for (int i = 1; i < size; ++i) {
      if (nums[i] != nums[i - 1]) {
        nums[newSize++] = nums[i];
      }
    }

    int ops = size;

    for (int left = 0, right = 0; left < newSize; left++) {

      while (right < newSize && nums[right] - nums[left] <= size - 1) {
        right++;
      }
      ops = Math.min(ops, size - (right - left));
    }


    System.out.println("Min -> " + ops);
    /*
    All elements in nums are unique.
The difference between the maximum element and the minimum element in nums equals nums.length - 1.
     */

    return ops;
  }
}
