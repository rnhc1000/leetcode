package org.ferreiras.leetCode;

import java.util.Arrays;

/*
A swap is defined as taking two distinct positions in an array and swapping the values in them.

A circular array is defined as an array where we consider the first element and the last element to be adjacent.

Given a binary circular array nums, return the minimum number of swaps required to group all 1's present in the array together at any location.



Example 1:

Input: nums = [0,1,0,1,1,0,0]
Output: 1
Explanation: Here are a few of the ways to group all the 1's together:
[0,0,1,1,1,0,0] using 1 swap.
[0,1,1,1,0,0,0] using 1 swap.
[1,1,0,0,0,0,1] using 2 swaps (using the circular property of the array).
There is no way to group all 1's together with 0 swaps.
Thus, the minimum number of swaps required is 1.
Example 2:

Input: nums = [0,1,1,1,0,0,1,1,0]
Output: 2
Explanation: Here are a few of the ways to group all the 1's together:
[1,1,1,0,0,0,0,1,1] using 2 swaps (using the circular property of the array).
[1,1,1,1,1,0,0,0,0] using 2 swaps.
There is no way to group all 1's together with 0 or 1 swaps.
Thus, the minimum number of swaps required is 2.
Example 3:

Input: nums = [1,1,0,0,1]
Output: 0
Explanation: All the 1's are already grouped together due to the circular property of the array.
Thus, the minimum number of swaps required is 0.


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.

Counting 1s (k):

First, the code calculates the total number of 1s in the array, denoted by k.
This is because the task is to find the smallest window (or segment) of size k
that contains the maximum number of 1s.
Initial Window Calculation:

The code then computes the number of 1s in the first window of size k.
This is achieved by summing up the first k elements of the array.
This sum is stored in the variable cnt and also in maxCount (as the initial maximum count of 1s in any window).
Sliding Window Technique:

The core part of the solution involves a sliding window approach to move through the array and calculate the number of 1s in each window of size k.
For each step from i = k to i = n + k - 1 (where n is the length of the array):
The code updates the cnt by adding the next element in the window (nums[i % n]) and removing the element that is sliding out of the window (nums[(i - k + n) % n]).
The maximum number of 1s found in any window of size k is updated in maxCount.
Result Calculation:

Finally, the result is derived as k - mx, which represents the minimum number of swaps needed. This is because k is the total number of 1s, and mx is the maximum number of 1s found in any window of size k. Therefore, the difference k - mx gives the minimum number of 0s that need to be swapped with 1s to achieve the desired grouping of 1s.
Complexity
Time complexity:
O(n)

Space complexity:
O(1)
 */
public class ArrayMinimumSwaps {

  public static void main(String[] args) {

    int[] nums = {0,1,0,1,1,0,0};
    int response = minSwaps(nums);
    System.out.println(response);

  }
  public static int minSwaps(int[] nums) {
    int countOnes = Arrays.stream(nums).sum();
    int size = nums.length;
    int count = 0;
    for (int i = 0; i < countOnes; ++i) {
      count += nums[i];
    }
    int maxCount = count;
    for (int i = countOnes; i < size + countOnes; ++i) {
      count += nums[i % size] - nums[(i - countOnes + size) % size];
      maxCount = Math.max(maxCount, count);
    }
    return countOnes - maxCount;
  }
}
