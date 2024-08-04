package org.ferreiras.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * Constraints:
 * n == nums length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 */
public class FindMajority {
  public static void main(String[] args) {
    int[] nums = {2,2,1,1,1,2,2,1,1};
    int response = majorityElements(nums);
    System.out.println(response);
  }

  public static int majorityElement(int[] nums) {
    int max = Integer.MIN_VALUE;
    int size = nums.length;
    Map<Integer, Integer> count = new HashMap<>();
    for (int num : nums) {
      count.put(num, count.getOrDefault((num), 0) + 1);
    }
    int appear = size / 2;
    for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
      if (entry.getValue() > appear) {
        max = entry.getKey();
      }
    }
    return max;
  }

  public static int majorityElements(int[] nums) {
    int max = Integer.MIN_VALUE;
    int size = nums.length;
    int appearances = size / 2;
    int count = 1;
    int left = 0;
    for (int right = 1; right < size; right++) {
      if(nums[right] == nums[left]) {
        count++;
        max = nums[left];
        if (count  > appearances) {
          return max;
        }
        left=right;
        max=nums[left];
      }
    }
    return max;
  }
}
