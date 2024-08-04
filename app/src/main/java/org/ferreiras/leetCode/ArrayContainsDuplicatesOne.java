package org.ferreiras.leetCode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/*
Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.

Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true


Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
 */
public class ArrayContainsDuplicatesOne {
  public static void main(String[] args) {
    int[] nums = {1, 3, 4, 2, 5, 1};
    boolean response = containsDuplicates(nums, true);
    System.out.println(response);
  }

  public static boolean containsDuplicate(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      if (map.containsKey(num)) {
        return true;
      } else {
        map.put(num, map.getOrDefault(num, 0) + 1);
      }
    }

    return false;
  }

  public static boolean containsDuplicates(int[] nums) {
    int left = 0, right = nums.length;
    for (int i = 0; i < right; i++) {
      for (int j = i + 1; j < right; j++) {

        if (nums[i] == nums[j]) {
          return true;

        }
      }
    }
    return false;
  }

  public static boolean containsDuplicates(int[] nums, boolean flag) {
    Logger logger = Logger.getLogger(ArrayContainsDuplicatesOne.class.getName());
    logger.info("Task had just been submitted!");
    Set<Integer> set = new LinkedHashSet<>();
    for (int num : nums) {
      logger.info("Iterating over the nums[] and trying to add each -> " + num + " to a set");
      if (!set.add(num)) {
        logger.info("Tried to add a repeated nums[i] -> " + num + " to a set, returned false, negated, and end of program returning true");
        return true;
      }
    }
    return false;
  }
}
