package org.ferreiras.leetCode;
/*
 * You are given two 0-indexed integer arrays nums1 and nums2 of equal length n
 * and a positive integer k. You must choose a subsequence of indices from nums1 of length k.
 * For chosen indices i0, i1, ..., ik - 1, your score is defined as:
 * The sum of the selected elements from nums1 multiplied with the minimum of the selected
 * elements from nums2.
 * It can be defined simply as:
 * (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]).
 * Return the maximum possible score.
 * A subsequence of indices of an array is a set that can be derived from the set {0, 1, ..., n-1}
 * by deleting some or no elements.
 * Example 1:
 * Input: nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3
 * Output: 12
 * Explanation:
 * The four possible subsequence scores are:
 * - We choose the indices 0, 1, and 2 with score = (1+3+3) * min(2,1,3) = 7.
 * - We choose the indices 0, 1, and 3 with score = (1+3+2) * min(2,1,4) = 6.
 * - We choose the indices 0, 2, and 3 with score = (1+3+2) * min(2,3,4) = 12.
 * - We choose the indices 1, 2, and 3 with score = (3+3+2) * min(1,3,4) = 8.
 * Therefore, we return the max score, which is 12.
 * Example 2:
 * Input: nums1 = [4,2,3,1,1], nums2 = [7,5,10,9,6], k = 1
 * Output: 30
 * Explanation:
 * Choosing index 2 is optimal: nums1[2] * nums2[2] = 3 * 10 = 30 is the maximum possible score.
 */

import java.util.*;

public class MaximumSubsequenceScore {
  public static void main(String[] args) {
    int[] nums1 = {1,3,3,2};
    int[] nums2 = {7,5,10,9,6};
    int k = 1;
    long response  = maxxScore(nums1,nums2,k);
    System.out.println(response);
  }

  public static long maxxScore(int[] nums1, int[] nums2, int k) {
    List<int[]> lists = new ArrayList<>();
    for(int i=0; i<nums1.length; i++)
      lists.add(new int[]{nums2[i], nums1[i]});
    lists.sort((x, y) -> y[0] - x[0]);

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    long sumSeq = 0, ans = 0;
    for(int[] pr : lists){
      pq.add(pr[1]);
      sumSeq += pr[1];
      if( pq.size() > k ) sumSeq -= pq.remove();
      if( pq.size() == k ) ans = Math.max(ans, sumSeq*pr[0]);
    }
    return ans;
  }
  public static long maxScore(int[] numsOne, int[] numsTwo, int k) {
    int sizeOne = numsOne.length;
    int[][] pairs = new int[sizeOne][2];
    for (int i = 0; i < sizeOne; ++i) {
      pairs[i] = new int[] { numsOne[i], numsTwo[i] };
    }
    Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

    // Use a min-heap to maintain the top k elements.
//    PriorityQueue<Integer> topKHeap = new PriorityQueue<>(k, (a, b) -> a - b);
    PriorityQueue<Integer> topKHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
    long topKSum = 0;
    for (int i = 0; i < k; ++i) {
      topKSum += pairs[i][0];
      topKHeap.add(pairs[i][0]);
    }

    // The score of the first k pairs.
    long answer = topKSum * pairs[k - 1][1];

    // Iterate over every nums2[i] as minimum from nums2.
    for (int i = k; i < sizeOne; ++i) {
      // Remove the smallest integer from the previous top k elements
      // then ddd nums1[i] to the top k elements.
      topKSum += pairs[i][0] - topKHeap.poll();
      topKHeap.add(pairs[i][0]);

      // Update answer as the maximum score.
      answer = Math.max(answer, topKSum * pairs[i][1]);
    }
    return answer;
  }
}
