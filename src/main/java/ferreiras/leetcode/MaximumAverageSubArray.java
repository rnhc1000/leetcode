package ferreiras.leetcode;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer array nums consisting of n elements, and an integer k.
 * Find a contiguous subarray whose length is equal to k that has the maximum average
 * value and return this value.
 * Any answer with a calculation error less than 10-5 will be accepted.
 * Example 1:
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 * Example 2:
 * Input: nums = [5], k = 1
 * Output: 5.00000
 */
public class MaximumAverageSubArray {

  public static void main(String[] args) {
    int[] nums = {0,-4,0,-3, 2, 4};
    int k = 2;
    double result = findMaximumAverage(nums, k);
    System.out.println(result);
  }

  public static double findMaximumAverage(int[] nums, int k) {
    int sum = 0;
    for(int i = 0; i < k; i ++)
      sum += nums[i];
    int maxSum = sum;
    for(int i = k; i < nums.length; i++) {
      int diff = nums[i]-nums[i-k];
      sum += diff;
      maxSum = Math.max(maxSum, sum);
    }
    return (double)maxSum / k;
  }
  public static double findMaxAverage(int[] nums, int k) {
    DecimalFormat formatter = new DecimalFormat("#0.00000");

    int right = k;
    int countLists = 0;
    List<List<Integer>> lists = new ArrayList<>();
    for (int indexOuterList = 0; indexOuterList <= nums.length - k; indexOuterList++) {
      List<Integer> innerList = new ArrayList<>();
      for (int left = countLists; left < right; left++) {
        innerList.add(nums[left]);
      }
      countLists+=1;
      right+=1;
      lists.add(innerList);
    }
    int sum = 0, max = 0;
    for (List<Integer> l : lists) {
      for (Integer aa : l) {
        sum +=aa;
      }
      if (sum >= max) {
        max = sum;
      } else if(sum < 0) {
        max = sum;
      }
      sum = 0;
    }
    System.out.println(formatter.format(max));
    for (List<Integer> l : lists) {
      System.out.println(l);
    }
    return (double) max/k ;
  }
}
