package org.ferreiras.leetcode;

import java.util.HashMap;
import java.util.Arrays;

/**
 * You are given an integer array nums and an integer k.
 * In one operation, you can pick two numbers from the array whose sum equals k and
 * remove them from the array.
 * Return the maximum number of operations you can perform on the array.
 * Example 1:
 * Input: nums = [1,2,3,4], k = 5
 * Output: 2
 * Explanation: Starting with nums = [1,2,3,4]:
 * - Remove numbers 1 and 4, then nums = [2,3]
 * - Remove numbers 2 and 3, then nums = []
 * There are no more pairs that sum up to 5, hence a total of 2 operations.
 * Example 2:
 * Input: nums = [3,1,3,4,3], k = 6
 * Output: 1
 * Explanation: Starting with nums = [3,1,3,4,3]:
 * - Remove the first two 3's, then nums = [1,4,3]
 * There are no more pairs that sum up to 6, hence a total of 1 operation.
 */
public class MaxNumberOfKSums {
  public static void main(String[] args) {
//    int[] nums = {1, 2, 3, 4};
//    int k = 5;
//    int k = 6;
//    int[] nums = {3, 1, 3, 4, 3};
    int[] nums = {4, 4, 1, 3, 1, 3, 2, 2, 5, 5, 1, 5, 2, 1, 2, 3, 5, 4};
    int k = 2;
    int count = maxOperations(nums, k);
    System.out.println("Total number of operations: " + count);
  }

  public static int numOfOperations(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int count = 0;
    for (int num : nums) {
      //to check if num is present and have some value
      if (map.containsKey(num) && map.get(num) > 0) {
        count++;
        map.put(num, map.get(num) - 1);
      } else {
        //getOrDefault is easy way it directly checks if value is 0 returns 0 where I added 1
        //and if some value is present then it return that value "similar to map.get(i)" and I added 1 on it
        map.put(k - num, map.getOrDefault(k - num, 0) + 1);
      }
    }
    return count;
  }

  public static int maxOperations(int[] nums, int k) {
    Arrays.sort(nums);
    int max = nums.length;
    int sum = Integer.MIN_VALUE;
    int count = 0;
    int left = 0;
    int right = max-1;
    while (left < right) {
      sum = nums[left] + nums[right];
      if (sum == k) {
        count++;
        left++;
        right--;
      } else if (sum < k) {
       left++;
      } else {
        right--;
      }
    }
    return count;
  }
}


