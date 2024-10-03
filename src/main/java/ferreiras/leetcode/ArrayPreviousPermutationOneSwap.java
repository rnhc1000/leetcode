package ferreiras.leetcode;

import java.util.Arrays;

/*
Given an array of positive integers arr (not necessarily distinct), return the lexicographically
largest permutation that is smaller than arr, that can be made with exactly one swap.
If it cannot be done, then return the same array.

Note that a swap exchanges the positions of two numbers arr[i] and arr[j]

Example 1:

Input: arr = [3,2,1]
Output: [3,1,2]
Explanation: Swapping 2 and 1.
Example 2:

Input: arr = [1,1,5]
Output: [1,1,5]
Explanation: This is already the smallest permutation.
Example 3:

Input: arr = [1,9,4,6,7]
Output: [1,7,4,6,9]
Explanation: Swapping 9 and 7.


Constraints:

1 <= arr.length <= 104
1 <= arr[i] <= 104

Intuition by https://leetcode.com/narik114
Find the pivot point and swap it with a value whic suits the purpose

Approach
Example:

if you are given 82345, the previous largest permutation is 52348.

The approach is as follows;

Step - 1:

Find the pivot which is nothing but the value which is greater than the previous when moving from the right.
In the above example, move from 4.
(lesser than 5)->
move to 3(lesser than 4)->
move to 2 (<3) ->
move to 8.
At this point the value is greater than previous which is 2.

here pivot point is 8.

Step - 2:

Find the closest value in the right to the pivot and lesser than the pivot.
Observe that all the values right to pivot will be in sorted order.

Here in the example, the closest value to pivot is

Step - 3:

Swap the pivot with the closest value and return the array.

Complexity
Time complexity: O(N)
Space complexity: O(1)
 */
public class ArrayPreviousPermutationOneSwap {

  public static void main(String[] args) {
//    int[] numbers = {1,9,4,6,7 };
    int[] numbers = {1, 1, 5};
    int[] response = prevPermOpt1(numbers);
    System.out.println(Arrays.toString(response));
  }

  public static int[] prevPermOpt1(int[] arr) {
    int size = arr.length, i = size - 2;

    while (i >= 0) {

      if (arr[i] > arr[i + 1]) {
        break;
      } else {
        i--;
      }

    }

    if (i < 0) return arr;

    int j = size - 1;

    while (j > i && arr[i] <= arr[j]) {

      j--;

      while (j > i && arr[j] == arr[j - 1]) {

        j--;
      }
    }

//    int temp = arr[j];
//    arr[j] = arr[k];
//    arr[k] = temp;

    arr[j] = arr[j] ^ arr[i];
    arr[i] = arr[i] ^ arr[j];
    arr[j] = arr[j] ^ arr[i];


    return arr;
  }
}
