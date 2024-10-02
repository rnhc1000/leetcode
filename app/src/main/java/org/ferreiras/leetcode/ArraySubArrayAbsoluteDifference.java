package org.ferreiras.leetcode;
/*
iven an array of integers nums and an integer limit, return the size of the longest non-empty subarray
such that the absolute difference between any two elements of this subarray is less than or equal to limit.

Example 1:

Input: nums = [8,2,4,7], limit = 4
Output: 2
Explanation: All subarrays are:
[8] with maximum absolute diff |8-8| = 0 <= 4.
[8,2] with maximum absolute diff |8-2| = 6 > 4.
[8,2,4] with maximum absolute diff |8-2| = 6 > 4.
[8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
[2] with maximum absolute diff |2-2| = 0 <= 4.
[2,4] with maximum absolute diff |2-4| = 2 <= 4.
[2,4,7] with maximum absolute diff |2-7| = 5 > 4.
[4] with maximum absolute diff |4-4| = 0 <= 4.
[4,7] with maximum absolute diff |4-7| = 3 <= 4.
[7] with maximum absolute diff |7-7| = 0 <= 4.
Therefore, the size of the longest subarray is 2.
Example 2:

Input: nums = [10,1,2,4,7,2], limit = 5
Output: 4
Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.
Example 3:

Input: nums = [4,2,2,2,4,4,2,2], limit = 0
Output: 3


Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
0 <= limit <= 109

Intuition by https://leetcode.com/lancertech6
The problem requires finding the longest subarray where the absolute difference between the maximum and minimum
elements is less than or equal to a given limit. To achieve this, we can use a sliding window technique combined
with two deque to keep track of the minimum and maximum elements within the current window.

Approach
Deque for Tracking Min and Max:

Use two deque: increase to keep track of the increasing order of elements (for the minimum value)
and decrease for the decreasing order of elements (for the maximum value).
Sliding Window Technique:

Iterate through the array while maintaining a sliding window.
For each element, add it to both deque:
Remove elements from the back of increase deque until the last element is greater than the current element.
Remove elements from the back of decrease deque until the last element is less than the current element.
Add the current element to the back of both deque.
Adjust Window:

Check the difference between the maximum and minimum elements in the current window (front elements of the
decrease and increase deque respectively).
If the difference exceeds the limit, adjust the window by moving the left pointer until the difference is within
the limit again.
Remove elements from the deque if they are equal to the element at the left pointer before incrementing the
left pointer.

Track Maximum Size:

Calculate the size of the current valid window and update the maximum size if the current size is larger.
Complexity
Time Complexity: O(n), where n is the length of the array. Each element is added and removed from the deques at most once, leading to linear time complexity.
Space Complexity: O(n) in the worst case, for the space used by the deques.
Step by Step Explanation

Example
Input: nums = [8, 2, 4, 7], limit = 4
Expected Output: 2
Initial State
Index	Value	Increase Deque	Decrease Deque	Left	Right	Max Length
0		0
Iteration 1: Right = 0
Add 8 to both deque.
Deque after adding: increase = [8], decrease = [8]
Max Length = 1
Index	Value	Increase Deque	Decrease Deque	Left	Right	Max Length
0	8	[8]	[8]	0	0	1
Iteration 2: Right = 1
Add 2 to increase and decrease.
Deque after adding: increase = [2, 8], decrease = [8, 2]
Difference: 8 - 2 = 6 > 4
Move left to 1, remove 8 from deques.
Max Length = 1
Index	Value	Increase Deque	Decrease Deque	Left	Right	Max Length
1	2	[2]	[2]	1	1	1
Iteration 3: Right = 2
Add 4 to increase and decrease.
Deque after adding: increase = [2, 4], decrease = [4, 2]
Difference: 4 - 2 = 2 ≤ 4
Max Length = 2
Index	Value	Increase Deque	Decrease Deque	Left	Right	Max Length
2	4	[2, 4]	[4, 2]	1	2	2
Iteration 4: Right = 3
Add 7 to increase and decrease.
Deque after adding: increase = [2, 4, 7], decrease = [7, 4, 2]
Difference: 7 - 2 = 5 > 4
Move left to 2, remove 2 from deque.
Difference: 7 - 4 = 3 ≤ 4
Max Length = 2
Index	Value	Increase Deque	Decrease Deque	Left	Right	Max Length
3	      7	      [4, 7]	          [7, 4]	  2	    3	      2
Final Result
The size of the longest subarray with the absolute difference ≤ limit is 2.
 */
import java.util.LinkedList;

public class ArraySubArrayAbsoluteDifference {

  public static void main(String[] args) {
    int[] nums = {8, 2, 4, 7};
    int k = 4;
    int num = longestSubarray(nums, k);
    System.out.println(num);
  }

  public static int longestSubarray(int[] nums, int limit) {

    LinkedList<Integer> increase = new LinkedList<>();
    LinkedList<Integer> decrease = new LinkedList<>();

    int max = 0;
    int left = 0;

    for (int i = 0; i < nums.length; i++) {
      int n = nums[i];

      while (!increase.isEmpty() && n < increase.getLast()) {
        increase.removeLast();
      }
      increase.add(n);

      while (!decrease.isEmpty() && n > decrease.getLast()) {
        decrease.removeLast();
      }

      decrease.add(n);

      while (decrease.getFirst() - increase.getFirst() > limit) {
        if (nums[left] == decrease.getFirst()) {
          decrease.removeFirst();
        }
        if (nums[left] == increase.getFirst()) {
          increase.removeFirst();
        }
        left++;
      }

      int size = i - left + 1;
      max = Math.max(max, size);
    }

    return max;
  }
}
