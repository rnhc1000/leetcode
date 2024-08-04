package org.ferreiras.leetCode;
/*
Given a binary array nums, return the maximum length of a contiguous subarray with an
equal number of 0 and 1.
Example 1:

Input: nums = [0,1]
Output: 2
Explanation:
[0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
 */

import java.util.HashMap;
import java.util.Map;

public class ArrayContiguous  {

  public static void main(String[] args) {
    int[] array = {0, 1, 0};
    int r = findMaxLength(array);
    System.out.println(r);
  }

  public static int findMaxLength(int[] nums) {
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    int subArrayLength = 0;
    for (int i = 0; i < n; i++) {
      sum += nums[i] == 0 ? -1 : 1;
      if (sum == 0) {
        subArrayLength = i + 1;
      } else if (map.containsKey(sum)) {
        subArrayLength = Math.max(subArrayLength, i - map.get(sum));
      } else {
        map.put(sum, i);
      }
    }

    return subArrayLength;
  }
}
