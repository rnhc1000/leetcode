package ferreiras.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Can you solve it without sorting?
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 * Keep queue size < k, iterate over the array
 * and peek the queue at the end...
 */
public class LargestElementInArray {
  public static void main(String[] args) {
    int[] nums = {3, 2, 1, 5, 6, 4};
    int k = 2;
    int response = findKthLargest(nums, k);
    System.out.println(response);
  }

  public static int findKthLargest(int[] nums, int k) {
    Queue<Integer> pq = new PriorityQueue<>();
    for (int num : nums) {
      pq.add(num);
      if (pq.size() > k) {
        pq.remove();
      }
    }
    if (!pq.isEmpty()) {
      return pq.peek();
    } else {
      return 1;
    }
  }
}

