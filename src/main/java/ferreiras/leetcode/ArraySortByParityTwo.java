package ferreiras.leetcode;

import java.util.Arrays;

/*
Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.

Return any answer array that satisfies this condition.

Example 1:
Input: nums = [4,2,5,7]
Output: [4,5,2,7]
Explanation:
[4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.

Example 2:
Input: nums = [2,3]
Output: [2,3]

Constraints:
2 <= nums.length <= 2 * 104
nums.length is even.
Half of the integers in nums are even.
0 <= nums[i] <= 1000
 */
public class ArraySortByParityTwo {

  public static void main(String[] args) {
    int[] numbers = { 4, 2, 5, 7};

    int[] response = sortArrayByParityII(numbers);

    System.out.println(Arrays.toString(response));

  }
  public static int[] sortArrayByParityII(int[] nums) {

    int odd = 1;
    int even = 0;
    int[] numbers  = new int[nums.length];

    for (int num : nums) {

      if (num % 2 == 0) {
        numbers[even] = num;
        even += 2;
      } else {
        numbers[odd] = num;
        odd += 2;
      }

    }
    return numbers;
  }
}
