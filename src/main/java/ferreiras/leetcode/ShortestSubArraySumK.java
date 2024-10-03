package ferreiras.leetcode;
/*
Given an integer array nums and an integer k, return the length of the shortest non-empty subarray
of nums with a sum of at least k. If there is no such subarray, return -1.

A subarray is a contiguous part of an array.
Example 1:

Input: nums = [1], k = 1
Output: 1
Example 2:

Input: nums = [1,2], k = 4
Output: -1
Example 3:

Input: nums = [2,-1,2], k = 3
Output: 3


Constraints:

1 <= nums.length <= 105
-105 <= nums[i] <= 105
1 <= k <= 109
What does the Deque store :
The deque stores the possible values of the start pointer. Unlike the sliding window, values of the
start variable will not necessarily be contiguous.

Why is it increasing :
So that when we move the start pointer and we violate the condition, we are sure we will violate it if
we keep taking the other values from the Deque. In other words, if the sum of the subarray from start=first
value in the deque to end is smaller than target, then the sum of the subarray from start=second value in
the deque to end is necessarily smaller than target.
So because the Deque is increasing (B[d[0]] <= B[d[1]]), we have B[i] - B[d[0]] >= B[i] - B[d[1]],
which means the sum of the subarray starting from d[0] is greater than the sum of the sub array starting
from d[1].

Why do we have a prefix array and not just the initial array like in sliding window :
Because in the sliding window when we move start (typically when we increment it) we can just
subtract nums[start-1] from the current sum and we get the sum of the new subarray.
Here the value of the start is jumping and one way to compute the sum of the current subarray in a
constant time is to have the prefix array.

Why using Deque and not simply an array :
We can use an array, however we will find ourselves doing only three operations:
1- remove_front : when we satisfy our condition and we want to move the start pointer
2- append_back : for any index that may be a future start pointer
3- remove_back : When we are no longer satisfying the increasing order of the array
Deque enables doing these 3 operations in a constant time.
 */
import java.util.Deque;
import java.util.LinkedList;
public class ShortestSubArraySumK {
  public int shortestSubarray(int[] nums, int k) {
    int size = nums.length;
    long[] numbers = new long[size + 1];
    for(int i = 0; i < size; i++) {
      numbers[i + 1] = numbers[i] + nums[i];
    }
    int response = size + 1;

    Deque<Integer> deque = new LinkedList<>();

    for(int i = 0; i < size + 1; i++) {
      while(!deque.isEmpty() && numbers[i] - numbers[deque.peekFirst()] >= k) {
        response = Math.min(response, i - deque.pollFirst());
      }
      while(!deque.isEmpty() && numbers[i] <= numbers[deque.peekLast()]) {
        deque.pollLast();
      }
      deque.addLast(i);
    }
    return response <= size ? response : -1;
  }
}
