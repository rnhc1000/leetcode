package org.ferreiras.leetCode;

import java.util.Arrays;

/*
Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n))
time complexity and with the smallest space complexity possible.



Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation:
After sorting the array, the positions of some numbers are not changed (for example, 2 and 3),
while the positions of other numbers are changed (for example, 1 and 5).

Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation:
Note that the values of nums are not necessarily unique.


Constraints:

1 <= nums.length <= 5 * 104
-5 * 104 <= nums[i] <= 5 * 104
 */
public class ArraySortRaw {

  public static void main(String[] args) {
    int[] nums = {5,1,1,2,0,0};
    int[] response = sortArray(nums);

    System.out.println(Arrays.toString(response));
  }
  public static int[] sortArray(int[] nums) {

    boolean needsSwap = false;
    int size = nums.length;

    for (int i = 0; i < size; i++) {

      for (int j = 0; j < size - 1 - i; j++) {

        if(nums[j] > nums[j+1]) {
          nums[j] = nums[j] ^ nums[j+1];
          nums[j+1] = nums[j] ^ nums[j+1];
          nums[j] = nums[j] ^ nums[j+1];
        }
      }
    }


    return nums;

  }

  public static int[] mergeSort(int[] array) {
    if (array.length == 1) return array;
    int midIndex = array.length / 2;
    System.out.println("MidIndex: " + midIndex);
    int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
    int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));
    System.out.println(Arrays.toString(array));
    System.out.println(Arrays.toString(left));
    System.out.println(Arrays.toString(right));

    return merge(left, right);
  }

  public static int[] merge(int[] array1, int[] array2) {
    int[] combined = new int[array1.length + array2.length];
    int index = 0;
    int i = 0;
    int j = 0;
    while (i < array1.length && j < array2.length) {
      if (array1[i] < array2[j]) {
        combined[index] = array1[i];
        index++;
        i++;
      } else {
        combined[index] = array2[j];
        index++;
        j++;
      }
    }
    while (i < array1.length) {
      combined[index] = array1[i];
      index++;
      i++;
    }
    while (j < array2.length) {
      combined[index] = array2[j];
      index++;
      j++;
    }

    return combined;
  }
}
