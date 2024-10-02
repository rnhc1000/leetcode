package org.ferreiras.leetcode;

/**
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that
 * i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 * Example 1:
 * Input: nums = [1,2,3,4,5]
 * Output: true
 * Explanation: Any triplet where i < j < k is valid.
 * Example 2:
 * Input: nums = [5,4,3,2,1]
 * Output: false
 * Explanation: No triplet exists.
 * nums = [20,100,10,12,5,13]
 * Output: true
 * PS Does not have to be contiguous
 * Nice explanation about non-contiguous solution
 * below by <a href="https://leetcode.com/Shivansu_7/">...</a>
 * Intuition
 * small is the smallest value encountered so far.
 * mid is the second smallest value encountered so far.
 * If a value is found that is smaller than or equal to small,
 * update small.
 * If a value is found that is greater than small but smaller than or equal to mid,
 * update mid.
 * If a value is found that is greater than both small and mid,
 * then we have found an increasing triplet subsequence, and the function returns true.
 * Approach
 * Initialization:
 * Initialize two variables, small and mid, to Integer.MAX_VALUE.
 * These variables will be used to keep track of the two smallest elements in the array.
 * The loop variable big will iterate through the array.
 * Iteration:
 * Iterate through the array, and for each element big, perform the following checks:
 *
 * If big is less than or equal to the current value of small, update small to be equal to big.
 * This ensures that small always holds the smallest value encountered so far.
 * If big is greater than small but less than or equal to mid, update mid to be equal to big.
 * This ensures that mid always holds the second smallest value encountered so far.
 * If big is greater than both small and mid, then we have found a triplet subsequence,
 * and the function returns true.
 * Result:
 * If the loop completes without finding a triplet subsequence, return false.
 */
public class TripletSubsequence {

  public static void main(String[] args) {
    int[] triplet = {20,100,10,12,5,13};
    boolean response = contiguousTripletSequence(triplet);
    System.out.println(response);
    response = TripletSubsequence.tripleAscendingSequence(triplet);
    System.out.println(response);


  }

  public static boolean contiguousTripletSequence(int[] triplet) {
    int size = triplet.length;
    if (size < 3) return false;
    int left = 0, right = 1;
    int count = 0;
    for (; left < size - 2; left++) {

      if (triplet[left] < triplet[right] && triplet[right] < triplet[right + 1]) {
        count+=3;
      }
      if (count == 3) {
        return true;
      }
      right+=1;
    }
    return false;
  }

  public static boolean tripleAscendingSequence(int[] triplet) {
    if (triplet == null || triplet.length < 3) return false;
    int left = Integer.MAX_VALUE;
    int right = Integer.MAX_VALUE;
    for (int triple : triplet) {
      if (triple <= left) {
        left = triple;
      } else if ( triple <= right) {
        right = triple;
      } else {
        return true;
      }
    }
    return false;
  }
}
