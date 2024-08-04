package org.ferreiras.leetCode;

/**
 * Given an array of integers nums, return the number of good pairs.
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 * Example 1:
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 * Example 2:
 * Input: nums = [1,1,1,1]
 * Output: 6
 * Explanation: Each pair in the array are good.
 * Example 3:
 * Input: nums = [1,2,3]
 * Output: 0
 */
public class NumberOfGoodPairs {
  public static void main(String[] args) {
    int[] numbers = {1,2,3};
    int r = numIdenticalPairs(numbers);
    System.out.println(r);
  }
  public static int numIdenticalPairs(int[] nums) {
    //A pair (i, j) is called good if nums[i] == nums[j] and i < j.
    //[1,2,3,1,1,3]
    int indexOne = 1, indexTwo = 1;
    int size = nums.length;
    int count = 0;
    for (int i = 0; i < size; i++) {
      for (; indexOne < size; indexOne++) {
        if (nums[i] == nums[indexOne]) {
          count++;
        }
      }
      indexTwo++;
      indexOne=indexTwo;
    }

    return count;
  }
}
