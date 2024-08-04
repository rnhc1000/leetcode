package org.ferreiras.leetCode;

/*
Given a non-empty array of integers nums, every element appears twice except for one.
Find that single one.
You must implement a solution with a linear runtime complexity and use only constant
extra space. O(n) & O(1);
Example 1:
Input: nums = [2,2,1]
Output: 1
Example 2:
Input: nums = [4,1,2,1,2]
Output: 4
Example 3:
Input: nums = [1]
Output: 1
Nice explanation of the soplution provided by
https://leetcode.com/vaishnavilugade/
Intuition
The problem requires finding the single number in an array where every other
element appears twice. The XOR operation is used to efficiently find the unique
number without using extra space.
Approach
We use the XOR (^) operation to find the single number. XORing a number with itself
results in 0, so when we XOR all elements in the array, the duplicates cancel each other out,
leaving only the single number.
The XOR operation has the property that it is both commutative and associative,
so the order in which the XOR operations are performed does not matter.
Complexity
Time complexity: O(n), where n is the length of the input array. T
he algorithm iterates through the array once.
Space complexity: O(1), as the algorithm uses only a constant amount of extra space.
 */
public class SingleNumber {

  public static void main(String[] args) {
    int[] nums = {4, 1, 2, 1, 2};
    int response = singleNumber(nums);
    System.out.println(response);
  }

  public static int singleNumber(int[] nums) {
    int count = 0;
    for (int num : nums) {
      count = count ^ num;
    }
    return count;
  }
}
