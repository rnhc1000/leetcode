package org.ferreiras.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 * Example 1:
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the
 * range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 * Example 2:
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2].
 * 2 is the missing number in the range since it does not appear in nums.
 * Example 3:
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9].
 * 8 is the missing number in the range since it does not appear in nums.
 * Constraints:
 * n == nums.length
 * 1 <= n <= 104
 * 0 <= nums[i] <= n
 * All the numbers of nums are unique.
 * Bit Manipulation (XOR):
 * In this approach, you use bitwise XOR operation to find the missing number.
 * XOR operation on a number with itself results in 0. So, if you XOR all the numbers
 * from 0 to n and all the numbers in the array, the result will be the missing number.
 * <p>
 * Initialize missing to 0.
 * Iterate over the array and XOR each number with missing.
 * After the iteration, the value in missing will be the missing number.
 * Complexity
 * ⏱️ Time Complexity: O(n) - for XORing all the numbers
 * <p>
 * 🚀 Space Complexity: O(1)
 */
public class MissingNumber {

  public static void main(String[] args) {
    int[] numbers = {3,0,0,3,4,1};
    int n = numbers.length;
    int r = missingNumbers(numbers);
    System.out.println(r);
  }

  public static int missNumber(int[] nums) {
    int miss = nums.length;
    for (int i = 0; i < nums.length; i++) {
      miss ^= i ^ nums[i];
    }
    return miss;
  }

  public static int missingNumber(int[] nums) {
    Arrays.sort(nums);
    int size = nums.length;
    int num = 0;
    num = (size == 1) ? 1 : (size == 2) ? 2 : 0;
    int count = nums[0];
    for (int j : nums) {
      if (j != count) {
        num = count;
      }
      count++;
    }
    return num;
  }

  //1,N -> range for teh code below
  public static int missingOneNumber(int[] numbers, int n) {
    int i;
    int[] temp = new int[n+1];
    for (int j = 0; j < n; j++) {
      temp[numbers[j] - 1] = 1;
    }
    int response = 0;
    for (int j = 0; j <= n; j++) {
      if (temp[j] == 0) {
        response = j + 1;
      }
    }
    return response;
  }

  public static int missingNumbers(int[] numbers) {
    int missing = 0, size = numbers.length;
    Set<int[]> set = new HashSet<>(List.of(numbers));
    for (int i = 0; i < size ; i++) {
      if (set.contains(i)) {
        continue;
      }
      missing = i;
    }
    return missing;
  }
}
