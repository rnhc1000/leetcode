package org.ferreiras.leetcode;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order
 * of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 * Intuition
 * For this problem we will use two pointer algorithm.
 * Nice explanation by:
 * https://leetcode.com/alekseyvy/
 * Approach
 * First we declare left and right pointers at 0 index position, then we start to iterate over nums array and look for two possible scenarios either right ponter points to zero in this scenario we just scip to next right pointer index, and if right pointer is pointing to non zero value, in this case we swap right and left numbers, the main takeaway is that left and right will be swapping until they found first zero, then left will be pointing to zero and right will go and find non zero number to swap with left, and repeat until right pointer will reach end of nums array.
 * Complexity
 * Time complexity:
 * O(n) - Since we iterate only once for each num in nums Array
 * Space complexity:
 * O(1) - since we create only two int pointers and we mutate original array
 * Another approach;
 * Create an array of integers, iterate over the array source
 * and look only for numbers different of zeros
 *
 */

import java.util.Arrays;

public class MoveZeroes {
  public static void main(String[] args) {
    int[] numbers = {0, 1, 0, 3, 0, 0, 12, 0, 0, 0};
    int[] response =  moveZerosTwoPointers(numbers);
    System.out.println(Arrays.toString(response));
    System.out.println(Arrays.toString(response));
  }

  public static int[] moveZeroes(int[] nums) {
    int size = nums.length;
    int[] indexOfZeros = new int[size];
    int i = 0;
    for (int num : nums) {
      if (num != 0) {
        indexOfZeros[i] = num;
        i++;
      }
    }
    return indexOfZeros;
  }

  public static int[] moveZerosTwoPointers(int[] nums) {
    int leftPointer = 0, rightPointer = 0, temporaryValue = 0;
    int size = nums.length;
    for(; rightPointer< size; rightPointer++) {
      if(nums[rightPointer] != 0) {
        temporaryValue = nums[rightPointer];
        nums[rightPointer] = nums[leftPointer];
        nums[leftPointer] = temporaryValue;
        leftPointer++;
      }
    }
    return nums;
  }
}
