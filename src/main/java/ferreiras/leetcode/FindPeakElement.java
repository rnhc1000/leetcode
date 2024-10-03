package ferreiras.leetcode;

/**
 * A peak element is an element that is strictly greater than its neighbors.
 * Given a 0-indexed integer array nums, find a peak element, and return its index.
 * If the array contains multiple peaks, return the index to any of the peaks.
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always
 * considered to be strictly greater than a neighbor that is outside the array.
 * You must write an algorithm that runs in O(log n) time.
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 * or index number 5 where the peak element is 6.
 */
public class FindPeakElement {
  public static void main(String[] args) {
    int[] nums = {1, 1, 3, 1,4,2};
    int k = findIndexPeakElement(nums);
    System.out.println(k);
  }

  public static int findPeakElement(int[] nums) {
    int peak = Integer.MIN_VALUE;
    int currentPeak = 0, index = 0;
    int right = nums.length - 1, mid = 0;
    for (int left = 0; left < nums.length; left++) {
//      mid = left + (right-left)/2;
      currentPeak = nums[left];
      if (currentPeak > peak) {
        peak = currentPeak;
        index = left;
      }
    }
    return index;
  }

  public static int findIndexPeakElement(int[] nums) {
    int start = 0;
    int end = nums.length - 1;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] < nums[mid + 1]) {
        start = mid + 1;
      } else
        end = mid;
    }
    return end;
  }
}
