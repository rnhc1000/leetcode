package org.ferreiras.leetCode;
/*
Given an unsorted integer array nums. Return the smallest positive integer that
is not present in nums.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation:
The numbers in the range [1,2] are all in the array.

Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation:
1 is in the array but 2 is missing.

Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.


Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1

Intuition
The problem requires finding the smallest positive integer that is not present
in an unsorted integer array. To achieve this efficiently, we can utilize the
fact that the answer lies within the range [1, n+1], where n is the size of the array.
By rearranging the elements of the array, we can position each positive integer i at index i-1.
Then, we iterate through the array to find the first index i where nums[i] != i+1,
indicating the missing positive integer is i+1.

Approach
Iterate through the array and place each positive integer i at index i-1 if possible.
This ensures that the element nums[i] == i+1 if it exists in the array.
Iterate through the array again to find the first index i where nums[i] != i+1.
Return i+1 as the smallest missing positive integer.
If all numbers from 1 to n are present in the array, return n+1 as the result.
Dry run
let's do a dry run of the given array [3, 4, -1, 1]
Iteration 1:
Current array: [3, 4, -1, 1]
For element 3 (at index 0), swap it with the element at index 2 because 3 should be at index 2 swap(3,-1).
Updated array: [-1, 4, 3, 1]
now since -1 is out of range [1, n]
we will skip inner loop

Iteration 2:
Current array: [-1, 4, 3, 1]
For element 4 (at index 1), swap it with the element at index 3 because 4 should be at index 3 swap(4,1).
Updated array: [-1, 1, 3, 4]
now 1 is in the range [1, n] , 1 is not at it correct index
so swap(1,-1)
Updated array: [1, -1, 3, 4]

Iteration 3:
now 3 is present at correct index so skip this loop

Iteration 4:
now 4 is present at correct index so skip this loop
Final check:

We traverse the array again to find the smallest missing positive integer.
The first missing positive integer is 2 since it's not present in the array.
So, the smallest missing positive integer in the array [3, 4, -1, 1] is 2.

Complexity
Time complexity:O(n), where n is the size of the array. Both iterations through
the array take linear time.
Space complexity: O(1).
The algorithm uses only a constant amount of extra space, regardless of the
size of the input array.

 */
public class FirstMissingPositive {
  public static void main(String[] args) {

    int[] nums = {3,4,-1,1};
    int r = firstMissingPositive(nums);
    System.out.println(r);

  }
  public static int firstMissingPositive(int[] nums) {
    int size = nums.length;

    for (int i = 0; i < size; i++) {

      while (nums[i] > 0 && nums[i] <= size && nums[i] != nums[nums[i] - 1]) {
        swapPositions(nums, i, nums[i] - 1);
      }

    }

    for (int i = 0; i < size; i++) {

      if (nums[i] != i + 1) {
        return i + 1;
      }

    }

    return size + 1;
  }

  public static void swapPositions(int[] arr, int positionOne, int positionTwo) {
    int swap = arr[positionOne];
    arr[positionOne] = arr[positionTwo];
    arr[positionTwo] = swap;
  }
}
