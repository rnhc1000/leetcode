package org.ferreiras.leetcode;

/**
 * There is a biker going on a road trip. The road trip consists of n + 1 points
 * at different altitudes. The biker starts his trip on point 0 with altitude equal 0.
 * You are given an integer array gain of length n where gain[i] is the net gain in
 * altitude between points i and i + 1 for all (0 <= i < n).
 * Return the highest altitude of a point.
 * Example 1:
 * Input: gain = [-5,1,5,0,-7]
 * Output: 1
 * Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
 * Example 2:
 * Input: gain = [-4,-3,-2,-1,4,3,2]
 * Output: 0
 * Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
 */
public class HighestAltitude {

  public static void main(String[] args) {
    int[] gain = {-5,1,5,0,-7};
    int response = largestAltitude(gain);
    System.out.println(response);
  }
  public static int largestAltitude(int[] gain) {
    int[] prefix = new int[gain.length+1];
    prefix[0] = 0;
    int max = Integer.MIN_VALUE;
    for (int left=1; left<prefix.length; left++) {
      int temp = gain[left - 1] + prefix[left - 1];
      prefix[left] = temp;
     }
    for (int k : prefix){
      max = Math.max(max, k);
    }
    return max;
  }
}
