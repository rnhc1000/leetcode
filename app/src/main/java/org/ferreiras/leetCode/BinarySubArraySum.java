package org.ferreiras.leetCode;

/*
Given a binary array nums and an integer goal, return the number of non-empty subarrays
with a sum goal.

A subarray is a contiguous part of the array.

Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15

Constraints:

1 <= nums.length <= 3 * 104
nums[i] is either 0 or 1.
0 <= goal <= nums.length

Approach
Initialize variables left, currentCount, and finalCount to 0.
left represents the start of the subarray,
currentCount keeps track of the number of subarrays with the sum equal to the goal,
and finalCount stores the total count.
Iterate through the array using pointer right.
If the current element nums[right] is 1, decrement the goal variable and reset count to 0.
While goal is 0 and left is less than or equal to right, update goal by adding nums[left],
increment left, increment currentCount, and check if left exceeds right - goal + 1. If so,
break the loop.
While goal is less than 0, update goal by adding nums[left] and increment left.
Add currentCount to finalCount.
Return finalCount as the result.
 */
public class BinarySubArraySum {
  public static void main(String[] args) {
    int[] nums = {0, 0, 0, 0, 0};
    int goal = 0;
    int r = BinarySubArraySum.numSubarraysSum(nums, goal);
    System.out.println(r);

  }

  public static int numSubarraysWithSum(int[] nums, int goal) {
    int maxLength = Integer.MIN_VALUE;
    int left = 0, windowSum = 0;
    for (int right = 0; right < nums.length; right++) {

      while (windowSum > goal) {
        windowSum -= nums[left];
        left += 1;
      }

      maxLength = Math.max(maxLength, right - left + 1);

      if (right < nums.length - 1) {
        windowSum += nums[right + 1];
      }

    }

    return maxLength;
  }

  public static int numSubarraysSum(int[] nums, int goal) {

    int left = 0, currentCount = 0, finalCount = 0;
    for (int right = 0; right < nums.length; ++right) {
      if (nums[right] == 1) {
        goal--;
        currentCount = 0;
      }

      while (goal == 0 && left <= right) {
        goal += nums[left];
        left++;
        currentCount++;
        if (left > right - goal + 1)
          break;
      }

      while (goal < 0) {
        goal += nums[left];
        left++;
      }

      finalCount += currentCount;
    }

    return finalCount;
  }
}
