package org.ferreiras.leetCode;

/*
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product
 * of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * Constraints:
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * Follow up: Can you solve the problem in O(1) extra space complexity?
 * (The output array does not count as extra space for space complexity analysis.)
 */

import java.util.Arrays;
@ClassPreamble(
        author = "Ricardo Ferreira",
        date = "10/01/2024",
        currentRevision = 7,
        lastModified = "10/01/2024",
        lastModifiedBy = "Ricardo Ferreira",
        reviewers = {}
)

public class ProductOfAnArrayExceptSelf {
  public static void main(String[] args) {
    int[] array = {-1, 1, 0, -3, 3};
    System.out.println(Arrays.toString(productExceptSelf(array)));
  }

  public static int[] productExceptSelf(int[] numbers) {
    int append = 1;
    int size = numbers.length;

    int[] product = new int[size];
    int[] prefix = new int[size];
    int[] suffix = new int[size];

    prefix[0] = append;
    suffix[size - 1] = append;
    int temp = 1, j = 1;

    for (int i = 1; i < size; i++) {

      temp *= numbers[i - 1] * append;
      prefix[i] = temp;

    }

    temp = 1;
    for (int i = size - 1; i > 0; i--) {

      temp *= numbers[i] * append;
      suffix[i - 1] = temp;

    }

    for (int i = 0; i < size; i++) {

      product[i] = prefix[i] * suffix[i];

    }

    System.out.println(Arrays.toString(numbers));
    System.out.println(Arrays.toString(prefix));
    System.out.println(Arrays.toString(suffix));
    System.out.println(Arrays.toString(product));

    return product;
  }

  public static int[] productExceptSelfOne(int[] numbers) {
    int append = 1;
    int size = numbers.length;
    int[] prefixProduct = new int[size];
    int suffixProduct = 1;
    prefixProduct[0] = append;

    for (int i = 1; i < size; i++) {

      prefixProduct[i] = prefixProduct[i - 1] * numbers[i - 1];

    }
    for (int i = size - 1; i >= 0; i--) {

      prefixProduct[i] = prefixProduct[i] * suffixProduct;
      suffixProduct *= numbers[i];

    }

    return prefixProduct;
  }
}
