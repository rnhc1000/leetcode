package ferreiras.leetcode;

/*
Given an array of integers nums and an integer k, return the number of contiguous
subarrays where the product of all the elements in the subarray is strictly less than k.

Example 1:
Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation:
The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

Example 2:
Input: nums = [1,2,3], k = 0
Output: 0

Constraints:

1 <= nums.length <= 3 * 104
1 <= nums[i] <= 1000
0 <= k <= 106
 */
public class ArraySubArrayProductLessThanK {
  public static void main(String[] args) {
    int[] nums = {10,5,2,6};
    int k = 100;
    int num = numSubArrayProductLessThanK(nums, k);
    System.out.println(num);
  }

  public static int numSubArrayProductLessThanK(int[] nums, int k) {
    int size = nums.length;
    int left = 0, right = 0, count = 0,  product = 1;
    for (; right< size; right++) {
      product *= nums[right];
      while (product >= k && left <= right) {
        product /= nums[left];
        left++;
      }
      count+=right-left+1;

      }

    return count;
  }
}
