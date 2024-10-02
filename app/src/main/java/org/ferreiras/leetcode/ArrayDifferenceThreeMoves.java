package org.ferreiras.leetcode;

import java.util.Arrays;

/*
You are given an integer array nums.
In one move, you can choose one element of nums and change it to any value.
Return the minimum difference between the largest and smallest value of nums after performing at most three moves.

Example 1:

Input: nums = [5,3,2,4]
Output: 0
Explanation: We can make at most 3 moves.
In the first move, change 2 to 3. nums becomes [5,3,3,4].
In the second move, change 4 to 3. nums becomes [5,3,3,3].
In the third move, change 5 to 3. nums becomes [3,3,3,3].
After performing 3 moves, the difference between the minimum and maximum is 3 - 3 = 0.

Example 2:
Input: nums = [1,5,0,10,14]
Output: 1
Explanation: We can make at most 3 moves.
In the first move, change 5 to 0. nums becomes [1,0,0,10,14].
In the second move, change 10 to 0. nums becomes [1,0,0,0,14].
In the third move, change 14 to 1. nums becomes [1,0,0,0,1].
After performing 3 moves, the difference between the minimum and maximum is 1 - 0 = 1.
It can be shown that there is no way to make the difference 0 in 3 moves.
Example 3:

Input: nums = [3,100,20]
Output: 0
Explanation: We can make at most 3 moves.
In the first move, change 100 to 7. nums becomes [3,7,20].
In the second move, change 20 to 7. nums becomes [3,7,7].
In the third move, change 3 to 7. nums becomes [7,7,7].
After performing 3 moves, the difference between the minimum and maximum is 7 - 7 = 0.


Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109

Intuition by https://leetcode.com/suyalneeraj09
The key insights behind this intuition is:

If the array has less than 5 elements, the minimum difference will be 0, as we can't form two groups of 4 elements.
Sorting the array in ascending order allows us to easily identify the 4 smallest and 4 largest elements.
By calculating the difference between the sum of the 4 largest elements and the sum of the 4 smallest elements,
we can find the minimum difference.

Approach
The approach used in the provided code is to find the minimum difference between the sum of the largest 4 elements
and the sum of the smallest 4 elements in the given array A.
The intuition behind this approach is that the minimum difference will be achieved by either:

Removing the 4 smallest elements and keeping the 4 largest elements.
Removing the 4 largest elements and keeping the 4 smallest elements.
Complexity
Time complexity:O(n log n)
Space complexity:O(1)
 */
public class ArrayDifferenceThreeMoves {

  public static void main(String[] args) {
    int[] nums = {1, 5, 0, 10, 14};
    int response = minDifference(nums);
    System.out.println(response);
  }
  public static int minDifference(int[] nums) {

    int size = nums.length, difference = Integer.MAX_VALUE;

    if (size < 5) return 0;

    Arrays.sort(nums);

    for (int i = 0; i < 4; ++i) {

      difference = Math.min(difference, nums[size - 4 + i] - nums[i]);
    }

    return difference;
  }

}
