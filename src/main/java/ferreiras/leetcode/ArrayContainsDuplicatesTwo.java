package ferreiras.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/*
Given an integer array nums and an integer k, return true if there are two distinct indices
i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false


Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
 */
public class ArrayContainsDuplicatesTwo {
  public static void main(String[] args) {
    int[]  nums = {1,2,3,1};
    int k = 3;
    boolean response = containsNearbyDuplicate(nums, k);
    System.out.println(response);
  }
  public static boolean containsNearbyDuplicate(int[] nums, int k) {
    if (nums == null || nums.length < 2 || k < 0) return false;

    Map<Integer, Integer> map = new LinkedHashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
        return true;
      }
      map.put(nums[i],i);
//      map.put(nums[i], map.getOrDefault(nums[i], 1));
    }

    return false;

  }
}
